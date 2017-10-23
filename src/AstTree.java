import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

public class AstTree{
	public 	AstNode root;
	public boolean isTarget;
	public String label;
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
		for(int i=0;i<code.size();i++){
			code.get(i).setIRCode();
			System.out.println(";"+code.get(i).IRCODE);
		}

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
			if(tmp.resultType==Type.INT)
			tmp.result=String.format("%.0f",((literal)base).getValue());
			else{
			
		   if(((literal)base).getValue() == (long) ((literal)base).getValue())
      tmp.result= String.format("%d",(long)((literal)base).getValue());
    else
        tmp.result=String.format("%f",((literal)base).getValue()).replaceAll("\\.?0*$", "");	
			//tmp.result=String.format("%.4f",((literal)base).getValue());
			
			
			}
			return tmp;

		} else if(base.type==NodeType.cond){
			boolExp tmp=(boolExp)base;
			IRCode leftCode,rightCode,expCode;
			if(tmp.compOp!=CompOp.True && tmp.compOp!=CompOp.False){
				leftCode=convertToIR(((boolExp)base).left);
				rightCode=convertToIR (((boolExp)base).right);
				IRCode tmp2= new IRCode();
				tmp2.ins=boolExp.getInsFromComOp(tmp.compOp);
				if(leftCode.result.charAt(0)!='$')	{
					if(Character.isDigit(leftCode.result.charAt(0))){
						String reg=Micro.GetTmp();
						GenerateLoad(leftCode,reg);
						leftCode.result=reg;

					}
				}
				if(rightCode.result.charAt(0)!='$'){
					if(Character.isDigit(rightCode.result.charAt(0))){
						String reg=Micro.GetTmp();
						GenerateLoad(rightCode,reg);
						rightCode.result=reg;

					}
				}
				tmp2.resultType=leftCode.resultType;
				tmp2.op1=leftCode.result;
				tmp2.op2=rightCode.result;
				//tmp2.setOperand(leftCode.result, rightCode.result, _);
				code.add(tmp2);

			}
			else {


				if(tmp.compOp==CompOp.False){
					IRCode tmp2 = new IRCode();
					tmp2.ins=IRIns.JUMP;
					//tmp2.setIR();
					code.add(tmp2);



				}
			}



		}


		else if( base.type ==NodeType.ifSta|| base.type==NodeType.elseIf ){

			IF tmp=(IF)base;
			if(tmp.type==NodeType.elseIf){

				IRCode lab=new IRCode();
				lab.ins=IRIns.LABEL;
				lab.result=this.label;
				code.add(lab);

			}
			ArrayList<IRCode> condCode=((boolExp)(tmp.cond)).genIR();

			if(condCode.size()!=0){
				condCode.get(condCode.size()-1).result=tmp.ifLabel;
				if(condCode.get(condCode.size()-1).ins!=IRIns.JUMP)
				condCode.get(condCode.size()-1).isCondBranch=true;

			}
			for(int i=0;i<condCode.size();i++){
				this.code.add(condCode.get(i));


			}


		}else	if(base.type==NodeType.elseSta){

			IRCode lab=new IRCode();
			lab.ins=IRIns.LABEL;
			lab.result=this.label;
			code.add(lab);

		}else if(base.type==NodeType.forSta){
			FOR tmp=(FOR)base;


			ArrayList<IRCode> condCode=((boolExp)(tmp.cond)).genIR();

			if(condCode.size()!=0){
				condCode.get(condCode.size()-1).result=tmp.forLabel;
				if(condCode.get(condCode.size()-1).ins!=IRIns.JUMP)
				condCode.get(condCode.size()-1).isCondBranch=true;

			}
			for(int i=0;i<condCode.size();i++){
				this.code.add(condCode.get(i));


			}


		}
		
		else if( base.type ==NodeType.outLab){
			IRCode tmp = new IRCode();
			tmp.ins=IRIns.LABEL;
			tmp.result=this.label;
			code.add(tmp);	
		}	
		else if( base.type ==NodeType.jumpOut){
			IRCode tmp = new IRCode();
			tmp.ins=IRIns.JUMP;
			tmp.result=this.label;
			code.add(tmp);	
		}
		return null;



	}

}

