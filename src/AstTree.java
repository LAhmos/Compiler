import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

public class AstTree{
	public 	AstNode root;
	ArrayList <IRCode> code=new ArrayList<IRCode>();
	public void printroot(){
		print (root);
	}
	public void print(AstNode _base){
		if(_base==null ) return;
		System.out.println(_base.toString());

		if(_base.type==NodeType.exp){
			print( ((exp)_base).left);
			print( ((exp)_base).right);
		}


		if(_base.type==NodeType.cond){
			print( ((boolExp)_base).left);
			print( ((boolExp)_base).right);
		} 



	}
	public void printIR(){
		for(int i=0;i<code.size();i++)
			System.out.println(";"+code.get(i).IRCODE);


	}
	public void ConvertToIR(){
		convertToIR(root);
	}
	public void GenerateLoad (IRCode symbol,String reg){
		IRCode tmp=new IRCode();
		tmp.result =reg;
		tmp.resultType=symbol.resultType;
		if(tmp.resultType==Type.INT)
			tmp.ins=IRIns.STOREI;
		else 
			tmp.ins=IRIns.STOREF;
		tmp.setOperand(symbol.result,null,reg);

		code.add(tmp);
	}
	public IRCode convertToIR(AstNode base){


		if(base==null) return null ;


		if(base.type==NodeType.exp){
			IRCode expCode,leftCode=null,rightCode;
			if( ((exp)base).opType!=OpType.assign)
				leftCode=convertToIR( ((exp)base).left);

			rightCode=convertToIR( ((exp)base).right);
			if (((exp)base).opType==OpType.assign){
				if(Micro.registerMap.get( ((id)(((exp)base).left)).name)!=null)
					Micro.registerMap.remove(((id)(((exp)base).left)).name);

			}
			else if(leftCode.result.charAt(0)!='$')	{
				if(Character.isDigit(leftCode.result.charAt(0))){
					String reg=Micro.GetTmp();
					GenerateLoad(leftCode,reg);
					leftCode.result=reg;

				}
				/*else if(Micro.registerMap.get(leftCode.result)==null){
				  String reg=Micro.GetTmp();
				  Micro.registerMap.put(leftCode.result,reg);
				  GenerateLoad(leftCode,reg);
				  leftCode.result=reg;
				  }
				  else {

				  leftCode.result=Micro.registerMap.get(leftCode.result);

				  }*/
			}
			if(rightCode.result.charAt(0)!='$'){
				if(Character.isDigit(rightCode.result.charAt(0))){
					String reg=Micro.GetTmp();
					GenerateLoad(rightCode,reg);
					rightCode.result=reg;

				}
				/*else if(Micro.registerMap.get(rightCode.result)==null){
				  String reg=Micro.GetTmp();
				  Micro.registerMap.put(rightCode.result,reg);
				  GenerateLoad(rightCode,reg);
				  rightCode.result=reg;


				  }
				  else {

				  rightCode.result=Micro.registerMap.get(rightCode.result);

				  }*/
			}
			expCode=((exp)base).genIRCode(leftCode,rightCode);
			code.add(expCode);
			return expCode;

		}

		else if(base.type==NodeType.read)  {

			for(int i=0;i<((read_write)base).id_list.size();i++)
			{
				IRCode tmp=new IRCode();
				tmp.resultType=((read_write)base).id_list.get(i).dataType;

				if(tmp.resultType==Type.INT)
					tmp.ins= IRIns.READI;			
				else 
					tmp.ins= IRIns.READF;
				tmp.setOperand(null,null,((read_write)base).id_list.get(i).name);
				code.add(tmp);		

			}

		}
		else if(base.type==NodeType.write){

			for(int i=0;i<((read_write)base).id_list.size();i++)
			{
				IRCode tmp=new IRCode();
				tmp.resultType=((read_write)base).id_list.get(i).dataType;

				if(tmp.resultType==Type.INT)
					tmp.ins= IRIns.WRITEI;			
				else if(tmp.resultType==Type.FLOAT)
					tmp.ins= IRIns.WRITEF;
				else
					tmp.ins= IRIns.WRITES;
				tmp.setOperand(null,null,((read_write)base).id_list.get(i).name);
				code.add(tmp);		


			}

		}else if(base.type==NodeType.id) {

			IRCode tmp=new IRCode();
			tmp.resultType=((id)base).dataType;
			tmp.result=((id)base).name;
			return tmp;

		} else if(base.type==NodeType.literal){

			IRCode tmp=new IRCode();
			tmp.resultType=((literal)base).dataType;
			tmp.result=String.valueOf(((literal)base).getValue());
			return tmp;

		}
		return null;


	}

}

