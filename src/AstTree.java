import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

public class AstTree{
	public 	AstNode root;
	public boolean isTarget;
	public String label;
	private FunctionUnit fun;
	public Set<String> usedVar= new HashSet<String>();
	public static int counter=0;
	public static String getLabel(){
		String label="cond_Label"+counter;
		counter++;
		return label;

	}
	public void setFun(FunctionUnit var){
		fun=var;

	}
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
	public void findUsedVar(){
		findUsedVar2(root);

	}

	public void findUsedVar2(AstNode _base){

		if(_base==null ) return;
		//System.out.println(_base.toString());


		if(_base.type==NodeType.exp){
			findUsedVar2( ((exp)_base).left);
			findUsedVar2( ((exp)_base).right);
		}
		if ( _base.type==NodeType.id){
			Symbol var = ((id)_base).getSymbol();
			if( var.getScopeType() == ScopeType.Global)
				usedVar.add(((id)_base).getName());
			else {
				usedVar.add(var.getStackLabel());
					
			}		
		
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

		fun.addIR(this,tmp);
	}
	public IRCode convertToIR(AstNode base){


		if(base==null) return null ;


		if(base.type==NodeType.exp){

			IRCode expCode,leftCode=null,rightCode;
			if( ((exp)base).opType!=OpType.assign)
				leftCode=convertToIR( ((exp)base).left);

			rightCode=convertToIR( ((exp)base).right);
			if (((exp)base).opType==OpType.assign){
				if(fun.getMapValue( ((id)(((exp)base).left)).getName())!=null)
					fun.removeMapValue(((id)(((exp)base).left)).getName());

			}
			else if(leftCode.result.charAt(0)!='$')	{
				if(Character.isDigit(leftCode.result.charAt(0))){
					String reg=fun.getTmp();
					GenerateLoad(leftCode,reg);
					leftCode.result=reg;

				}
				/*else if(fun.getMapValue(leftCode.result)==null){
				  String reg=fun.getTmp();
				  fun.putMapValue(leftCode.result,reg);
				  GenerateLoad(leftCode,reg);
				  leftCode.result=reg;
				  }
				  else {

				  leftCode.result=fun.getMapValue(leftCode.result);

				  }*/
			}
			if(rightCode.result.charAt(0)!='$'){
				if(Character.isDigit(rightCode.result.charAt(0))){
					String reg=fun.getTmp();
					GenerateLoad(rightCode,reg);
					rightCode.result=reg;

				}
				/*else if(fun.getMapValue(rightCode.result)==null){
				  String reg=fun.getTmp();
				  fun.putMapValue(rightCode.result,reg);
				  GenerateLoad(rightCode,reg);
				  rightCode.result=reg;


				  }
				  else {

				  rightCode.result=fun.getMapValue(rightCode.result);

				  }*/
			}
			expCode=((exp)base).genIRCode(leftCode,rightCode,fun);
			fun.addIR(this,expCode);
			return expCode;

		}

		else if(base.type==NodeType.read)  {

			for(int i=0;i<((read_write)base).id_list.size();i++)
			{
				IRCode tmp=new IRCode();
				tmp.resultType=((read_write)base).id_list.get(i).getType();

				if(tmp.resultType==Type.INT)
					tmp.ins= IRIns.READI;			
				else 
					tmp.ins= IRIns.READF;
				tmp.setOperand(null,null,((read_write)base).id_list.get(i).getName());
				fun.addIR(this,tmp);	

			}

		}
		else if(base.type==NodeType.write){

			for(int i=0;i<((read_write)base).id_list.size();i++)
			{
				IRCode tmp=new IRCode();
				tmp.resultType=((read_write)base).id_list.get(i).getType();

				if(tmp.resultType==Type.INT)
					tmp.ins= IRIns.WRITEI;			
				else if(tmp.resultType==Type.FLOAT)
					tmp.ins= IRIns.WRITEF;
				else
					tmp.ins= IRIns.WRITES;
				tmp.setOperand(null,null,((read_write)base).id_list.get(i).getName());

				fun.addIR(this,tmp);	


			}

		}else if(base.type==NodeType.id) {

			IRCode tmp=new IRCode();
			Symbol var = ((id)base).getSymbol();
			tmp.resultType=((id)base).getType();
			if( var.getScopeType() == ScopeType.Global)
				tmp.result=((id)base).getName();
			else {
				if(var.getStackLabel()!=null)
					tmp.result=var.getStackLabel();
				else 
					var.setStackLabel(tmp.result=fun.getLocal());

			}
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
			String reg=fun.getTmp();
			GenerateLoad(tmp,reg);
			tmp.result=reg;
			return tmp;

		} else if(base.type==NodeType.cond){
			boolExp tmp=(boolExp)base;
			IRCode leftCode,rightCode,expCode;
			if(root==base && (tmp.opType==LogicOp.noOp || tmp.opType==LogicOp.not ) &&  (tmp.compOp!=CompOp.False) && (tmp.compOp!=CompOp.True)){
				leftCode=convertToIR(((boolExp)base).left);
				rightCode=convertToIR (((boolExp)base).right);
				IRCode tmp2= new IRCode();
				if(tmp.opType!=LogicOp.not){
				tmp2.ins=boolExp.getInsFromComOp(tmp.compOp);
						tmp2.isCondBranch=true;		
				}
				else
				tmp2.ins=boolExp.getInsFromComOpWithNot(tmp.compOp);
				tmp2.resultType=leftCode.resultType;
				tmp2.op1=leftCode.result;
				tmp2.op2=rightCode.result;
			
				tmp2.result="-*f";
				fun.addIR(this,tmp2);

				return null;
			}
				if(tmp.compOp==CompOp.False){
					IRCode tmp2 = new IRCode();
					tmp2.ins=IRIns.STOREI;
					tmp2.op1="0";
					String reg=fun.getTmp();
					//tmp2.setIR();
					tmp2.resultType=Type.INT;
					tmp2.result=reg;
					fun.addIR(this,tmp2);	
					return tmp2;


				}

			else	if(tmp.compOp==CompOp.True){
					IRCode tmp2 = new IRCode();
					tmp2.ins=IRIns.STOREI;
					tmp2.op1="1";
					String reg=fun.getTmp();
					//tmp2.setIR();
					tmp2.resultType=Type.INT;
					tmp2.result=reg;
					fun.addIR(this,tmp2);	
					return tmp2;


				}
			else if(tmp.opType==LogicOp.noOp || tmp.opType==LogicOp.not ){
				leftCode=convertToIR(((boolExp)base).left);
				rightCode=convertToIR (((boolExp)base).right);
				IRCode tmp2= new IRCode();
				if(tmp.opType!=LogicOp.not){
				tmp2.ins=boolExp.getInsFromComOp(tmp.compOp);
								
				}
				else
				tmp2.ins=boolExp.getInsFromComOpWithNot(tmp.compOp);
				String label1,label2;
				tmp2.isCondBranch=true;
				tmp2.resultType=Type.INT;
				tmp2.op1=leftCode.result;
				tmp2.op2=rightCode.result;
			
				tmp2.result=label1=getLabel();
				label2=getLabel();
				fun.addIR(this,tmp2);

				IRCode tmp3= new IRCode();
				tmp3.ins=IRIns.STOREI;
				tmp3.op1="1";
				String reg=fun.getTmp();

				tmp3.resultType=Type.INT;
				tmp3.result=reg;
				fun.addIR(this,tmp3);

				tmp3= new IRCode();
				tmp3.ins=IRIns.JUMP;
				tmp3.result=label2;
				fun.addIR(this,tmp3);


				tmp3= new IRCode();
				tmp3.ins=IRIns.LABEL;
				tmp3.result=tmp2.result;
				fun.addIR(this,tmp3);
				tmp3= new IRCode();
				tmp3.ins=IRIns.STOREI;
				tmp3.op1="0";
				tmp3.resultType=Type.INT;
				tmp3.result=reg;
				fun.addIR(this,tmp3);
				IRCode tmp4= new IRCode();
				tmp4.ins=IRIns.LABEL;
				tmp4.result=label2;
				fun.addIR(this,tmp4);
				return tmp3;


			}
			else if(tmp.opType==LogicOp.and ){
				leftCode=convertToIR(((boolExp)base).left);
				rightCode=convertToIR (((boolExp)base).right);
				IRCode tmp2= new IRCode();
			
				tmp2.ins=IRIns.MULI;
				tmp2.isALU=true;
				
				tmp2.resultType=Type.INT;
				tmp2.op1=leftCode.result;
				tmp2.op2=rightCode.result;
				String reg=fun.getTmp();
				tmp2.result=reg;
				fun.addIR(this,tmp2);
				return tmp2;

			}
			else if(tmp.opType==LogicOp.or ){
				leftCode=convertToIR(((boolExp)base).left);
				rightCode=convertToIR (((boolExp)base).right);
				IRCode tmp2= new IRCode();
			
				tmp2.ins=IRIns.ADDI;
				tmp2.isALU=true;
				
				tmp2.resultType=Type.INT;
				tmp2.op1=leftCode.result;
				tmp2.op2=rightCode.result;
				String reg=fun.getTmp();
				tmp2.result=reg;
				fun.addIR(this,tmp2);
				return tmp2;

			}
			
			

			



		}


		else if( base.type ==NodeType.ifSta|| base.type==NodeType.elseIf ){

			IF tmp=(IF)base;
			if(tmp.type==NodeType.elseIf){

				IRCode lab=new IRCode();
				lab.ins=IRIns.LABEL;
				lab.result=this.label;
				fun.addIR(this,lab);	

			}
			IRCode condResult=((boolExp)(tmp.cond)).genIR(fun);
			if(condResult!=null){			
			IRCode tmp2= new IRCode();
			IRCode tmp3= new IRCode();
				tmp3.ins=IRIns.STOREI;
				tmp3.op1="0";
				String reg=fun.getTmp();
				tmp3.result=reg;
				fun.addIR(this,tmp3);
				tmp2.ins=IRIns.EQ;
				tmp2.isCondBranch=true;
				tmp2.resultType=Type.INT;
				tmp2.op1=reg;
				tmp2.op2=condResult.result;
			
				tmp2.result=tmp.ifLabel;
				fun.addIR(this,tmp2);
			}
else{
				if(fun.getIR(fun.getIRSize()-1).result.equals("-*f"));
				fun.getIR(fun.getIRSize()-1).result=tmp.ifLabel;

}
			/*if(fun.getIRSize()!=0){
				if(fun.getIR(fun.getIRSize()-1).result.equals("-*f"));
				fun.getIR(fun.getIRSize()-1).result=tmp.ifLabel;
				if(fun.getIR(fun.getIRSize()-1).ins!=IRIns.JUMP)
					fun.getIR(fun.getIRSize()-1).isCondBranch=true;

			}*/
			/*	for(int i=0;i<condCode.size();i++){


				fun.addIR(this,condCode.get(i));	

				}
			 */

		}else	if(base.type==NodeType.elseSta){

			IRCode lab=new IRCode();
			lab.ins=IRIns.LABEL;
			lab.result=this.label;
			fun.addIR(this,lab);	
		}else if(base.type==NodeType.forSta){
			FOR tmp=(FOR)base;


			IRCode condResult=((boolExp)(tmp.cond)).genIR(fun);
			if(condResult!=null){			
			IRCode tmp2= new IRCode();
			IRCode tmp3= new IRCode();
				tmp3.ins=IRIns.STOREI;
				tmp3.op1="0";
				String reg=fun.getTmp();
				tmp3.result=reg;
				fun.addIR(this,tmp3);
				tmp2.ins=IRIns.EQ;
				tmp2.isCondBranch=true;
				tmp2.resultType=Type.INT;
				tmp2.op1=reg;
				tmp2.op2=condResult.result;
			
				tmp2.result=tmp.forLabel;
				fun.addIR(this,tmp2);
			}
else{
				if(fun.getIR(fun.getIRSize()-1).result.equals("-*f"));
				fun.getIR(fun.getIRSize()-1).result=tmp.forLabel;

}


			/*if(fun.getIRSize()!=0){
				if(fun.getIR(fun.getIRSize()-1).result.equals("-*f"));
				fun.getIR(fun.getIRSize()-1).result=tmp.forLabel;
				if(fun.getIR(fun.getIRSize()-1).ins!=IRIns.JUMP)
					fun.getIR(fun.getIRSize()-1).isCondBranch=true;

			}
			*/
			/*	for(int i=0;i<condCode.size();i++){
				fun.addIR(this,condCode.get(i));	

				}
			 */

		}

		else if( base.type ==NodeType.outLab){
			IRCode tmp = new IRCode();
			tmp.ins=IRIns.LABEL;
			tmp.result=this.label;
			fun.addIR(this,tmp);	
		}	
		else if( base.type ==NodeType.jumpOut){
			IRCode tmp = new IRCode();
			tmp.ins=IRIns.JUMP;
			tmp.result=this.label;
			fun.addIR(this,tmp);	
		}
		else if(base.type==NodeType.call_exp){
			call_exp node=(call_exp)base;
			ArrayList<String> result=new ArrayList<String>();
			IRCode tmp ;
			 tmp = new IRCode();
			tmp.ins=IRIns.PUSH;
			fun.addIR(this,tmp);
			for(int i=0;i<node.getParListSize();i++){
				String res=convertToIR(node.parList.get(i)).result;				
				tmp = new IRCode();
				tmp.ins=IRIns.PUSH;
				tmp.result=res;
				fun.addIR(this,tmp);
			}
			
			tmp = new IRCode();
			tmp.ins=IRIns.JSR;
			tmp.result=node.getFunName();
			fun.addIR(this,tmp);
			for(int i=0;i<node.getParListSize();i++){		
				tmp = new IRCode();
				tmp.ins=IRIns.POP;
				fun.addIR(this,tmp);
			}
			tmp = new IRCode();
			tmp.ins=IRIns.POP;
			tmp.result=fun.getTmp();
			fun.addIR(this,tmp);
			return tmp;



		}else if( base.type ==NodeType.return_sta){
			//System.out.println("ret-");
			return_sta node=(return_sta)base;
			IRCode res=convertToIR(node.return_exp);
			IRCode tmp = new IRCode();
			if(res.resultType==Type.INT)
				tmp.ins=IRIns.STOREI;
			else 
				tmp.ins=IRIns.STOREF;
			tmp.setOperand(res.result,null,"$R");
			fun.addIR(this,tmp);	
			tmp = new IRCode();
			tmp.ins=IRIns.RET;
			tmp.result=String.valueOf(fun.getReturnAdd());
			fun.addIR(this,tmp);	
		}
		return null;



	}

}

