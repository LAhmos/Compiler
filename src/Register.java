import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  



public class Register{
	public boolean inUse;
	public boolean isDirty;	
	public String regName;
	public String varName;
	public int regIndex;
	public Register(int indx){
		inUse=false;
		isDirty=false;
		regIndex=indx;
		regName="r"+indx;
	}
	public void freeReg(){
		inUse=false;
		isDirty=false;
	}
	public void allocReg(String varName){
		inUse=true;
		isDirty=false;
		this.varName=varName;
	}

}

