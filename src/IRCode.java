import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  
enum IRIns{READI,READF,WRITEI,WRITEF,WRITES,ADDI,ADDF,SUBI,SUBF,MULI,MULF,DIVI,DIVF,STOREI,STOREF,GT,GE,LT,LE,EQ,NE,JUMP,LABEL,JSR,PUSH,POP,RET,LINK;};
enum opType {number,local,para,var,ret,temp;};
public class IRCode{

	public Type resultType;
	public String result;
	public String op1;
	public String op2;
	public opType op1Type;
	public opType op2Type;
	public opType resType;
	public IRIns ins;
	public String IRCODE;
	public ArrayList<IRCode> pre ;
	public ArrayList<IRCode> succ ;
	public boolean isALU=false;
	public boolean isCondBranch=false;
	public boolean isLeader=false;
	public boolean isEndOfBlock=false;
	public AstTree codeTree;
	public int index;
	public Set<String> genSet= new HashSet<String>();
	public Set<String> killSet=new HashSet<String>();
	public Set<String> inSet = new HashSet<String>();
	public Set<String> outSet = new HashSet<String>();
	public Set<IRCode> genSet_def	=new HashSet<IRCode>();
	public Set<IRCode> killSet_def	=new HashSet<IRCode>();
	public Set<IRCode> inSet_def 	=new HashSet<IRCode>();
	public Set<IRCode> outSet_def 	=new HashSet<IRCode>();
	public void addPre(IRCode var){
		if(pre==null) pre = new ArrayList<IRCode>();
		pre.add(var);

	}
	public void addSucc(IRCode var){
		if(succ==null) succ = new ArrayList<IRCode>();
		succ.add(var);

	}
	public void calOut(){
		if(ins==IRIns.RET) return;

		for(int i=0;i<succ.size();i++)
			outSet.addAll(succ.get(i).inSet);


	}
	public boolean calIn(){


		Set<String> newInSet= new HashSet<String>(outSet);
		newInSet.removeAll(killSet);
		newInSet.addAll(genSet);

		if(!equals(newInSet,inSet)){
			inSet=newInSet;
			return true;
		}
		return false;


	}
	public void calIn_def(){
		if(pre==null) return;
		for(int i=0;i<pre.size();i++)
			inSet_def.addAll(pre.get(i).outSet_def);


	}
	public boolean calOut_def(){


		Set<IRCode> newOutSet= new HashSet<IRCode>(inSet_def);

		Set<IRCode> kill= new HashSet<IRCode>();
		for (IRCode curr : genSet_def) {
			String output=curr.result;
			for( IRCode curr2: newOutSet){
			if(curr2.result.equals(output))
				kill.add(curr2);
			}
		}
		
		newOutSet.removeAll(kill);
		newOutSet.addAll(genSet_def);

		if(!equals2(newOutSet,outSet_def)){
			outSet_def=newOutSet;
			return true;
		}
		return false;


	}
	public ArrayList<Integer> findDefintions(String op){
		ArrayList <Integer> returnList= new ArrayList<Integer>();
			
		for (IRCode curr : outSet_def) {
			
			if(curr.result.equals(op))
				returnList.add(curr.index);
			
		}
	return returnList;

	}
	public static opType defineType(String op1){

		if(op1!=null){
			if(op1.charAt(0)=='$'){
				if(op1.charAt(1)=='L')
					return opType.local;
				if(op1.charAt(1)=='P')
					return opType.para;
				if(op1.charAt(1)=='R')
					return opType.ret;
			if(op1.charAt(1)=='T')
					return opType.temp;


			} else if(Character.isDigit(op1.charAt(0))){

				return opType.number;

			} else 
				 return opType.var;

		}
				 return opType.var;

	}
	public void setOpType(){

		if(op1!=null){
			if(op1.charAt(0)=='$'){
				if(op1.charAt(1)=='L')
					op1Type=opType.local;
				if(op1.charAt(1)=='P')
					op1Type=opType.para;
				if(op1.charAt(1)=='R')
					op1Type=opType.ret;
if(op1.charAt(1)=='T')
					op1Type=opType.temp;


			} else if(Character.isDigit(op1.charAt(0))){

				op1Type=opType.number;

			} else 
				op1Type=opType.var;

		}
		if(op2!=null){
			if(op2.charAt(0)=='$'){
				if(op2.charAt(1)=='L')
					op2Type=opType.local;
				if(op2.charAt(1)=='P')
					op2Type=opType.para;
				if(op2.charAt(1)=='R')
					op2Type=opType.ret;
	if(op2.charAt(1)=='T')
					op2Type=opType.temp;


			} else if(Character.isDigit(op2.charAt(0))){

				op2Type=opType.number;

			} else 
				op2Type=opType.var;

		}

		if(result!=null){
			if(result.charAt(0)=='$'){
				if(result.charAt(1)=='L')
					resType=opType.local;
				if(result.charAt(1)=='P')
					resType=opType.para;
				if(result.charAt(1)=='R')
					resType=opType.ret;
				if(result.charAt(1)=='T')
					resType=opType.temp;


			} else if(Character.isDigit(result.charAt(0))){

				resType=opType.number;

			} else 
				resType=opType.var;

		}



	}
		public static boolean equals2(Set<IRCode> set1, Set<IRCode> set2){

		if(set1 == null || set2 ==null){
			return false;
		}

		if(set1.size()!=set2.size()){
			return false;
		}

		return set1.containsAll(set2);

	}
	public static boolean equals(Set<String> set1, Set<String> set2){

		if(set1 == null || set2 ==null){
			return false;
		}

		if(set1.size()!=set2.size()){
			return false;
		}

		return set1.containsAll(set2);

	}
	public void setGenKill(){
		setOpType();
		if(isALU){
			killSet.add(result);
			if(op1Type!=opType.number)
			genSet.add(op1);
			if(op2Type!=opType.number)
			genSet.add(op2);
		}
		if(isCondBranch){
			if(op1Type!=opType.number)
			genSet.add(op1);
			if(op2Type!=opType.number)
			genSet.add(op2);

		}
		if(ins==IRIns.READI || ins==IRIns.READF){
			killSet.add(result);
		}
		if(ins==IRIns.WRITEI ||ins==IRIns.WRITES || ins==IRIns.WRITEF){
			genSet.add(result);
		}
		if(ins==IRIns.STOREI || ins==IRIns.STOREF){
			killSet.add(result);
			if(op1Type!=opType.number)
			genSet.add(op1);
		}
		if(ins==IRIns.POP){
			if(result!=null)
			killSet.add(result);
		}
		if(ins==IRIns.PUSH){
			if(result!=null)
			genSet.add(result);

		}
		if(ins==IRIns.RET){

			//genSet.add("$R");

		}
	}
	public void setGenKill_def(){
		if(isALU){
			genSet_def.add(this);
		}
		if(ins==IRIns.READI || ins==IRIns.READF){
			genSet_def.add(this);
		}
		if(ins==IRIns.STOREI || ins==IRIns.STOREF){
			genSet_def.add(this);
		}
		if(ins==IRIns.POP){
			if(result!=null)
			genSet_def.add(this);
		}
		
		
	}
	public void setOperand(String _op1,String _op2,String _op3){
		op1=_op1;
		op2=_op2;
		result=_op3;
		setIRCode();
	}
	public void setIRCode()
	{
		IRCODE=ins+ " "+ ((op1!=null)? op1+" ":"")+((op2!=null)? op2+" ":"")+ ((result!=null)? result:"");

	}

}
