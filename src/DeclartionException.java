import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;
import java.util.*;  
public class DeclartionException extends  RuntimeException {
   String var;
 
   DeclartionException (String str2) {
	var=str2;
   }
   public String toString(){ 
	return (var) ;
   }
}
