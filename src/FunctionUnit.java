import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

import java.util.Random;
class Loop{

	public IRCode start;
	public IRCode end;
	public String loop_label;
	public String loop_exit_label;
	public Set<String> loopInv=new HashSet<String>();
	public ArrayList<Integer> loopExits=new ArrayList<Integer>();
	public int start_indx;
	public int end_indx;
	public boolean isInsideLoop(IRCode var) {return (var.index>start_indx&& var.index< end_indx);}
	public boolean isInsideLoop(int var) {return (var>start_indx&& var< end_indx);}
	public boolean isInv(String op) { 
		if(IRCode.defineType(op)==opType.number) 
			return true; 
		return ( loopInv.contains(op)); 
	}
	public boolean isAllDefInsideLoop ( ArrayList<Integer> var) {

		for( int i=0;i<var.size();i++){

			if( isInsideLoop(var.get(i))) return false; 

		}
		return true;
	}
	public boolean isDominatingAllExits(IRCode var){
		int ind=var.index;
		if(!isInsideLoop(ind)) return false;
		for(int i=0;i<loopExits.size();i++){
			if(ind>loopExits.get(i)) return false;

		}
		return true;

	}
	public boolean isLiveBeforeLoop(IRCode var){

		return (start.outSet.contains(var.result));

	}

}

public class FunctionUnit{
	private ArrayList <AstTree> funTrees=new ArrayList<AstTree>();
	private ArrayList <IRCode> funIRCode= new ArrayList<IRCode>();
	private  LinkedHashMap<String , Register> registerMap= new LinkedHashMap<String,Register>();
	private  ArrayList<AssemblyCode> asCode=new ArrayList<AssemblyCode> ();
	private int tmpCounter=1;
	private int localCounter=1;
	private int parCounter=1;
	private int regCounter=0;
	private Scope symbolTable;
	private ArrayList<Register> registersArray = new ArrayList<Register>();
	private  LinkedHashMap<String , String> spillMap= new LinkedHashMap<String,String>();
	private ArrayList<Loop> loops= new ArrayList<Loop>();
	public FunctionUnit(){
		for(int i=0;i<ProgramFunctions.machineReg;i++){
			registersArray.add(new Register(i)); 
		}
	}
	public String getFunName(){
		return this.symbolTable.getScopeID();

	}
	public IRCode getIRfromLabel(String label){
		for(int i=0;i<funIRCode.size();i++){
			IRCode curr = funIRCode.get(i);
			if(curr.ins==IRIns.LABEL&& curr.result.equals(label))
				return curr;

		}
		return null;

	}
	public void defineLoops (){

		for(int i=0;i<funIRCode.size();i++){
			IRCode curr = funIRCode.get(i);
			if(curr.ins==IRIns.LABEL&& curr.result.contains("_Loop")){
				Loop var= new Loop();
				var.start=curr;
				var.start_indx=i;
				String outLab=curr.result.substring(0,curr.result.indexOf("_Loop"))+"_OUT";
				System.out.println(";;; out;;;; " + outLab);
				var.loop_exit_label=outLab;
				var.loop_label=curr.result;
				var.end= getIRfromLabel(outLab);
				var.end_indx= funIRCode.indexOf(var.end);
				loops.add(var);
				defineLoopExits(var);
			}	
		}

	}
	public void defineLoopExits(Loop var){
		boolean isFirst=true;
		for(int i=var.start_indx;i<var.end_indx;i++){

			IRCode curr = funIRCode.get(i);
			if(curr.isCondBranch){
				if(isFirst) {
					isFirst=false;
					continue;
		
				}
				if( curr.result.equals(var.loop_exit_label))

					var.loopExits.add(i);

			}
			if(curr.ins==IRIns.JUMP) {
				if(isFirst) {
					isFirst=false;
					continue;
		
				}
				if(curr.result.equals(var.loop_exit_label))

					var.loopExits.add(i);
			}

		}


	}
	public boolean definedMoreThanOnce(Loop var,IRCode code){

		
		for(int i=var.start_indx;i<var.end_indx;i++){

			IRCode curr = funIRCode.get(i);
			if(curr==code) continue;
			if(curr.result.equals(code.result)) return true;
		
		
		
		}
		return false;
	}
	public void genCFG(){
		IRCode curr,target; 
		for(int i=0;i<funIRCode.size();i++){

			curr = funIRCode.get(i);
			if(i!=0){
				if(funIRCode.get(i-1).ins!=IRIns.JUMP)
					curr.addPre(funIRCode.get(i-1));
			}
			if(i!= funIRCode.size()-1){
				if(curr.ins!=IRIns.JUMP)
					curr.addSucc(funIRCode.get(i+1));
			}
			if(curr.isCondBranch || (curr.ins==IRIns.JUMP)){
				target=getIRfromLabel(curr.result);
				target.addPre(curr);
				curr.addSucc(target);
			}
		}
	}

	public void liveAnalysis(){
		IRCode curr;
		genCFG();
		defineLeaders();
		defineLoops();
		Set<IRCode> workList=new LinkedHashSet<IRCode> ();
		for (int i=funIRCode.size()-1;i>=0;i--){
			workList.add(funIRCode.get(i));
			funIRCode.get(i).setGenKill();
		}
		while(!workList.isEmpty()){

			curr = workList.iterator().next(); 
			workList.remove(curr);
			curr.calOut();
			if(curr.calIn()){
				if(curr.pre!=null)	
					for(int i=0;i<curr.pre.size();i++)
						workList.add(curr.pre.get(i));

			}
		}

		/*   for (int i=0;i<funIRCode.size();i++){
		     System.out. println ("isLead:"+ funIRCode.get(i).isLeader);	
		     System.out. println ( funIRCode.get(i).IRCODE);	
		     System.out. println ( funIRCode.get(i).genSet);	
		     System.out. println ( funIRCode.get(i).killSet);	
		     System.out. println ( "in:"+funIRCode.get(i).inSet);	
		     System.out. println ("out:"+ funIRCode.get(i).outSet);	
		     }
		 */


	}
	public void reachingAnalysis(){
		IRCode curr;
		Set<IRCode> workList=new LinkedHashSet<IRCode> ();
		for (int i=0;i<funIRCode.size();i++){
			workList.add(funIRCode.get(i));
			funIRCode.get(i).setGenKill_def();
		}
		while(!workList.isEmpty()){

			curr = workList.iterator().next(); 
			workList.remove(curr);
			curr.calIn_def();
			if(curr.calOut_def()){
				if(curr.succ!=null)	
					for(int i=0;i<curr.succ.size();i++)
						workList.add(curr.succ.get(i));

			}
		}

		for (int i=0;i<funIRCode.size();i++){
			System.out. println (";isLead:"+ funIRCode.get(i).isLeader);	
			System.out. println ( ";"+funIRCode.get(i).IRCODE);	
			System.out. println ( ";"+funIRCode.get(i).genSet_def);	
			System.out. println ( ";"+funIRCode.get(i).killSet_def);	
			System.out. println ( ";in:"+funIRCode.get(i).inSet_def);	
			System.out. println (";out:"+ funIRCode.get(i).outSet_def);	
		}

		for (int i=0;i<loops.size();i++){
			System.out. println ( ";"+loops.get(i));	
			System.out. println ( ";start:"+loops.get(i).start.IRCODE + loops.get(i).start_indx);	
			System.out. println ( ";end:"+loops.get(i).end.IRCODE+ loops.get(i).end_indx);
			for(int mm: loops.get(i).loopExits)  
			System.out. println ( ";Exit: "+mm );
		
			System.out. println ( ";---------" );
		}

		optmizeLoop(0);
	}
	public void optmizeLoop(int r){

		Loop loop= loops.get(r);
		Set<IRCode> moveCand=new LinkedHashSet<IRCode>();
		IRCode curr;
		boolean op1Inv,op2Inv;
		boolean change =true;
		while (change ){
			change =false;
			for(int i=loop.start_indx;i<loop.end_indx;i++){

				curr=funIRCode.get(i);
				if(curr.isALU ){

					op1Inv=loop.isInv(curr.op1);	
					op2Inv=loop.isInv(curr.op2);	

					if(!op1Inv) {
						if(loop.isAllDefInsideLoop(curr.findDefintions(curr.op1))){
							change = true ;
							loop.loopInv.add(curr.op1);  
							op1Inv=true;
						}
					}
					if(!op2Inv) { 
						if(loop.isAllDefInsideLoop(curr.findDefintions(curr.op2))){
							change = true ;
							loop.loopInv.add(curr.op2);  
							op2Inv=true;
						}

					}

					if( op1Inv&& op2Inv && !loop.loopInv.contains(curr.result)) { 
						change = true ;
						moveCand.add(curr);
						loop.loopInv.add(curr.result);  
					}




				}
				if( curr.ins==IRIns.STOREI || 	curr.ins==IRIns.STOREF){
					op1Inv=loop.isInv(curr.op1);
					if(!op1Inv) {
						if(loop.isAllDefInsideLoop(curr.findDefintions(curr.op1))){
							change = true ;
							loop.loopInv.add(curr.op1);  
							op1Inv=true;
						}
					}
					if( op1Inv  && !loop.loopInv.contains(curr.result)) { 
						change = true ;
						moveCand.add(curr);
						loop.loopInv.add(curr.result);  
					}


				}

				op1Inv=op2Inv= false;

			}


		}

		System.out.println("; loop inv---------- ");
		for (String curr_t : loop.loopInv) 
			System.out.println("; loop inv : "+curr_t);
		System.out.println("; loop cand --------- ");
		for (IRCode c : moveCand) 
			System.out.println("; loop cand : "+c.IRCODE);
		Set<IRCode> removeSet = new HashSet<IRCode>();
		for (IRCode c : moveCand) {

			

			if(!loop.isDominatingAllExits(c)) {
			System.out.println("; isNotmovable NT Dom " + c.IRCODE);
				removeSet.add(c); 
				continue;
			}
			if(definedMoreThanOnce(loop,c)){

				System.out.println("; isNotmovable Defined " + c.IRCODE);
				removeSet.add(c); 
				continue;



			}
			if(loop.isLiveBeforeLoop(c)){

				System.out.println("; isNotmovable LIVE " + c.IRCODE);
				removeSet.add(c); 
				continue;



			}
		

		}
		Set < IRCode> removeset2= new LinkedHashSet<IRCode>();
	for (IRCode c : removeSet){ 
		for (IRCode c2 : moveCand){
			if(c==c2) continue;
			if(c2.isALU)
			{
			if(c2.op1.equals(c.result) || c2.op2.equals(c.result))
				removeset2.add(c2);
		}
		else		
			if(c2.op1.equals(c.result) )
				removeset2.add(c2);

		}
	}
		moveCand.removeAll(removeSet);
		moveCand.removeAll(removeset2);
		for (IRCode c : moveCand) 
			System.out.println("; movable : "+ c.index+"  "+c.IRCODE);
		ArrayList<IRCode> newIR= new ArrayList<IRCode>();
		for(int i=0;i<loop.start_indx;i++){

			newIR.add(funIRCode.get(i));

		}
		for (IRCode c : moveCand) 
			newIR.add(c);

		for(int i=loop.start_indx;i<=loop.end_indx;i++) {
			if(moveCand.contains(funIRCode.get(i))) continue;
			newIR.add(funIRCode.get(i));
		}
		for(int i=loop.end_indx+1;i<funIRCode.size();i++) {

			newIR.add(funIRCode.get(i));
		}
		funIRCode=newIR;
		printIR();
liveAnalysis();



	}
	public void defineLeaders(){

		IRCode curr;
		funIRCode.get(0).isLeader=true;
		for(int i=1;i<funIRCode.size();i++){
			curr=funIRCode.get(i);

			if(curr.isCondBranch || (curr.ins==IRIns.JUMP)){
				for(int j=0;j<curr.succ.size();j++)
					curr.succ.get(j).isLeader=true;

			}
		} 

		for(int i=1;i<funIRCode.size();i++){
			curr=funIRCode.get(i);
			if(curr.isLeader) funIRCode.get(i-1).isEndOfBlock=true;

		}
		//printIR();
		funIRCode.get(funIRCode.size()-1).isEndOfBlock=true;

	}
	public String getTmp(){	
		String tmp=new String();
		tmp="$T"+tmpCounter;
		tmpCounter++;
		return tmp;
	}
	public String getLocal(){	
		String tmp=new String();
		tmp="$L"+localCounter;
		localCounter++;
		return tmp;
	}
	public String getMemTemp(){	
		String tmp=new String();
		tmp="$"+(-localCounter);
		localCounter++;
		return tmp;
	}
	public String getPar(){	
		String tmp=new String();
		tmp="$P"+parCounter;
		parCounter++;
		return tmp;
	}
	public Register getReg(String varName,IRCode code){	
		String tmp=new String();
		Register curr;
		for(int i=0;i<ProgramFunctions.machineReg;i++){
			curr=registersArray.get(i);
			if(!curr.inUse){
				curr.allocReg(varName);
				putMapValue(varName,curr);
				curr.inUse=true;
				return curr;
			}
		}
		System.out.println(";all full");
		Random rand=new Random();
		do {
			int n= rand.nextInt(ProgramFunctions.machineReg);

			curr=registersArray.get(n);
			System.out.println(";reg: "+n+" to be kicked old var : "+curr.varName );
		}
		while  ( curr.varName.equals(code.op1) || curr.varName.equals(code.op2));

		free(curr, code);
		curr.allocReg(varName);
		putMapValue(varName,curr);

		return curr;
	}
	public void printReg(){
		System.out.print(";{");
		Register curr;
		for(int i=0;i<ProgramFunctions.machineReg;i++){
			curr=registersArray.get(i);
			System.out.print("r"+i+"->"+curr.varName+"    ");
		}
		System.out.print("}\n");
	}
	public Register ensure(String op , IRCode code){
		System.out.println(";enuse()");
		printReg();
		Register var= getMapValue(op);
		if(var!=null){ 
			System.out.println(";"+ op+ " has reg:"+var.regName);
			return var;}
		var = getReg(op,code);
		// genload

		System.out.println("; "+op+" gets reg:"+var.regName);
		AssemblyCode asscode=new AssemblyCode();
		String loc= varLocater(op);
		asscode.ASCODE="move "+ loc +" "+var.regName ;

		asCode.add(asscode) ;
		return var;



	}
	public String varLocater(String var){
		opType varType=IRCode.defineType(var);
		if(varType==opType.var) return var;
		if(varType==opType.para) return mapPar(var);

		if(varType==opType.local){

			int local_ind=Integer.parseInt(var.substring(2));
			return "$"+String.valueOf(-local_ind);


		}
		if(varType==opType.ret) return "$"+String.valueOf(getReturnAdd());		
		if(varType==opType.temp) {
			if(spillMap.get(var)!=null)
				return spillMap.get(var);
			String loc=getMemTemp();
			spillMap.put(var,loc);
			return loc;

		}
		return null;
	}
	public Register ensureWithoutLoad(String op , IRCode code){
		Register var= getMapValue(op);
		if(var!=null) {System.out.println("; "+op+" has reg:"+var.regName);
			return var;}

		var = getReg(op,code);
		// genload
		System.out.println(";"+ op+ " gets reg:"+var.regName);
		return var;



	}
	public void free(Register reg, IRCode code){

		System.out.println("; freeing  reg:"+reg.regName + " is dirty: "+ reg.isDirty);
		if (reg.isDirty  )
			spillReg(reg);
		removeMapValue(reg.varName);
		reg.freeReg();

	}
	public void changeRegOwner(Register reg, String newOwner, IRCode code){
		System.out.println("; changing reg " + reg.regName+ " from "+ reg.varName+ "to "+ newOwner);
		free(reg,code);
		reg.allocReg(newOwner);
		putMapValue(newOwner,reg);

	}
	public void spillReg(Register reg){
		if(!reg.isDirty || !reg.inUse) return ;
		AssemblyCode asscode=new AssemblyCode();
		String loc=varLocater(reg.varName);
		asscode.ASCODE="move "+ reg.regName +" "+loc ;

		asCode.add(asscode) ;


	}
	public void addIR(AstTree curr,IRCode var){
		var.codeTree=curr;
		var.index=funIRCode.size();
		funIRCode.add(var);
	}
	public int getReturnAdd(){
		return ProgramFunctions.machineReg+parCounter+1;

	}
	public int getLinkSize(){
		return localCounter-1;

	}
	public void setSymbol (Scope var){
		symbolTable=var;
		IRCode lab=new IRCode();
		lab.ins=IRIns.LABEL;
		lab.result=getFunName();
		this.addIR(null,lab);
		lab=new IRCode();
		lab.ins=IRIns.LINK;
		this.addIR(null,lab);


	}
	public void addAstTree(AstTree var){

		funTrees.add(var);
	}
	public void genFunIR(){
		for(int i=0;i<funTrees.size();i++){
			funTrees.get(i).ConvertToIR();
			funTrees.get(i).findUsedVar();

		}
		//getIR(1).result=String.valueOf(localCounter-1);
		if(getIR(getIRSize()-1).ins!=IRIns.RET){

			IRCode lab=new IRCode();
			lab.ins=IRIns.RET;
			this.addIR(null,lab);
		}

	}
	public IRCode getIR(int i){
		return funIRCode.get(i);
	}
	public int getIRSize(){
		return funIRCode.size();
	}
	public void printIR(){
		for(int i=0;i<funIRCode.size();i++){
			funIRCode.get(i).setIRCode();
			//	System.out.println(";-------------------;");
			System.out.println(";"+funIRCode.get(i).IRCODE);
			//	System.out.println(";isLeader"+funIRCode.get(i).isLeader);
			//	System.out.println(";isEnd"+funIRCode.get(i).isEndOfBlock);
			//	System.out.println(";-------------------;");
		}

	}
	public void printAssembly(){
		for(int i=0;i<asCode.size();i++){

			System.out.println(asCode.get(i).ASCODE);
		}

	}
	public Register getMapValue(String key){
		return registerMap.get(key);
	}
	public void putMapValue(String key,Register value){
		registerMap.put(key,value);
	}
	public void removeMapValue(String key){
		registerMap.remove(key);
	}

	public  void prepCondBranchIns(IRCode code){

		/*	AssemblyCode asscode=new AssemblyCode();
			IRIns ins=code.ins;
			String op1=prepareVar(code.op1);
			String op2=prepareVar(code.op2);
			String result=prepareVar(code.result);
			if(op2.charAt(0)=='$'&&op2.charAt(1)=='T'){
			op2=this.getMapValue(op2);
			} else {

			AssemblyCode asscode2=new AssemblyCode();
			String tmp=getReg();
			this.putMapValue(op2,tmp);

			asscode2.ASCODE="move " + op2 + " "+tmp;
			asCode.add(asscode2);
			op2=tmp;


			}
			if(op1.charAt(0)=='$'&&op1.charAt(1)=='T'){

			op1=this.getMapValue(op1);
			}

			code.op1=op1;
			code.op2=op2;
			code.result=result;
			if(code.resultType==Type.INT)
			asscode.ASCODE="cmpi "+ code.op1 +" "+code.op2;
			else 

			asscode.ASCODE="cmpr "+ code.op1 +" "+code.op2;
			asCode.add(asscode) ;
		 */
	}

	public  void prepAluIns(IRCode code){
		/*
		   AssemblyCode asscode=new AssemblyCode();
		   IRIns ins=code.ins;
		   String op1=prepareVar(code.op1);
		   String op2=prepareVar(code.op2);
		   String result=prepareVar(code.result);
		   if(op2.charAt(0)=='$'&&op2.charAt(1)=='T'){
		   op2=this.getMapValue(op2);
		   }
		   if(op1.charAt(0)=='$'&&op1.charAt(1)=='T'){
		   this.putMapValue(result,this.getMapValue(op1));
		   result=op1=this.getMapValue(op1);
		   return;
		   }


		   if(result.charAt(0)=='$'&&result.charAt(1)=='T' ){
		   if(this.getMapValue(result)==null){

		   String tmp=getReg();
		   this.putMapValue(result,tmp);
		   result=tmp;
		   } else {
		   result=	this.getMapValue(result);


		   }
		   }

		   code.op1=op1;
		   code.op2=op2;
		   code.result=result;
		   asscode.ASCODE="move "+ prepareVar(code.op1) +" "+prepareVar(code.result);
		   asCode.add(asscode) ;
		 */
	}
	public void genAssembly(){
		for(int i=0;i<funIRCode.size();i++){
			genAssemblyIR(funIRCode.get(i));

		}
		asCode.get(1).ASCODE="link "+ String.valueOf(getLinkSize()); 


	}
	public void spillAtEndofBasic(){
		System.out.println(";spill end of basic");
		for(int j=0; j<ProgramFunctions.machineReg;j++){
			spillReg(registersArray.get(j));
			removeMapValue(registersArray.get(j).varName);
			registersArray.get(j).freeReg();
		}
	}
	public void spillGlobal(){

		for(int j=0; j<ProgramFunctions.machineReg;j++){
			if( IRCode.defineType(registersArray.get(j).varName) == opType.var){ 
				spillReg(registersArray.get(j));
				removeMapValue(registersArray.get(j).varName);
				registersArray.get(j).freeReg();
			}
		}
	}
	public String mapPar(String par){
		int return_add=getReturnAdd();
		int par_ind=Integer.parseInt(par.substring(2));
		return "$"+String.valueOf(return_add-par_ind);

	}
	public String prepareVar(String var){
		if(var==null) return null;
		if(var.length()<2) return var;
		if(var.equals("$R"))
			return "$"+String.valueOf(getReturnAdd());
		if(var.charAt(0)=='$'&&var.charAt(1)=='P'){
			int par_ind=Integer.parseInt(var.substring(2));
			return "$"+String.valueOf(getReturnAdd()-par_ind);
		}
		if(var.charAt(0)=='$'&&var.charAt(1)=='L'){
			int local_ind=Integer.parseInt(var.substring(2));
			return "$"+String.valueOf(-local_ind);
		}
		return var;

	}
	public boolean checkFunParNum(int i){
		//System.out.println(i+" fdfdff "+parCounter + (i==(parCounter-1)));
		return (i==(parCounter-1));
	}
	/*
	   public  void genAssemblyIR2(IRCode code){
	   String IRins=code.IRCODE;	
	   IRIns ins=code.ins;
	   String op1=prepareVar(code.op1);
	   String op2=prepareVar(code.op2);
	   String result=prepareVar(code.result);
	   AssemblyCode asscode=new AssemblyCode();

	   if(ins==IRIns.STOREI||ins==IRIns.STOREF){
	   boolean op1IsMem=false, resultIsMem=false;
	   if(op1.length()<2) {
	   op1IsMem=true;

	   }else {
	   if(op1.charAt(0)=='$'&& op1.charAt(1)!='T')
	   op1IsMem=true;

	   }
	   if(result.length()<2) {
	   resultIsMem=true;

	   }else {
	   if(result.charAt(0)=='$'&& result.charAt(1)!='T')
	   resultIsMem=true;

	   }



	   if(op1IsMem&& resultIsMem)
	   {
	   String tmp=getReg();
	   this.putMapValue(op1,tmp);
	   AssemblyCode tmpCode=new AssemblyCode();


	   tmpCode.ASCODE="move "+ op1 +" "+tmp ;
	   asCode.add(tmpCode);
	   asscode.ASCODE="move "+ tmp +" "+result ;

	   }else{
	   if(!op1IsMem)
	   op1=this.getMapValue(op1);
	   if(!resultIsMem){
	   String tmp=getReg();
	   this.putMapValue(result,tmp);
	   result=tmp;
	   }
	   asscode.ASCODE="move "+ op1 +" "+result ;
	   }
	   }
	   if(ins==IRIns.WRITEI){
	   asscode.ASCODE="sys writei "+ result  ;
	   }
	   if(ins==IRIns.WRITEF){

	   asscode.ASCODE="sys writer "+ result  ;
	   }
	   if(ins==IRIns.WRITES){
	   asscode.ASCODE="sys writes "+ result  ;
	   }
	   if(ins==IRIns.READI){
	   asscode.ASCODE="sys readi "+ result  ;
	   }
	   if(ins==IRIns.READF){
	   asscode.ASCODE="sys readr "+ result  ;
	   }
	   if(code.isALU)
	   {


	prepAluIns(code);
	asscode=new AssemblyCode();
	switch (ins){

		case ADDI:
			asscode.ASCODE="addi "+ code.op2 +" "+code.result ;
			break;
		case ADDF:
			asscode.ASCODE="addr "+ code.op2 +" "+code.result ;
			break;
		case SUBI:
			asscode.ASCODE="subi "+code.op2 +" "+code.result ;
			break;
		case SUBF:
			asscode.ASCODE="subr "+code.op2 +" "+code.result ;
			break;
		case MULI:
			asscode.ASCODE="muli "+code.op2 +" "+code.result ;
			break;
		case MULF:
			asscode.ASCODE="mulr "+ code.op2 +" "+code.result ;
			break;
		case DIVI:
			asscode.ASCODE="divi "+ code.op2 +" "+code.result ;
			break;
		case DIVF:
			asscode.ASCODE="divr "+ code.op2 +" "+code.result ;
			break;

	}


}
if(code.isCondBranch){

	prepCondBranchIns(code);
	switch (ins){
		case GT:

			asscode.ASCODE="jgt "+ result  ;
			break;
		case GE:

			asscode.ASCODE="jge "+ result  ;
			break;
		case LT:

			asscode.ASCODE="jlt "+ result  ;
			break;
		case LE:

			asscode.ASCODE="jle "+ result  ;
			break;
		case EQ:

			asscode.ASCODE="jeq "+ result  ;
			break;
		case NE:

			asscode.ASCODE="jne "+ result  ;
			break;


	}
}
if(ins==IRIns.JUMP){

	asscode.ASCODE="jmp "+ result  ;


}
if(ins==IRIns.LABEL){

	asscode.ASCODE= "label "+ result  ;

}
if(ins==IRIns.RET){
	AssemblyCode tmpCode=new AssemblyCode();
	tmpCode.ASCODE= "unlnk"  ;
	asCode.add(tmpCode) ;
	asscode.ASCODE= "ret " ;

}
if(ins==IRIns.LINK){


	asscode.ASCODE= "link "+ String.valueOf(getLinkSize()) ;

}
if(ins==IRIns.POP){

	if(result==null)
		asscode.ASCODE= "pop ";
	else {
		String tmp=getReg();
		this.putMapValue(result,tmp);
		result=tmp;

		asscode.ASCODE="pop "	+result ;

	}

}
if(ins==IRIns.PUSH){

	if(result==null)
		asscode.ASCODE= "push ";
	else {

		String tmp=	this.getMapValue(result);
		if(tmp!=null){

			result=tmp;
		}

		asscode.ASCODE="push "	+result ;

	}

}
if(ins==IRIns.JSR  ){

	for(int i=0;i<ProgramFunctions.machineReg;i++)
	{
		AssemblyCode tmp= new AssemblyCode();
		tmp.ASCODE="push r"	+String.valueOf(i) ;
		asCode.add(tmp) ;
	}
	asscode.ASCODE= "jsr "+( (result==null)?"":result );

	asCode.add(asscode) ;
	asscode=null;
	for(int i=ProgramFunctions.machineReg-1;i>=0;i--)
	{
		AssemblyCode tmp= new AssemblyCode();
		tmp.ASCODE="pop r"	+String.valueOf(i) ;
		asCode.add(tmp) ;
	}
}
if(asscode!=null)
	asCode.add(asscode) ;

	}

*/
public  void genAssemblyIR(IRCode code){
	IRIns ins=code.ins;
	System.out.println(";"+code.IRCODE);
	AssemblyCode asscode=new AssemblyCode();
	Register op1,op2,result;
	if(ins==IRIns.STOREI||ins==IRIns.STOREF){
		if(code.op1Type!=opType.number){
			op1=ensure(code.op1,code );

		}
		else {
			op1=new Register(-1);
			op1.regName=code.op1;

		}
		if(code.result!="$R"){
			result = ensureWithoutLoad(code.result,code);
			result.isDirty=true;

			asscode.ASCODE="move "+ op1.regName +" "+result.regName ;
			asCode.add(asscode) ;
			asscode=null;
			if(!code.outSet.contains(code.op1) && code.op1Type!=opType.number){
				free(op1,code);
			}
			if(!code.outSet.contains(code.result)){

				free(result,code);

			}
			if(code.isEndOfBlock) spillAtEndofBasic();

		}else {

			asscode.ASCODE="move "+ op1.regName +" "+varLocater(code.result) ;


		}

	}
	if(ins==IRIns.WRITEI){
		result=ensure(code.result,code);
		if(!code.outSet.contains(code.result)){

			free(result,code);

		}

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode.ASCODE="sys writei "+ result.regName  ;
	}
	if(ins==IRIns.WRITEF){

		result=ensure(code.result,code);
		if(!code.outSet.contains(code.result)){
			free(result,code);
		}

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode.ASCODE="sys writer "+ result.regName;
	}
	if(ins==IRIns.WRITES){
		//	result=ensure(code.result,code);
		//	if(!code.outSet.contains(code.result)){
		//		free(result,code);
		//	}

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode.ASCODE="sys writes "+   code.result;
	}
	if(ins==IRIns.READI){
		result=ensureWithoutLoad(code.result,code);
		result.isDirty=true;

		asscode.ASCODE="sys readi "+  result.regName;
		asCode.add(asscode) ;
		if(!code.outSet.contains(code.result)){
			free(result,code);
		}


		asscode=null;
		if(code.isEndOfBlock) spillAtEndofBasic();

	}
	if(ins==IRIns.READF){
		result=ensureWithoutLoad(code.result,code);
		result.isDirty=true;


		asscode.ASCODE="sys readr "+  result.regName;
		asCode.add(asscode) ;
		if(!code.outSet.contains(code.result)){
			free(result,code);
		}

		asscode=null;
		if(code.isEndOfBlock) spillAtEndofBasic();
	}
	if(code.isALU)
	{

		//	if(code.op1Type!=opType.number){
		op1=ensure(code.op1,code );

		//	}
		op2=ensure(code.op2,code );
		changeRegOwner(op1,code.result,code);
		op1.isDirty=true;


		switch (ins){

			case ADDI:
				asscode.ASCODE="addi "+op2.regName+" "+op1.regName;
				break;
			case ADDF:
				asscode.ASCODE="addr "+op2.regName+" "+op1.regName;
				break;
			case SUBI:
				asscode.ASCODE="subi "+op2.regName+" "+op1.regName;
				break;
			case SUBF:
				asscode.ASCODE="subr "+op2.regName+" "+op1.regName;
				break;
			case MULI:
				asscode.ASCODE="muli "+op2.regName+" "+op1.regName;
				break;
			case MULF:
				asscode.ASCODE="mulr "+op2.regName+" "+op1.regName;
				break;
			case DIVI:
				asscode.ASCODE="divi "+op2.regName+" "+op1.regName;
				break;
			case DIVF:
				asscode.ASCODE="divr "+op2.regName+" "+op1.regName;
				break;

		}

		asCode.add(asscode) ;
		asscode=null;
		if(!code.outSet.contains(code.result)){
			System.out.println(";freeing " + code.result + "  " + op1.regName);
			free(op1,code);
		}

		if(!code.outSet.contains(code.op2) && op2.varName.equals(code.op2)){

			free(op2,code);

		}
		if(code.isEndOfBlock) spillAtEndofBasic();

	}
	if(code.isCondBranch){

		//prepCondBranchIns(code);

		op1=ensure(code.op1,code );
		op2=ensure(code.op2,code );

		if(code.resultType==Type.INT)
			asscode.ASCODE="cmpi "+ op1.regName +" "+op2.regName;
		else 

			asscode.ASCODE="cmpr "+ op1.regName +" "+op2.regName;
		asCode.add(asscode) ;
		if(!code.outSet.contains(code.op1)){
			free(op1,code);
		}

		if(!code.outSet.contains(code.op2)){

			free(op2,code);

		}

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode=new AssemblyCode();
		switch (ins){
			case GT:

				asscode.ASCODE="jgt "+ code.result  ;
				break;
			case GE:

				asscode.ASCODE="jge "+ code.result  ;
				break;
			case LT:

				asscode.ASCODE="jlt "+ code.result  ;
				break;
			case LE:

				asscode.ASCODE="jle "+ code.result  ;
				break;
			case EQ:

				asscode.ASCODE="jeq "+ code.result  ;
				break;
			case NE:

				asscode.ASCODE="jne "+ code.result  ;
				break;


		}
	}
	if(ins==IRIns.JUMP){

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode.ASCODE="jmp "+ code.result  ;


	}
	if(ins==IRIns.LABEL){

		if(code.isEndOfBlock) spillAtEndofBasic();
		asscode.ASCODE= "label "+ code.result  ;

	}
	if(ins==IRIns.RET){
		AssemblyCode tmpCode=new AssemblyCode();
		tmpCode.ASCODE= "unlnk"  ;
		asCode.add(tmpCode) ;
		asscode.ASCODE= "ret " ;

	}
	if(ins==IRIns.LINK){


		asscode.ASCODE= "link "+ String.valueOf(getLinkSize()) ;

	}
	if(ins==IRIns.POP){

		if(code.result==null)
			asscode.ASCODE= "pop ";
		else {
			result=ensureWithoutLoad(code.result,code);
			result.isDirty=true;

			asscode.ASCODE="pop "	+result.regName ;
			asCode.add(asscode) ;
			asscode=null;
			if(!code.outSet.contains(code.result)){
				free(result,code);
			}
		}

	}
	if(ins==IRIns.PUSH){

		if(code.result==null)
			asscode.ASCODE= "push ";
		else {

			result=ensure(code.result,code);
			if(!code.outSet.contains(code.result)){
				free(result,code);
			}

			asscode.ASCODE="push "	+result.regName ;

		}

	}
	if(ins==IRIns.JSR  ){
		spillGlobal();
		for(int i=0;i<ProgramFunctions.machineReg;i++)
		{
			AssemblyCode tmp= new AssemblyCode();
			tmp.ASCODE="push r"	+String.valueOf(i) ;
			asCode.add(tmp) ;
		}
		asscode.ASCODE= "jsr "+( (code.result==null)?"":code.result );

		asCode.add(asscode) ;
		asscode=null;
		for(int i=ProgramFunctions.machineReg-1;i>=0;i--)
		{
			AssemblyCode tmp= new AssemblyCode();
			tmp.ASCODE="pop r"	+String.valueOf(i) ;
			asCode.add(tmp) ;
		}
	}
	if(asscode!=null)
		asCode.add(asscode) ;

}


}

