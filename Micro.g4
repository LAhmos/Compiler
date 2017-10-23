grammar Micro;	
program
:PROGRAM id BEGIN pgm_body END;

id
:IDENTIFIER;

pgm_body
:decl func_declarations;
decl
:string_decl decl | var_decl decl | ;

/** Global String Declaration */
string_decl
:STRING id ':=' str';'{if(!Micro.symbolTables.defineSymbol($id.text,"STRING",$str.text)) throw new RuntimeException("DECLARATION ERROR "+$id.text);};
str: STRINGLITERAL;

/** Variable Declaration */
	var_decl          locals [
List<String> symbols = new ArrayList<String>()
	]: var_type id_list ';'{	
	for(int i=0;i<$symbols.size();i++){
		if(!Micro.symbolTables.defineSymbol($symbols.get(i),$var_type.text,null)) throw new RuntimeException("DECLARATION ERROR "+$symbols.get(i));
	}
};
var_type          : FLOAT | INT;
any_type          : var_type | VOID;
id_list           : id  { $var_decl::symbols.add($id.text.toString());} id_tail ;
id_tail           : ',' id  {$var_decl::symbols.add($id.text.toString());} id_tail  | ;

/** Function Paramater List */
param_decl_list   : param_decl param_decl_tail | ;
param_decl        : var_type id {if(!Micro.symbolTables.defineSymbol($id.text,$var_type.text,null)) throw new RuntimeException("DECLARATION ERROR "+$id.text);;};
param_decl_tail   : ',' param_decl param_decl_tail | ;

/** Function Declarations */
func_declarations : func_decl func_declarations | ;
func_decl         : FUNCTION any_type id {if(!Micro.symbolTables.defineSymbol($id.text,"FUNCTION",null)) throw new RuntimeException("DECLARATION ERROR "+$id.text); Micro.symbolTables.createNewScope(ScopeType.Fun,$id.text);}'('param_decl_list')' BEGIN func_body END{Micro.symbolTables.popTable();};
func_body         : decl stmt_list;

/** Statement List */
stmt_list  returns [AstTree tree]       : t1=stmt{$tree =$t1.tree;} stmt_list |{$tree=null;} ;
stmt       returns [AstTree tree]       : t1=base_stmt{$tree=$t1.node;} | if_stmt | for_stmt;
base_stmt   returns [AstTree node]       : t1= assign_stmt { AstTree tree =new AstTree(); tree.root=$t1.node;   Micro.astTrees.add(tree); $node=tree;} | t2=read_stmt{ AstTree tree =new AstTree(); tree.root=$t2.node;  Micro.astTrees.add(tree); $node=tree;}  | t3=write_stmt{ AstTree tree =new AstTree(); tree.root=$t3.node;  Micro.astTrees.add(tree); $node=tree;}  | t4=return_stmt;

/** Basic Statements */
id_list2  returns[List<id> ids]   locals [List<id> _ids=new ArrayList()]:{$ids=new ArrayList<id>();} id {id tmp=new id(); tmp.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup($id.text); if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+$id.text); tmp.name=symbol.GetName(); tmp.dataType=symbol.GetType(); $ids.add(tmp);}  id_tail2 { for(int i=0;i<$_ids.size();i++) $ids.add($_ids.get(i));  };
id_tail2           : ',' id { id tmp=new id(); tmp.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup($id.text); if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+$id.text); tmp.name=symbol.GetName();   tmp.dataType=symbol.GetType(); $id_list2::_ids.add(tmp);} id_tail2 | ;
assign_stmt    returns[AstNode node]   : t1=assign_expr';' {$node =$t1.node; };
assign_expr  returns [AstNode node]     : { exp assign_op=new exp();   assign_op.type=NodeType.exp; assign_op.opType=OpType.assign; } t1=id ':=' t2=expr { id id_var =new id(); id_var.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup($id.text);     if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+$id.text); ((id)id_var).name=symbol.GetName(); ((id)id_var).dataType=symbol.GetType(); assign_op.left=id_var; assign_op.right=$t2.node; $node=assign_op;  };
read_stmt returns [AstNode node]   :READ '(' t1=id_list2 ')'';' {  $node=new read_write(); $node.type=NodeType.read; ((read_write)($node)).id_list=$t1.ids;  }; /* todo: check ids*/
write_stmt  returns[AstNode node]  :WRITE '(' t1=id_list2 ')'';'{  $node=new read_write(); $node.type=NodeType.write; ((read_write)($node)).id_list=$t1.ids;     };
return_stmt       : RETURN expr';';

/** Expressions */
expr    returns [AstNode node]  : t1=expr_prefix  t2=factor { if(((exp)($t1.node))!=null) {((exp)($t1.node)).right=$t2.node; $node=$t1.node;} else { $node = $t2.node;} };
expr_prefix   returns [AstNode node]     : t1=expr_prefix t2=factor t3=addop {  exp add_node=new exp(); add_node.type=NodeType.exp; if($t3.text.equals("+")) add_node.opType=OpType.add;  else add_node.opType=OpType.sub;   if($t1.node==null){ add_node.left=$t2.node; $node=add_node;}else {((exp)($t1.node)).right=$t2.node; add_node.left=$t1.node; $node=add_node; }}|{$node=null;} ;
factor      returns [AstNode node]       : t1=factor_prefix t2=postfix_expr { if(((exp)($t1.node))!=null){((exp)($t1.node)).right=$t2.node; $node=$t1.node;} else {$node=$t2.node;} };
factor_prefix  returns [AstNode node]    : t1=factor_prefix t2=postfix_expr t3=mulop  { exp mul_node=new exp(); mul_node.type=NodeType.exp	; if($t3.text.equals("*")) mul_node.opType=OpType.mul;  else mul_node.opType=OpType.div;   if($t1.node==null){ mul_node.left=$t2.node; $node=mul_node;}else {((exp)($t1.node)).right=$t2.node; mul_node.left=$t1.node; $node=mul_node;}       } |{$node=null;} ;
postfix_expr   returns [AstNode node]    : t1=primary { $node=$t1.node;} | call_expr;
call_expr         : id '(' expr_list ')';
expr_list         : expr expr_list_tail | ;
expr_list_tail    : ',' expr expr_list_tail | ;
primary   returns [AstNode node]     : '('t1=expr')' { $node=$t1.node;}| t2=id { $node=new id(); $node.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup($id.text);  if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+$id.text);    ((id)$node).name=symbol.GetName();; ((id)$node).dataType=symbol.GetType();}| t3=INTLITERAL { $node=new literal(); ((literal)$node).number=Integer.parseInt($t3.text);((literal)$node).dataType=Type.INT;  $node.type=NodeType.literal; }| t4=FLOATLITERAL{ $node=new literal(); ((literal)$node).dataType=Type.FLOAT; ((literal)$node).number=Float.parseFloat($t4.text); $node.type=NodeType.literal; };
addop             : '+' | '-';
mulop             : '*' | '/';

/** Complex Statements and Condition */ 
if_stmt     returns [AstTree tree] locals[ String elseLab, String outLab]  : IF  {		Micro.symbolTables.createNewScope(ScopeType.Block,null); 
												$outLab= Micro.symbolTables.currTable.getScopeID()+"_Out";
												$elseLab= Micro.symbolTables.currTable.getScopeID()+"_Else";  
												AstTree ifSta=new AstTree(); 
												IF ifNode=new IF(); 
												ifNode.type=NodeType.ifSta; 
												ifSta.root=ifNode;  
												Micro.astTrees.add(ifSta);
											} 
												'(' t1=cond ')' decl t2=stmt_list
												{
													Micro.symbolTables.popTable();   
													AstTree jumpTree = new AstTree();
													AstNode jnode= new IF();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=$outLab;
													Micro.astTrees.add(jumpTree);

												
												
												} 
												
												
												t3=elif_part[$outLab]   ENDIF 
												{  
													ifNode.cond=$t1.node;
												AstTree outTree=new AstTree();
												AstNode outnode= new AstNode();
												outTree.root=outnode;
												outnode.type=NodeType.outLab; 
												outTree.label=$outLab;
												outTree.isTarget=true;
												Micro.astTrees.add(outTree);
												if($t3.tree!=null) {
														$t3.tree.isTarget=true;
														$t3.tree.label=$elseLab; 
														ifNode.ifLabel=$elseLab; 
												} else { 
											
												ifNode.ifLabel=$outLab; 
												jumpTree.root.type=NodeType.skip;
												 
												 } 
												} ;

elif_part [String outin]  returns [AstTree tree] locals[String elseLab, String outLab] : ELIF {	Micro.symbolTables.createNewScope(ScopeType.Block,null); 
											$elseLab= Micro.symbolTables.currTable.getScopeID()+"_Else"; 
											$outLab= Micro.symbolTables.currTable.getScopeID()+"_Out";
											AstTree ifElseSta=new AstTree(); 
											IF elseIfNode=new IF(); 
											elseIfNode.type=NodeType.elseIf; 
											ifElseSta.root=elseIfNode; 
											$tree=ifElseSta;  
											Micro.astTrees.add(ifElseSta);   
											}
											'(' t12=cond ')' decl stmt_list 
											{
											Micro.symbolTables.popTable();
													AstTree jumpTree = new AstTree();
													AstNode jnode= new IF();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=outin;
												Micro.astTrees.add(jumpTree);
												
											
											
											
											} 
											t3=elif_part[outin] 
											{
											elseIfNode.cond=$t12.node;	

											if($t3.tree!=null) 
											{
											$t3.tree.isTarget=true; 
											$t3.tree.label=$elseLab; 
											elseIfNode.ifLabel=$elseLab; 

											}
											else { 
											
												elseIfNode.ifLabel=$outin; 
												jumpTree.root.type=NodeType.skip;
												 
												 } 

											
											
											}| t5=else_part {$tree =$t5.tree; };




else_part     returns [AstTree tree ]     : ELSE
{Micro.symbolTables.createNewScope(ScopeType.Block,null);  IF node=new IF(); node.type=NodeType.elseSta; AstTree ElseTree=new AstTree(); $tree=ElseTree; ElseTree.root=node; Micro.astTrees.add(ElseTree);  } 

decl  stmt_list {Micro.symbolTables.popTable(); } |{$tree=null;} ;


cond    returns [AstNode node]          : t1=lit {  $node=$t1.node; } t2=cond_suffix[$node] {if($t2.node!=null) $node=$t2.node;};
cond_suffix  [AstNode in_node]  returns [AstNode node]     : OR t1=lit {  boolExp tmp=new boolExp(); tmp.right=$t1.node; tmp.left=$in_node; tmp.type=NodeType.cond; tmp.opType=LogicOp.or; $node=tmp; } t2=cond_suffix[$node] {
	if($t2.node!=null) $node=$t2.node; } | AND t3=lit {  boolExp tmp=new boolExp(); tmp.right=$t3.node;  tmp.left=$in_node; tmp.type=NodeType.cond; tmp.opType=LogicOp.and; $node=tmp; } t4=cond_suffix[$node]{
		if($t4.node!=null) $node=$t4.node;  } | {$node=null;};
lit        returns [AstNode node]       : NOT t1=basic_cond{((boolExp)($t1.node)).opType=LogicOp.not; $node=$t1.node;} | t2=basic_cond{$node =$t2.node; };
basic_cond  returns [AstNode node]      : t1=expr t2=compop t3=expr{ boolExp tmp=new boolExp(); tmp.left=$t1.node; tmp.type=NodeType.cond; tmp.right=$t3.node; tmp.opType=LogicOp.noOp; tmp.compOp=boolExp.getOpFromString($t2.text);  $node=tmp;  } | TRUE { boolExp tmp=new boolExp(); tmp.left=null; tmp.right=null; tmp.opType=LogicOp.noOp;tmp.type=NodeType.cond;  tmp.compOp=CompOp.True;  $node=tmp; }| FALSE{ boolExp tmp=new boolExp(); tmp.left=null; tmp.right=null; tmp.opType=LogicOp.noOp; tmp.type=NodeType.cond; tmp.compOp=CompOp.False;  $node=tmp; };
compop            : '<' | '>' | '=' | '!=' | '<=' | '>=';

/** For Statements */
init_stmt       			: t1=assign_expr {AstTree tmp = new AstTree(); tmp.root=$t1.node;  Micro.astTrees.add(tmp);  } | ;
incr_stmt   returns [AstTree tree]      : t1=assign_expr {AstTree tmp = new AstTree(); tmp.root=$t1.node;  $tree=tmp;  } | {$tree=null;};

for_stmt       locals[String incLab, String loopLab,String outLab ]: FOR { Micro.symbolTables.createNewScope(ScopeType.Block,null);
												$outLab= Micro.symbolTables.currTable.getScopeID()+"_OUT";
												$incLab= Micro.symbolTables.currTable.getScopeID()+"_INC";  
												$loopLab= Micro.symbolTables.currTable.getScopeID()+"_Loop";  
												
										}
										'(' init_stmt ';' { 
												AstNode loopLabelNode=new AstNode();
												loopLabelNode.type=NodeType.outLab;
												AstTree labelTree=new AstTree();
												labelTree.root=loopLabelNode;
												labelTree.label=$loopLab;
												Micro.astTrees.add(labelTree);

   } t6=cond ';'{
												AstTree forSta=new AstTree(); 
												FOR forNode=new FOR(); 
												forNode.type=NodeType.forSta; 
												forSta.root=forNode; 
												forNode.cond=$t6.node;
												forNode.forLabel=$outLab;
												Micro.astTrees.add(forSta);
												

										}
										
										t8=incr_stmt ')' decl aug_stmt_list[Micro.symbolTables.currTable.getScopeID()] ENDFOR {Micro.symbolTables.popTable();   
											if($t8.tree!=null){


												AstNode incLabelNode=new AstNode();
												incLabelNode.type=NodeType.outLab;
												AstTree incLabelTree=new AstTree();
												incLabelTree.root=incLabelNode;
												incLabelTree.label=$incLab;
												Micro.astTrees.add(incLabelTree);
												Micro.astTrees.add($t8.tree);
												}
													AstTree jumpTree = new AstTree();
													AstNode jnode= new AstNode();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=$loopLab;
													Micro.astTrees.add(jumpTree);


												AstTree outTree=new AstTree();
												AstNode outnode= new AstNode();
												outTree.root=outnode;
												outnode.type=NodeType.outLab; 
												outTree.label=$outLab;
												outTree.isTarget=true;
												Micro.astTrees.add(outTree);

										
 };

aug_stmt_list   [String block]  : aug_stmt [$block] aug_stmt_list[$block] | ;
aug_stmt [String block]         : base_stmt | aug_if_stmt[$block] | for_stmt | CONTINUE';'{ 		AstTree jumpTree = new AstTree();
													AstNode jnode= new AstNode();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=$block+"_INC";
													Micro.astTrees.add(jumpTree);
     } | BREAK';'{
     													AstTree jumpTree = new AstTree();
													AstNode jnode= new AstNode();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=$block+"_OUT";
													Micro.astTrees.add(jumpTree);
     
     
     
     };

aug_if_stmt   [String block] returns [AstTree tree] locals[ String elseLab, String outLab]   : IF {		Micro.symbolTables.createNewScope(ScopeType.Block,null); 
												$outLab= Micro.symbolTables.currTable.getScopeID()+"_Out";
												$elseLab= Micro.symbolTables.currTable.getScopeID()+"_Else";  
												AstTree ifSta=new AstTree(); 
												IF ifNode=new IF(); 
												ifNode.type=NodeType.ifSta; 
												ifSta.root=ifNode;  
												Micro.astTrees.add(ifSta);
											} '('t1= cond ')' decl t2=aug_stmt_list[$block] {
													Micro.symbolTables.popTable();   
													AstTree jumpTree = new AstTree();
													AstNode jnode= new IF();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=$outLab;
													Micro.astTrees.add(jumpTree);

												
												
												} 
t3=aug_elif_part[$block,$outLab] ENDIF{  
													ifNode.cond=$t1.node;
												AstTree outTree=new AstTree();
												AstNode outnode= new AstNode();
												outTree.root=outnode;
												outnode.type=NodeType.outLab; 
												outTree.label=$outLab;
												outTree.isTarget=true;
												Micro.astTrees.add(outTree);
												if($t3.tree!=null) {
														$t3.tree.isTarget=true;
														$t3.tree.label=$elseLab; 
														ifNode.ifLabel=$elseLab; 
												} else { 
											
												ifNode.ifLabel=$outLab; 
												jumpTree.root.type=NodeType.skip;
												 
												 } 
												};
aug_elif_part [String block,String outin]  returns [AstTree tree] locals[String elseLab, String outLab]   : ELIF {	Micro.symbolTables.createNewScope(ScopeType.Block,null); 
											$elseLab= Micro.symbolTables.currTable.getScopeID()+"_Else"; 
											$outLab= Micro.symbolTables.currTable.getScopeID()+"_Out";
											AstTree ifElseSta=new AstTree(); 
											IF elseIfNode=new IF(); 
											elseIfNode.type=NodeType.elseIf; 
											ifElseSta.root=elseIfNode; 
											$tree=ifElseSta;  
											Micro.astTrees.add(ifElseSta);   
											}
										'(' t12=cond ')'	decl aug_stmt_list[$block] {
											Micro.symbolTables.popTable();
													AstTree jumpTree = new AstTree();
													AstNode jnode= new IF();
													jnode.type=NodeType.jumpOut;
													jumpTree.root=jnode;
													jumpTree.isTarget=true;
													jumpTree.label=outin;
												Micro.astTrees.add(jumpTree);
												
											
											
											
											}
t3=aug_elif_part[$block,outin] {
											elseIfNode.cond=$t12.node;	

											if($t3.tree!=null) 
											{
											$t3.tree.isTarget=true; 
											$t3.tree.label=$elseLab; 
											elseIfNode.ifLabel=$elseLab; 

											}
											else { 
											
												elseIfNode.ifLabel=$outin; 
												jumpTree.root.type=NodeType.skip;
												 
												 } 

											
											
											}| t5=aug_else_part[$block] {$tree =$t5.tree; };

aug_else_part [String block] returns [AstTree tree ]   : ELSE {Micro.symbolTables.createNewScope(ScopeType.Block,null);  IF node=new IF(); node.type=NodeType.elseSta; AstTree ElseTree=new AstTree(); $tree=ElseTree; ElseTree.root=node; Micro.astTrees.add(ElseTree);  } 

decl aug_stmt_list[$block] |{$tree=null;} ;




INTLITERAL: [0-9]+;
FLOATLITERAL: ([0-9]+'.'[0-9]+)| ('.'[0-9]+);


STRINGLITERAL:
'"' ~('"')* '"';

COMMENT:
'--' ~('\n')* '\n' ->skip;

OR: 'OR';
AND: 'AND';
NOT: 'NOT';
TRUE: 'TRUE';
FALSE: 'FALSE';





FUNCTION:'FUNCTION';
READ:'READ';
WRITE:'WRITE';
IF:'IF';
ELIF:'ELIF';
ELSE:'ELSE';
ENDIF:'ENDIF';
FOR:'FOR';
ENDFOR:'ENDFOR';
CONTINUE:'CONTINUE';
BREAK:'BREAK';
RETURN:'RETURN';
INT:'INT';
VOID:'VOID';
STRING:'STRING';
FLOAT:'FLOAT';
PROGRAM: 'PROGRAM';
BEGIN: 'BEGIN';
END:'END';
Ws: [' '|\r|\t|\n]+ -> skip;
IDENTIFIER:[a-zA-Z][a-zA-Z1-9]*;


