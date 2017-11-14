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
	private int index;
	private String stackLabel=null;
	public boolean isParameter= false;
	public Symbol(String _name,String _type,String _value,Scope _symScope){
		name=_name;
		type=getTypeFromString(_type);
		value=_value;
		symScope=_symScope;
		if(getScopeType()!=ScopeType.Global)
			stackLabel=Micro.program.getLocal();
		
	}
	public Symbol(String _name,String _type,String _value,Scope _symScope,boolean _isPar){
		name=_name;
		type=getTypeFromString(_type);
		value=_value;
		symScope=_symScope;
		isParameter=_isPar;
		stackLabel=Micro.program.getPar();
	}
	
	public Type getType(){
		return type;
	}	 
	public String getValue()
	{
		return value;

	}
	public String getName(){
		return  name;

	}
	public static Type getTypeFromString(String _type){

		if(_type.equals("INT")) return Type.INT;
		if(_type.equals("FLOAT")) return Type.FLOAT;
		if(_type.equals("STRING")) return Type.STRING;
		if(_type.equals("FUNCTION")) return Type.FUN;
		return Type.Unkown;
	}
	public int getIndex(){
		return index;
	}
	public void setIndex(int _index){
		index=_index;
	}
	public ScopeType getScopeType(){
		return this.symScope.getScopeType();
	}
	public String getStackLabel(){
		return stackLabel;
	}
	public void setStackLabel(String var){
		stackLabel=var;
	}


}
public class Scope{
	public String scopeID;
	public ScopeType type; 
	public Scope parent;//  null means root 
	public int parNumber=0;
	public ArrayList<Type> funSig = new ArrayList<Type>();
	public ArrayList <Scope> child=new ArrayList<Scope>(); // to delete 
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
	public boolean defineSym(String _name,String _type,String _value,boolean isPar){
		parNumber++;
		funSig.add(Symbol.getTypeFromString(_type));
		if(table.get(_name)==null){	
			table.put(_name,new Symbol(_name,_type,_value,this,isPar));
			return true;
		}
		return false; 

	}
	
	public  Symbol findSymbol(String name){
		Symbol symbol=table.get(name);
		if(symbol!=null) return symbol;
		if(parent != null)
		return parent.findSymbol(name);
		return null;
	}
	public String getScopeID(){
		return scopeID.replace(' ','_');

	}
	public ScopeType getScopeType(){
		return type;
	}
	
	public boolean checkFunSig(ArrayList<Type> list){

		for(int i=0;i<list.size();i++){
			if(list.get(i)!=funSig.get(i)) return false;
		
		}
		return true;
	}

}
