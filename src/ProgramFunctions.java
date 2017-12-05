import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  



public class ProgramFunctions{
	private FunctionUnit currFunction=null;
	private ArrayList <FunctionUnit> funList = new ArrayList<FunctionUnit>();
	static int machineReg=4;
	static boolean isFor=false;
	public void addFunction(FunctionUnit var){
		funList.add(var);
		currFunction=var;
		
	}
	public FunctionUnit getCurrFun(){
		return currFunction;
	}
	public void createFun(Scope var){
		FunctionUnit  tmp=new FunctionUnit();
		addFunction(tmp);
		setSymbol(var);
		
	}
	public void setSymbol(Scope var){
		currFunction.setSymbol(var);
	}
	
	public void addAstTreetoCurr(AstTree var){
		var.setFun(currFunction);
		currFunction.addAstTree(var);
	}
	
	public void printIR(){
		for (int i=0;i<funList.size();i++)
		{	funList.get(i).printIR();

		funList.get(i).liveAnalysis();
funList.get(i).reachingAnalysis();
}
	}
	public void printAssembly(){
		for (String key : Micro.symbolTables.tables.get(0).table.keySet()) {
			Type tmp=Micro.symbolTables.tables.get(0).table.get(key).getType();		
			AssemblyCode asscode=new AssemblyCode();
			
			if(tmp==Type.INT || tmp==Type.FLOAT){
					
				System.out.println(("var "+Micro.symbolTables.tables.get(0).table.get(key).getName())); 

			}
			if(tmp==Type.STRING){
					
				System.out.println("str "+Micro.symbolTables.tables.get(0).table.get(key).getName() + " "+ Micro.symbolTables.tables.get(0).table.get(key).getValue()); 

			}
		}
		System.out.println("push ");
		for(int i=0;i<machineReg;i++){
		
		System.out.println("push r"+String.valueOf(i));
		}
		System.out.println("jsr main");
		System.out.println("sys halt");
		for (int i=0;i<funList.size();i++)
			funList.get(i).printAssembly();
		
	}
	public void convertToIR(){
		for (int i=0;i<funList.size();i++)
			funList.get(i).genFunIR();
		
	}
	public void convertToAssembly(){
		for (int i=0;i<funList.size();i++)
			funList.get(i).genAssembly();
		
	}
	
	public String getLocal(){
		return currFunction.getLocal();	

	}
	public String getPar(){
		return currFunction.getPar();	
	
	}
	public FunctionUnit getFunFromName(String var){
		for (int i=0;i<funList.size();i++){
			if(funList.get(i).getFunName().equals(var))
				return funList.get(i);
			
		}
		return null;

	}
	/*
	public String getReg(){
		return currFunction.getReg();	

	}
	public String getMapValue(String key){
		return currFunction.getMapValue(key);
	}
	public void putMapValue(String key,String value){
		 currFunction.putMapValue(key,value);
	}
	public void removeMapValue(String key){
			 currFunction.removeMapValue(key);
	}
	public IRCode getIR(int i){
		return currFunction.getIR(i);
	}
	public int getIRSize(){
		return currFunction.getIRSize();
	}
	public void addIRtoCurr(IRCode var){
		currFunction.addIR(var);
	}

*/
}

