import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

enum ScopeType{ Global,Block,Fun;};
public class Tables{

	public ArrayList<Scope> tables=new ArrayList<Scope> ();
	public Scope currTable;
	private int currBlock;	
	public Tables()
	{	

		currBlock=1;
		createNewScope(ScopeType.Global,null);
		currTable=tables.get(0);

	}
	public boolean createNewScope(ScopeType type, String name)	{
		if(type==ScopeType.Block){
			tables.add(currTable=new Scope(currTable,"BLOCK "+currBlock,type));
			currBlock++;
			
			return true;
		}
		if(type==ScopeType.Fun){
			tables.add(currTable=new Scope(currTable, name,type));
			return true;

		}
		if(type==ScopeType.Global){

			tables.add(currTable=new Scope(currTable, "GLOBAL",type));
			return true;


		}	
		return false;

	}	
	public boolean defineSymbol(String name,String type,String value){

		if(currTable.defineSym(name,type,value)) return true;
		return false;

	}
	public void popTable(){
	
	if(currTable.type==ScopeType.Global) return;
	currTable= currTable.parent;
	
	}
	public Symbol Lookup (String name){
		return currTable.findSymbol(name);
	
	}

}
