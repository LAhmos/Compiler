import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  

enum Type  {INT,FLOAT ,STRING,VOID,FUN,Unkown;};
class Symbol {
	private String name;
	private String value;
	private Type type;
	private Scope symScope;
	public Symbol(String _name,String _type,String _value,Scope _symScope)
	{	name=_name;
		type=getTypeFromString(_type);
		value=_value;
		symScope=_symScope;
	}
	public Type GetType()
	{
		return type;
	}	 
	public String GetValue()
	{
		return value;

	}
	public String GetName()
	{
		return  name;

	}
	private Type getTypeFromString(String _type)
	{

		if(_type.equals("INT")) return Type.INT;
		if(_type.equals("FLOAT")) return Type.FLOAT;
		if(_type.equals("STRING")) return Type.STRING;
		if(_type.equals("FUNCTION")) return Type.FUN;
		return Type.Unkown;
	}


}
public class Scope{
	public String scopeID;
	public ScopeType type; 
	public Scope parent;//  null means root 
	public LinkedHashMap<String , Symbol> table= new LinkedHashMap<String,Symbol>();
	public Scope (Scope _parent,String id,ScopeType _type)
	{
		scopeID=id;
		parent=_parent;
		type=_type;
	}	
	public boolean defineSym(String _name,String _type,String _value){
		if(table.get(_name)==null){	
			table.put(_name,new Symbol(_name,_type,_value,this));
			return true;
		}
		return false; 

	}
	public  Symbol findSymbol(String name)
	{
		Symbol symbol=table.get(name);
		if(symbol!=null) return symbol;
		if(parent != null)
		return parent.findSymbol(name);
		return null;
	}
	public String getScopeID(){
		return scopeID.replace(' ','_');

		}


}
