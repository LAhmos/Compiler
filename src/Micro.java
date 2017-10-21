/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

class MyErrorStrategy extends DefaultErrorStrategy {
	@Override
		protected void	beginErrorCondition(Parser recognizer)
		{
			throw new RuntimeException("Not Accepted");
		}


}
public class Micro {

	public static Tables symbolTables = new Tables();
	public static ArrayList<AstTree> astTrees=new ArrayList<AstTree> ();
	public static ArrayList<AssemblyCode> asCode=new ArrayList<AssemblyCode> ();
	public static LinkedHashMap<String , String> registerMap= new LinkedHashMap<String,String>();
	public static int tmpCounter=0;
	public static int regCounter=0;
	public static String GetTmp()
	{	
		String tmp=new String();
		tmp="$T"+tmpCounter;
		tmpCounter++;
		return tmp;
	}
	public static String GetReg()
	{	
		String tmp=new String();
		tmp="r"+regCounter;
		regCounter++;
		return tmp;
	}
	public static void prepIns(IRCode code){

		AssemblyCode asscode=new AssemblyCode();
		IRIns ins=code.ins;
		String op1=code.op1,op2=code.op2,result=code.result;
	if(op2.charAt(0)=='$'){
			code.op2=Micro.registerMap.get(op2);
		}
	if(op1.charAt(0)=='$'){
			Micro.registerMap.put(result,Micro.registerMap.get(op1));
			code.result=code.op1=Micro.registerMap.get(op1);
		return;
		}
		if(result.charAt(0)=='$'){
			if(Micro.registerMap.get(result)==null){

			String tmp=GetReg();
			Micro.registerMap.put(result,tmp);
			code.result=tmp;
			} else {
				code.result=	Micro.registerMap.get(result);


			}
		}
		
		
		asscode.ASCODE="move "+ code.op1 +" "+code.result;
		asCode.add(asscode) ;
	}
	public static void GenAssembly(IRCode code){
		String IRins=code.IRCODE;	
		IRIns ins=code.ins;
		String op1=code.op1,op2=code.op2,result=code.result;
		AssemblyCode asscode=new AssemblyCode();

		if(ins==IRIns.STOREI||ins==IRIns.STOREF){
			if(op1.charAt(0)=='$')
				op1=Micro.registerMap.get(op1);

			if(result.charAt(0)=='$'){
				String tmp=GetReg();
				Micro.registerMap.put(result,tmp);
				result=tmp;
			}
			asscode.ASCODE="move "+ op1 +" "+result ;
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


			prepIns(code);
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
		asCode.add(asscode) ;

	}
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		InputStream is = System.in;
		if ( inputFile!=null ) {
			is = new FileInputStream(inputFile);
		}

		ANTLRInputStream input = new ANTLRInputStream(is);
		MicroLexer lexer = new MicroLexer(input);

		for (Token token = lexer.nextToken();
				token.getType() != Token.EOF;
				token = lexer.nextToken())
		{

			if(token.getType()==45&&token.getText().length()>30)
			{
				System.out.println("Not Accepted");
				System.exit(0);
			}
			if(token.getType()==18&&token.getText().length()>=82)
			{
				System.out.println("Not Accepted");
				System.exit(0);
			}

		}

		is = new FileInputStream(inputFile);
		input = new ANTLRInputStream(is);
		lexer = new MicroLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MicroParser parser = new MicroParser(tokens);
		ANTLRErrorStrategy es = new MyErrorStrategy(); 
		parser.setErrorHandler(es);
		//try
		{
			parser.program();
		}
		//	catch(RuntimeException e)
		{	
			//		System.exit(0);

		}

		//System.out.println("*************");
		/*for(int i=0;i<symbolTables.tables.size();i++){

		  System.out.println("Symbol table "+symbolTables.tables.get(i).scopeID);
		  for (String key : symbolTables.tables.get(i).table.keySet()) {
		  if(symbolTables.tables.get(i).table.get(key).GetType()==Type.STRING)	
		  System.out.println("name "+symbolTables.tables.get(i).table.get(key).GetName()+" type "+symbolTables.tables.get(i).table.get(key).GetType()+" value "+symbolTables.tables.get(i).table.get(key).GetValue()); 
		  else if(symbolTables.tables.get(i).table.get(key).GetType()!=Type.FUN)	
		  System.out.println("name "+symbolTables.tables.get(i).table.get(key).GetName()+" type "+symbolTables.tables.get(i).table.get(key).GetType());
		  }
		  if(i!=-1+symbolTables.tables.size())
		  System.out.println("");


		  }*/
		astTrees.get(0).printroot();

		for (String key : symbolTables.tables.get(0).table.keySet()) {
			AssemblyCode asscode=new AssemblyCode();

			if(symbolTables.tables.get(0).table.get(key).GetType()!=Type.FUN){	
				asscode.ASCODE=("var "+symbolTables.tables.get(0).table.get(key).GetName()); 

				asCode.add(asscode);}
		}
		/*
		   AssemblyCode asscode=new AssemblyCode();

		   asscode.ASCODE=("aaa"); 

		   asCode.add(asscode);
		 */
		for(int i=0;i<astTrees.size();i++){
			astTrees.get(i).ConvertToIR();
			astTrees.get(i).printIR();
			for(int j=0;j<astTrees.get(i).code.size();j++)
				GenAssembly(astTrees.get(i).code.get(j));
		}
		AssemblyCode asscode=new AssemblyCode();

		asscode.ASCODE=("sys halt");

		asCode.add(asscode);

		for(int i=0;i<asCode.size();i++){
			System.out.println(asCode.get(i).ASCODE);

		}




	}
}
