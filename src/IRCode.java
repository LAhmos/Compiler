import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  
enum IRIns{READI,READF,WRITEI,WRITEF,WRITES,ADDI,ADDF,SUBI,SUBF,MULI,MULF,DIVI,DIVF,STOREI,STOREF,GT,GE,LT,LE,EQ,NE,JUMP,LABEL;};
public class IRCode{

	public Type resultType;
	public String result;
	public String op1;
	public String op2;
	public IRIns ins;
	public String IRCODE;
	public IRCode target;
	public boolean isALU=false;
	public boolean isCondBranch=false;
	public void setOperand(String _op1,String _op2,String _op3){
		op1=_op1;
		op2=_op2;
		result=_op3;
		setIRCode();
	}
	public void setIRCode()
	{
		IRCODE=ins+ " "+ ((op1!=null)? op1+" ":"")+((op2!=null)? op2+" ":"")+ result;
		
	}

}
