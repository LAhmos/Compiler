import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

enum ScopeType{ Global,Block,Fun;};
public class Tables{

	public ArrayList<Scope> tables=new ArrayList<Scope> ();
	public Scope currTable;
	private int currBlock;
	private int parm=1;	
	public Tables()
	{	

		currBlock=1;
		createNewScope(ScopeType.Global,null);
		currTable=tables.get(0);

	}
	public boolean createNewScope(ScopeType type, String name)	{
		Scope tmp=null;		
		
		if(type==ScopeType.Block){
			//currTable=new Scope(currTable,"BLOCK "+currBlock,type);
			tables.add(tmp=new Scope(currTable,"BLOCK "+currBlock,type));
			currBlock++;
			
		}
		if(type==ScopeType.Fun){
			tables.add(tmp=new Scope(currTable, name,type));
			

		}
		if(type==ScopeType.Global){

			tables.add(tmp=new Scope(currTable, "GLOBAL",type));
			return true;


		}	
		//System.out.println(tmp); 
		currTable.child.add(tmp);
		currTable=tmp;
		return true;

	}	
	public boolean defineSymbol(String name,String type,String value){

		if(currTable.defineSym(name,type,value)) return true;
		return false;

	}
	public boolean defineSymbol(String name,String type,String value,boolean isPar){

		if(currTable.defineSym(name,type,value,isPar)) return true;
		return false;

	}
	public void popTable(){
		//System.out.println("poping:"+ currTable.scopeID);
	if(currTable.type==ScopeType.Global) return;
	currTable= currTable.parent;
	//System.out.println("after poping:"+ currTable.scopeID);
	}
	public Symbol Lookup (String name){
		return currTable.findSymbol(name);
	
	}

}
