import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

enum NodeType  {exp,id,literal,read,write,cond,ifSta,ifelse,elseSta;};
enum OpType {add,sub,mul,div,assign;};
enum LogicOp {and,or,not,noOp;};
enum CompOp {less,lessOrEqual,greater,greaterOrEqual,equal, notEqual,True,False,error;};

public class AstNode{
	public 	NodeType type;

}

class exp extends AstNode{

	public 	OpType opType;
	public 	AstNode left;
	public 	AstNode right;
	@Override 
		public String toString(){
			switch (opType)
			{
				case assign:return "=";
				case add:return "+";
				case sub:return "-";
				case mul:return "*";
				case div:return "/";
			}
			return "";

		}
	public IRIns getIns(Type resultType){
		if(resultType==Type.INT){

			switch (opType){

				case add:
					return IRIns.ADDI;

				case sub:
					return IRIns.SUBI;

				case mul:

					return IRIns.MULI;

				case div:

					return IRIns.DIVI;
				case assign:
					return IRIns.STOREI;

			}

		}
		else {


			switch (opType){


				case add:
					return IRIns.ADDF;

				case sub:
					return IRIns.SUBF;

				case mul:

					return IRIns.MULF;

				case div:

					return IRIns.DIVF;
				case assign:
					return IRIns.STOREF;	
			}



		}
		return IRIns.ADDI;
	}
	public IRCode genIRCode(IRCode leftCode,IRCode rightCode){

		IRCode expCode=new IRCode();
		expCode.resultType=rightCode.resultType;


		expCode.ins=getIns(expCode.resultType);
		
		if(this.opType==OpType.assign)
			expCode.setOperand(rightCode.result,null,((id)(this.left)).name); 
		 else{	
			expCode.setOperand(leftCode.result,rightCode.result,Micro.GetTmp()); 

			expCode.isALU=true;
			}
		return expCode;
	}
}

class boolExp extends AstNode{
	LogicOp	opType;
	CompOp	compOp;
	AstNode left;
	AstNode right;
public static CompOp getOpFromString(String op){

	switch(op){
	
	case ">" : return CompOp.greater;
	case ">=" : return CompOp.greaterOrEqual;
	case "<" : return CompOp.less;
	case "<=" : return CompOp.lessOrEqual;
	case "=" : return CompOp.equal;
	case "!=" : return CompOp.notEqual;

	}
	return CompOp.error;
}
@Override 
		public String toString()
		{
			return opType+":"+compOp;
		}

}
class id extends AstNode{

	public String name;
	public Type dataType;
	@Override 
		public String toString()
		{
			return name+" " + dataType;
		}
}

class literal extends AstNode{

	public Type dataType;
	public float number;
	@Override
		public String toString(){
			if(dataType==Type.INT)
				return String.valueOf( (int)number);
			return String.valueOf( number);
		}
	public float getValue(){
		if(dataType==Type.INT)
			return  (int)number;
		return  number;


	}
}
class read_write extends AstNode{
	List <id> id_list;
	@Override
		public String toString(){
			String tmp=new String();
			for(int i=0;i<id_list.size();i++)
				tmp+=id_list.get(i)+" ";
			return tmp;
		}
}

