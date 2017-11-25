import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  



public class FunctionUnit{
	private ArrayList <AstTree> funTrees=new ArrayList<AstTree>();
	private ArrayList <IRCode> funIRCode= new ArrayList<IRCode>();
	private  LinkedHashMap<String , String> registerMap= new LinkedHashMap<String,String>();
	private  ArrayList<AssemblyCode> asCode=new ArrayList<AssemblyCode> ();
	private int tmpCounter=1;
	private int localCounter=1;
	private int parCounter=1;
	private int regCounter=0;
	private Scope symbolTable;
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


		for (int i=0;i<funIRCode.size();i++){
			System.out. println ("isLead:"+ funIRCode.get(i).isLeader);	
			System.out. println ( funIRCode.get(i).IRCODE);	
			System.out. println ( funIRCode.get(i).genSet);	
			System.out. println ( funIRCode.get(i).killSet);	
			System.out. println ( "in:"+funIRCode.get(i).inSet);	
			System.out. println ("out:"+ funIRCode.get(i).outSet);	
		}


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

		/*	if(curr.pre.size()>1){
			curr.isLeader=true;
			continue ;
			}
			
			else if(curr.pre.size()==1){

				if(curr.pre.get(0) != funIRCode.get(i-1) ) {
					curr.isLeader=true;
					continue ;
				}

			}
			else if(i==funIRCode.size()-1) {
				continue;

			}
			else if( curr.succ.size()>1){
			curr.isLeader=true;
			continue ;

			}
			else if( curr.succ.size()==1) {

					if(curr.succ.get(0) != funIRCode.get(i+1) ) {
					curr.isLeader=true;
					continue ;
				}


			}
			*/
		
	
		//curr=funIRCode.get(funIRCode.size()-1);

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
	public String getPar(){	
		String tmp=new String();
		tmp="$P"+parCounter;
		parCounter++;
		return tmp;
	}
	public String getReg(){	
		String tmp=new String();
		tmp="r"+regCounter;
		regCounter++;
		return tmp;
	}
	public void addIR(IRCode var){
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
		this.addIR(lab);
		lab=new IRCode();
		lab.ins=IRIns.LINK;
		this.addIR(lab);


	}
	public void addAstTree(AstTree var){

		funTrees.add(var);
	}
	public void genFunIR(){
		for(int i=0;i<funTrees.size();i++)
			funTrees.get(i).ConvertToIR();
		//getIR(1).result=String.valueOf(localCounter-1);
		if(getIR(getIRSize()-1).ins!=IRIns.RET){

			IRCode lab=new IRCode();
			lab.ins=IRIns.RET;
			this.addIR(lab);
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
			System.out.println(";"+funIRCode.get(i).IRCODE);
		}

	}
	public void printAssembly(){
		for(int i=0;i<asCode.size();i++){

			System.out.println(asCode.get(i).ASCODE);
		}

	}
	public String getMapValue(String key){
		return registerMap.get(key);
	}
	public void putMapValue(String key,String value){
		registerMap.put(key,value);
	}
	public void removeMapValue(String key){
		registerMap.remove(key);
	}

	public  void prepCondBranchIns(IRCode code){

		AssemblyCode asscode=new AssemblyCode();
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
	}

	public  void prepAluIns(IRCode code){

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
	}
	public void genAssembly(){
		for(int i=0;i<funIRCode.size();i++){
			genAssemblyIR(funIRCode.get(i));

		}


	}
	public String mapPar(String par){
		int return_add=getReturnAdd();
		int par_ind=Integer.parseInt(par.substring(1));
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
	public  void genAssemblyIR(IRCode code){
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


}

