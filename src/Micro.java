import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.lang.System;
import java.io.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

class MyErrorStrategy extends DefaultErrorStrategy {
	@Override
		protected void	beginErrorCondition(Parser recognizer)
		{
			throw new DeclartionException("Not Accepted");
		}


}
public class Micro {

	public static Tables symbolTables = new Tables();
	//public static ArrayList<AstTree> astTrees=new ArrayList<AstTree> ();
	
	//public static LinkedHashMap<String , String> registerMap= new LinkedHashMap<String,String>();
	public static int tmpCounter=0;
	public static int regCounter=0;
	public static ProgramFunctions program=new ProgramFunctions();
	
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		String filename=args[0];
	PrintStream stdout = System.out;
		filename=filename.substring(0,filename.indexOf(".micro"));
		PrintStream out = new PrintStream(new FileOutputStream(filename+".out"));
		System.setOut(out);
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
		try
		{
			parser.program();
		}
		catch(DeclartionException e)
		{	
			System.setOut(stdout);
			System.out.println(e);		
			System.exit(0);

		}

		//System.out.println("*************");
		/*for(int i=0;i<symbolTables.tables.size();i++){

		  System.out.println("Symbol table "+symbolTables.tables.get(i).scopeID);
		  for (String key : symbolTables.tables.get(i).table.keySet()) {
		  if(symbolTables.tables.get(i).table.get(key).getType()==Type.STRING)	
		  System.out.println("name "+symbolTables.tables.get(i).table.get(key).getName()+" type "+symbolTables.tables.get(i).table.get(key).getType()+" value "+symbolTables.tables.get(i).table.get(key).getValue()); 
		  else if(symbolTables.tables.get(i).table.get(key).getType()!=Type.FUN)	
		  System.out.println("name "+symbolTables.tables.get(i).table.get(key).getName()+" type "+symbolTables.tables.get(i).table.get(key).getType());
		  }
		  if(i!=-1+symbolTables.tables.size())
		  System.out.println("");


		  }*/
	/*for(int i=0;i<symbolTables.tables.size();i++){
			
		  System.out.println("Symbol table "+symbolTables.tables.get(i).scopeID  );
		  for (String key : symbolTables.tables.get(i).table.keySet()) {
			
		  System.out.println("name "+symbolTables.tables.get(i).table.get(key).getName()+" type "+symbolTables.tables.get(i).table.get(key).getType()  );
		  }
		  if(i!=-1+symbolTables.tables.size())
		  System.out.println("");


		  }*/
		//		
		//	for(int i=0;i<astTrees.size();i++)
		//	astTrees.get(i).printroot();

		
		
		/*
		for(int i=0;i<astTrees.size();i++){
			astTrees.get(i).ConvertToIR();
			astTrees.get(i).printIR();
			for(int j=0;j<astTrees.get(i).code.size();j++)
				GenAssembly(astTrees.get(i).code.get(j));
		}*/
		program.convertToIR();
		program.printIR();
		
		
		program.convertToAssembly();
		program.printAssembly();
		//AssemblyCode asscode=new AssemblyCode();

		//asscode.ASCODE=("sys halt");

		//asCode.add(asscode);

		//for(int i=0;i<asCode.size();i++){
		//	System.out.println(asCode.get(i).ASCODE);

		//}




	}
}
