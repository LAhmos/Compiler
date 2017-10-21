// Generated from Micro.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INTLITERAL=16, 
		FLOATLITERAL=17, STRINGLITERAL=18, COMMENT=19, OR=20, AND=21, NOT=22, 
		TRUE=23, FALSE=24, FUNCTION=25, READ=26, WRITE=27, IF=28, ELIF=29, ELSE=30, 
		ENDIF=31, FOR=32, ENDFOR=33, CONTINUE=34, BREAK=35, RETURN=36, INT=37, 
		VOID=38, STRING=39, FLOAT=40, PROGRAM=41, BEGIN=42, END=43, Ws=44, IDENTIFIER=45;
	public static final int
		RULE_program = 0, RULE_id = 1, RULE_pgm_body = 2, RULE_decl = 3, RULE_string_decl = 4, 
		RULE_str = 5, RULE_var_decl = 6, RULE_var_type = 7, RULE_any_type = 8, 
		RULE_id_list = 9, RULE_id_tail = 10, RULE_param_decl_list = 11, RULE_param_decl = 12, 
		RULE_param_decl_tail = 13, RULE_func_declarations = 14, RULE_func_decl = 15, 
		RULE_func_body = 16, RULE_stmt_list = 17, RULE_stmt = 18, RULE_base_stmt = 19, 
		RULE_id_list2 = 20, RULE_id_tail2 = 21, RULE_assign_stmt = 22, RULE_assign_expr = 23, 
		RULE_read_stmt = 24, RULE_write_stmt = 25, RULE_return_stmt = 26, RULE_expr = 27, 
		RULE_expr_prefix = 28, RULE_factor = 29, RULE_factor_prefix = 30, RULE_postfix_expr = 31, 
		RULE_call_expr = 32, RULE_expr_list = 33, RULE_expr_list_tail = 34, RULE_primary = 35, 
		RULE_addop = 36, RULE_mulop = 37, RULE_if_stmt = 38, RULE_elif_part = 39, 
		RULE_else_part = 40, RULE_cond = 41, RULE_cond_suffix = 42, RULE_lit = 43, 
		RULE_basic_cond = 44, RULE_compop = 45, RULE_init_stmt = 46, RULE_incr_stmt = 47, 
		RULE_for_stmt = 48, RULE_aug_stmt_list = 49, RULE_aug_stmt = 50, RULE_aug_if_stmt = 51, 
		RULE_aug_elif_part = 52, RULE_aug_else_part = 53;
	public static final String[] ruleNames = {
		"program", "id", "pgm_body", "decl", "string_decl", "str", "var_decl", 
		"var_type", "any_type", "id_list", "id_tail", "param_decl_list", "param_decl", 
		"param_decl_tail", "func_declarations", "func_decl", "func_body", "stmt_list", 
		"stmt", "base_stmt", "id_list2", "id_tail2", "assign_stmt", "assign_expr", 
		"read_stmt", "write_stmt", "return_stmt", "expr", "expr_prefix", "factor", 
		"factor_prefix", "postfix_expr", "call_expr", "expr_list", "expr_list_tail", 
		"primary", "addop", "mulop", "if_stmt", "elif_part", "else_part", "cond", 
		"cond_suffix", "lit", "basic_cond", "compop", "init_stmt", "incr_stmt", 
		"for_stmt", "aug_stmt_list", "aug_stmt", "aug_if_stmt", "aug_elif_part", 
		"aug_else_part"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='", "';'", "','", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
		"'<'", "'>'", "'='", "'!='", "'<='", "'>='", null, null, null, null, "'OR'", 
		"'AND'", "'NOT'", "'TRUE'", "'FALSE'", "'FUNCTION'", "'READ'", "'WRITE'", 
		"'IF'", "'ELIF'", "'ELSE'", "'ENDIF'", "'FOR'", "'ENDFOR'", "'CONTINUE'", 
		"'BREAK'", "'RETURN'", "'INT'", "'VOID'", "'STRING'", "'FLOAT'", "'PROGRAM'", 
		"'BEGIN'", "'END'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "OR", "AND", "NOT", "TRUE", "FALSE", "FUNCTION", "READ", "WRITE", 
		"IF", "ELIF", "ELSE", "ENDIF", "FOR", "ENDFOR", "CONTINUE", "BREAK", "RETURN", 
		"INT", "VOID", "STRING", "FLOAT", "PROGRAM", "BEGIN", "END", "Ws", "IDENTIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MicroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(MicroParser.PROGRAM, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(MicroParser.BEGIN, 0); }
		public Pgm_bodyContext pgm_body() {
			return getRuleContext(Pgm_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(MicroParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(PROGRAM);
			setState(109);
			id();
			setState(110);
			match(BEGIN);
			setState(111);
			pgm_body();
			setState(112);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pgm_bodyContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Func_declarationsContext func_declarations() {
			return getRuleContext(Func_declarationsContext.class,0);
		}
		public Pgm_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pgm_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPgm_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPgm_body(this);
		}
	}

	public final Pgm_bodyContext pgm_body() throws RecognitionException {
		Pgm_bodyContext _localctx = new Pgm_bodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pgm_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			decl();
			setState(117);
			func_declarations();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String_declContext string_decl() {
			return getRuleContext(String_declContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				string_decl();
				setState(120);
				decl();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				var_decl();
				setState(123);
				decl();
				}
				break;
			case FUNCTION:
			case READ:
			case WRITE:
			case IF:
			case ELIF:
			case ELSE:
			case ENDIF:
			case FOR:
			case ENDFOR:
			case CONTINUE:
			case BREAK:
			case RETURN:
			case END:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_declContext extends ParserRuleContext {
		public IdContext id;
		public StrContext str;
		public TerminalNode STRING() { return getToken(MicroParser.STRING, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public String_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterString_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitString_decl(this);
		}
	}

	public final String_declContext string_decl() throws RecognitionException {
		String_declContext _localctx = new String_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(STRING);
			setState(129);
			((String_declContext)_localctx).id = id();
			setState(130);
			match(T__0);
			setState(131);
			((String_declContext)_localctx).str = str();
			setState(132);
			match(T__1);
			if(!Micro.symbolTables.defineSymbol((((String_declContext)_localctx).id!=null?_input.getText(((String_declContext)_localctx).id.start,((String_declContext)_localctx).id.stop):null),"STRING",(((String_declContext)_localctx).str!=null?_input.getText(((String_declContext)_localctx).str.start,((String_declContext)_localctx).str.stop):null))) throw new RuntimeException("DECLARATION ERROR "+(((String_declContext)_localctx).id!=null?_input.getText(((String_declContext)_localctx).id.start,((String_declContext)_localctx).id.stop):null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(MicroParser.STRINGLITERAL, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStr(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(STRINGLITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public List<String> symbols =  new ArrayList<String>();
		public Var_typeContext var_type;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((Var_declContext)_localctx).var_type = var_type();
			setState(138);
			id_list();
			setState(139);
			match(T__1);
				
			for(int i=0;i<_localctx.symbols.size();i++){
			if(!Micro.symbolTables.defineSymbol(_localctx.symbols.get(i),(((Var_declContext)_localctx).var_type!=null?_input.getText(((Var_declContext)_localctx).var_type.start,((Var_declContext)_localctx).var_type.stop):null),null)) throw new RuntimeException("DECLARATION ERROR "+_localctx.symbols.get(i));
			}



			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(MicroParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(MicroParser.INT, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_type(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MicroParser.VOID, 0); }
		public Any_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAny_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAny_type(this);
		}
	}

	public final Any_typeContext any_type() throws RecognitionException {
		Any_typeContext _localctx = new Any_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_any_type);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				var_type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tailContext id_tail() {
			return getRuleContext(Id_tailContext.class,0);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_id_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			((Id_listContext)_localctx).id = id();
			 ((Var_declContext)getInvokingContext(6)).symbols.add((((Id_listContext)_localctx).id!=null?_input.getText(((Id_listContext)_localctx).id.start,((Id_listContext)_localctx).id.stop):null).toString());
			setState(150);
			id_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_tailContext extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tailContext id_tail() {
			return getRuleContext(Id_tailContext.class,0);
		}
		public Id_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_tail(this);
		}
	}

	public final Id_tailContext id_tail() throws RecognitionException {
		Id_tailContext _localctx = new Id_tailContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id_tail);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__2);
				setState(153);
				((Id_tailContext)_localctx).id = id();
				((Var_declContext)getInvokingContext(6)).symbols.add((((Id_tailContext)_localctx).id!=null?_input.getText(((Id_tailContext)_localctx).id.start,((Id_tailContext)_localctx).id.stop):null).toString());
				setState(155);
				id_tail();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_listContext extends ParserRuleContext {
		public Param_declContext param_decl() {
			return getRuleContext(Param_declContext.class,0);
		}
		public Param_decl_tailContext param_decl_tail() {
			return getRuleContext(Param_decl_tailContext.class,0);
		}
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_list(this);
		}
	}

	public final Param_decl_listContext param_decl_list() throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param_decl_list);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				param_decl();
				setState(161);
				param_decl_tail();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_declContext extends ParserRuleContext {
		public Var_typeContext var_type;
		public IdContext id;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl(this);
		}
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			((Param_declContext)_localctx).var_type = var_type();
			setState(167);
			((Param_declContext)_localctx).id = id();
			if(!Micro.symbolTables.defineSymbol((((Param_declContext)_localctx).id!=null?_input.getText(((Param_declContext)_localctx).id.start,((Param_declContext)_localctx).id.stop):null),(((Param_declContext)_localctx).var_type!=null?_input.getText(((Param_declContext)_localctx).var_type.start,((Param_declContext)_localctx).var_type.stop):null),null)) throw new RuntimeException("DECLARATION ERROR "+(((Param_declContext)_localctx).id!=null?_input.getText(((Param_declContext)_localctx).id.start,((Param_declContext)_localctx).id.stop):null));;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_tailContext extends ParserRuleContext {
		public Param_declContext param_decl() {
			return getRuleContext(Param_declContext.class,0);
		}
		public Param_decl_tailContext param_decl_tail() {
			return getRuleContext(Param_decl_tailContext.class,0);
		}
		public Param_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_tail(this);
		}
	}

	public final Param_decl_tailContext param_decl_tail() throws RecognitionException {
		Param_decl_tailContext _localctx = new Param_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param_decl_tail);
		try {
			setState(175);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__2);
				setState(171);
				param_decl();
				setState(172);
				param_decl_tail();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declarationsContext extends ParserRuleContext {
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public Func_declarationsContext func_declarations() {
			return getRuleContext(Func_declarationsContext.class,0);
		}
		public Func_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_declarations(this);
		}
	}

	public final Func_declarationsContext func_declarations() throws RecognitionException {
		Func_declarationsContext _localctx = new Func_declarationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_func_declarations);
		try {
			setState(181);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				func_decl();
				setState(178);
				func_declarations();
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public IdContext id;
		public TerminalNode FUNCTION() { return getToken(MicroParser.FUNCTION, 0); }
		public Any_typeContext any_type() {
			return getRuleContext(Any_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(MicroParser.BEGIN, 0); }
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(MicroParser.END, 0); }
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_decl(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_func_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(FUNCTION);
			setState(184);
			any_type();
			setState(185);
			((Func_declContext)_localctx).id = id();
			if(!Micro.symbolTables.defineSymbol((((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null),"FUNCTION",null)) throw new RuntimeException("DECLARATION ERROR "+(((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null)); Micro.symbolTables.createNewScope(ScopeType.Fun,(((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null));
			setState(187);
			match(T__3);
			setState(188);
			param_decl_list();
			setState(189);
			match(T__4);
			setState(190);
			match(BEGIN);
			setState(191);
			func_body();
			setState(192);
			match(END);
			Micro.symbolTables.popTable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_bodyContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_body(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_func_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			decl();
			setState(196);
			stmt_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt_list(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmt_list);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case READ:
			case WRITE:
			case IF:
			case FOR:
			case RETURN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				stmt();
				setState(199);
				stmt_list();
				}
				break;
			case ELIF:
			case ELSE:
			case ENDIF:
			case END:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmt);
		try {
			setState(207);
			switch (_input.LA(1)) {
			case READ:
			case WRITE:
			case RETURN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				base_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				if_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				for_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_stmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterBase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitBase_stmt(this);
		}
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_base_stmt);
		try {
			setState(213);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				assign_stmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				read_stmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				write_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_list2Context extends ParserRuleContext {
		public List<id> ids;
		public List<id> _ids = new ArrayList();
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tail2Context id_tail2() {
			return getRuleContext(Id_tail2Context.class,0);
		}
		public Id_list2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_list2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_list2(this);
		}
	}

	public final Id_list2Context id_list2() throws RecognitionException {
		Id_list2Context _localctx = new Id_list2Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_id_list2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Id_list2Context)_localctx).ids = new ArrayList<id>();
			setState(216);
			((Id_list2Context)_localctx).id = id();
			id tmp=new id(); tmp.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup((((Id_list2Context)_localctx).id!=null?_input.getText(((Id_list2Context)_localctx).id.start,((Id_list2Context)_localctx).id.stop):null)); if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+(((Id_list2Context)_localctx).id!=null?_input.getText(((Id_list2Context)_localctx).id.start,((Id_list2Context)_localctx).id.stop):null)); tmp.name=symbol.GetName(); tmp.dataType=symbol.GetType(); _localctx.ids.add(tmp);
			setState(218);
			id_tail2();
			 for(int i=0;i<_localctx._ids.size();i++) _localctx.ids.add(_localctx._ids.get(i));  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_tail2Context extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tail2Context id_tail2() {
			return getRuleContext(Id_tail2Context.class,0);
		}
		public Id_tail2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_tail2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_tail2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_tail2(this);
		}
	}

	public final Id_tail2Context id_tail2() throws RecognitionException {
		Id_tail2Context _localctx = new Id_tail2Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_id_tail2);
		try {
			setState(227);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(T__2);
				setState(222);
				((Id_tail2Context)_localctx).id = id();
				 id tmp=new id(); tmp.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup((((Id_tail2Context)_localctx).id!=null?_input.getText(((Id_tail2Context)_localctx).id.start,((Id_tail2Context)_localctx).id.stop):null)); if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+(((Id_tail2Context)_localctx).id!=null?_input.getText(((Id_tail2Context)_localctx).id.start,((Id_tail2Context)_localctx).id.stop):null)); tmp.name=symbol.GetName();   tmp.dataType=symbol.GetType(); ((Id_list2Context)getInvokingContext(20))._ids.add(tmp);
				setState(224);
				id_tail2();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			assign_expr();
			setState(230);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public IdContext t1;
		public IdContext id;
		public ExprContext t2;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			AstTree tree =new AstTree(); exp assign_op=new exp();  tree.root = assign_op; assign_op.type=NodeType.exp; assign_op.opType=OpType.assign; 
			setState(233);
			((Assign_exprContext)_localctx).t1 = ((Assign_exprContext)_localctx).id = id();
			setState(234);
			match(T__0);
			setState(235);
			((Assign_exprContext)_localctx).t2 = expr();
			 id id_var =new id(); id_var.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup((((Assign_exprContext)_localctx).id!=null?_input.getText(((Assign_exprContext)_localctx).id.start,((Assign_exprContext)_localctx).id.stop):null));     if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+(((Assign_exprContext)_localctx).id!=null?_input.getText(((Assign_exprContext)_localctx).id.start,((Assign_exprContext)_localctx).id.stop):null)); ((id)id_var).name=symbol.GetName(); ((id)id_var).dataType=symbol.GetType(); assign_op.left=id_var; assign_op.right=((Assign_exprContext)_localctx).t2.node; Micro.astTrees.add(tree);  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public Id_list2Context t1;
		public TerminalNode READ() { return getToken(MicroParser.READ, 0); }
		public Id_list2Context id_list2() {
			return getRuleContext(Id_list2Context.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitRead_stmt(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 AstTree tree =new AstTree();
			setState(239);
			match(READ);
			setState(240);
			match(T__3);
			setState(241);
			((Read_stmtContext)_localctx).t1 = id_list2();
			setState(242);
			match(T__4);
			setState(243);
			match(T__1);
			 read_write node=new read_write(); node.type=NodeType.read; node.id_list=((Read_stmtContext)_localctx).t1.ids;  tree.root=node;  Micro.astTrees.add(tree); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_stmtContext extends ParserRuleContext {
		public Id_list2Context t1;
		public TerminalNode WRITE() { return getToken(MicroParser.WRITE, 0); }
		public Id_list2Context id_list2() {
			return getRuleContext(Id_list2Context.class,0);
		}
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterWrite_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitWrite_stmt(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 AstTree tree =new AstTree();
			setState(247);
			match(WRITE);
			setState(248);
			match(T__3);
			setState(249);
			((Write_stmtContext)_localctx).t1 = id_list2();
			setState(250);
			match(T__4);
			setState(251);
			match(T__1);
			 read_write node=new read_write(); node.type=NodeType.write; node.id_list=((Write_stmtContext)_localctx).t1.ids;    tree.root=node;  Micro.astTrees.add(tree);  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MicroParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(RETURN);
			setState(255);
			expr();
			setState(256);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AstNode node;
		public Expr_prefixContext t1;
		public FactorContext t2;
		public Expr_prefixContext expr_prefix() {
			return getRuleContext(Expr_prefixContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			((ExprContext)_localctx).t1 = expr_prefix(0);
			setState(259);
			((ExprContext)_localctx).t2 = factor();
			 if(((exp)(((ExprContext)_localctx).t1.node))!=null) {((exp)(((ExprContext)_localctx).t1.node)).right=((ExprContext)_localctx).t2.node; ((ExprContext)_localctx).node = ((ExprContext)_localctx).t1.node;} else { ((ExprContext)_localctx).node =  ((ExprContext)_localctx).t2.node;} 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_prefixContext extends ParserRuleContext {
		public AstNode node;
		public Expr_prefixContext t1;
		public FactorContext t2;
		public AddopContext t3;
		public Expr_prefixContext expr_prefix() {
			return getRuleContext(Expr_prefixContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public Expr_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_prefix(this);
		}
	}

	public final Expr_prefixContext expr_prefix() throws RecognitionException {
		return expr_prefix(0);
	}

	private Expr_prefixContext expr_prefix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_prefixContext _localctx = new Expr_prefixContext(_ctx, _parentState);
		Expr_prefixContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expr_prefix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			((Expr_prefixContext)_localctx).node = null;
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_prefixContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr_prefix);
					setState(265);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(266);
					((Expr_prefixContext)_localctx).t2 = factor();
					setState(267);
					((Expr_prefixContext)_localctx).t3 = addop();
					  exp add_node=new exp(); add_node.type=NodeType.exp; if((((Expr_prefixContext)_localctx).t3!=null?_input.getText(((Expr_prefixContext)_localctx).t3.start,((Expr_prefixContext)_localctx).t3.stop):null).equals("+")) add_node.opType=OpType.add;  else add_node.opType=OpType.sub;   if(((Expr_prefixContext)_localctx).t1.node==null){ add_node.left=((Expr_prefixContext)_localctx).t2.node; ((Expr_prefixContext)_localctx).node = add_node;}else {((exp)(((Expr_prefixContext)_localctx).t1.node)).right=((Expr_prefixContext)_localctx).t2.node; add_node.left=((Expr_prefixContext)_localctx).t1.node; ((Expr_prefixContext)_localctx).node = add_node; }
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public AstNode node;
		public Factor_prefixContext t1;
		public Postfix_exprContext t2;
		public Factor_prefixContext factor_prefix() {
			return getRuleContext(Factor_prefixContext.class,0);
		}
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			((FactorContext)_localctx).t1 = factor_prefix(0);
			setState(276);
			((FactorContext)_localctx).t2 = postfix_expr();
			 if(((exp)(((FactorContext)_localctx).t1.node))!=null){((exp)(((FactorContext)_localctx).t1.node)).right=((FactorContext)_localctx).t2.node; ((FactorContext)_localctx).node = ((FactorContext)_localctx).t1.node;} else {((FactorContext)_localctx).node = ((FactorContext)_localctx).t2.node;} 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factor_prefixContext extends ParserRuleContext {
		public AstNode node;
		public Factor_prefixContext t1;
		public Postfix_exprContext t2;
		public MulopContext t3;
		public Factor_prefixContext factor_prefix() {
			return getRuleContext(Factor_prefixContext.class,0);
		}
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public Factor_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFactor_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFactor_prefix(this);
		}
	}

	public final Factor_prefixContext factor_prefix() throws RecognitionException {
		return factor_prefix(0);
	}

	private Factor_prefixContext factor_prefix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Factor_prefixContext _localctx = new Factor_prefixContext(_ctx, _parentState);
		Factor_prefixContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_factor_prefix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			((Factor_prefixContext)_localctx).node = null;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Factor_prefixContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_factor_prefix);
					setState(282);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(283);
					((Factor_prefixContext)_localctx).t2 = postfix_expr();
					setState(284);
					((Factor_prefixContext)_localctx).t3 = mulop();
					 exp mul_node=new exp(); mul_node.type=NodeType.exp	; if((((Factor_prefixContext)_localctx).t3!=null?_input.getText(((Factor_prefixContext)_localctx).t3.start,((Factor_prefixContext)_localctx).t3.stop):null).equals("*")) mul_node.opType=OpType.mul;  else mul_node.opType=OpType.div;   if(((Factor_prefixContext)_localctx).t1.node==null){ mul_node.left=((Factor_prefixContext)_localctx).t2.node; ((Factor_prefixContext)_localctx).node = mul_node;}else {((exp)(((Factor_prefixContext)_localctx).t1.node)).right=((Factor_prefixContext)_localctx).t2.node; mul_node.left=((Factor_prefixContext)_localctx).t1.node; ((Factor_prefixContext)_localctx).node = mul_node;}       
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Postfix_exprContext extends ParserRuleContext {
		public AstNode node;
		public PrimaryContext t1;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Postfix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPostfix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPostfix_expr(this);
		}
	}

	public final Postfix_exprContext postfix_expr() throws RecognitionException {
		Postfix_exprContext _localctx = new Postfix_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_postfix_expr);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((Postfix_exprContext)_localctx).t1 = primary();
				 ((Postfix_exprContext)_localctx).node = ((Postfix_exprContext)_localctx).t1.node;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				call_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_exprContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCall_expr(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_call_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			id();
			setState(299);
			match(T__3);
			setState(300);
			expr_list();
			setState(301);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expr_list);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				expr();
				setState(304);
				expr_list_tail();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_list_tailContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_list_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list_tail(this);
		}
	}

	public final Expr_list_tailContext expr_list_tail() throws RecognitionException {
		Expr_list_tailContext _localctx = new Expr_list_tailContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expr_list_tail);
		try {
			setState(314);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(T__2);
				setState(310);
				expr();
				setState(311);
				expr_list_tail();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public AstNode node;
		public ExprContext t1;
		public IdContext t2;
		public IdContext id;
		public Token t3;
		public Token t4;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INTLITERAL() { return getToken(MicroParser.INTLITERAL, 0); }
		public TerminalNode FLOATLITERAL() { return getToken(MicroParser.FLOATLITERAL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_primary);
		try {
			setState(328);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				match(T__3);
				setState(317);
				((PrimaryContext)_localctx).t1 = expr();
				setState(318);
				match(T__4);
				 ((PrimaryContext)_localctx).node = ((PrimaryContext)_localctx).t1.node;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				((PrimaryContext)_localctx).t2 = ((PrimaryContext)_localctx).id = id();
				 ((PrimaryContext)_localctx).node = new id(); _localctx.node.type=NodeType.id; Symbol symbol= Micro.symbolTables.Lookup((((PrimaryContext)_localctx).id!=null?_input.getText(((PrimaryContext)_localctx).id.start,((PrimaryContext)_localctx).id.stop):null));  if(symbol==null) throw new RuntimeException("Varaiable not  decleared  "+(((PrimaryContext)_localctx).id!=null?_input.getText(((PrimaryContext)_localctx).id.start,((PrimaryContext)_localctx).id.stop):null));    ((id)_localctx.node).name=symbol.GetName();; ((id)_localctx.node).dataType=symbol.GetType();
				}
				break;
			case INTLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(324);
				((PrimaryContext)_localctx).t3 = match(INTLITERAL);
				 ((PrimaryContext)_localctx).node = new literal(); ((literal)_localctx.node).number=Integer.parseInt((((PrimaryContext)_localctx).t3!=null?((PrimaryContext)_localctx).t3.getText():null));((literal)_localctx.node).dataType=Type.INT;  _localctx.node.type=NodeType.literal; 
				}
				break;
			case FLOATLITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				((PrimaryContext)_localctx).t4 = match(FLOATLITERAL);
				 ((PrimaryContext)_localctx).node = new literal(); ((literal)_localctx.node).dataType=Type.FLOAT; ((literal)_localctx.node).number=Float.parseFloat((((PrimaryContext)_localctx).t4!=null?((PrimaryContext)_localctx).t4.getText():null)); _localctx.node.type=NodeType.literal; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAddop(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public CondContext t1;
		public TerminalNode IF() { return getToken(MicroParser.IF, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Elif_partContext elif_part() {
			return getRuleContext(Elif_partContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(MicroParser.ENDIF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(IF);
			Micro.symbolTables.createNewScope(ScopeType.Block,null);
			setState(336);
			match(T__3);
			setState(337);
			((If_stmtContext)_localctx).t1 = cond();
			setState(338);
			match(T__4);
			setState(339);
			decl();
			setState(340);
			stmt_list();
			setState(341);
			elif_part();
			setState(342);
			match(ENDIF);
			Micro.symbolTables.popTable(); AstTree tree =new AstTree();   tree.root =((If_stmtContext)_localctx).t1.node; ; ((If_stmtContext)_localctx).t1.node.type=NodeType.cond;  Micro.astTrees.add(tree);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Elif_partContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(MicroParser.ELIF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Elif_partContext elif_part() {
			return getRuleContext(Elif_partContext.class,0);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public Elif_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterElif_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitElif_part(this);
		}
	}

	public final Elif_partContext elif_part() throws RecognitionException {
		Elif_partContext _localctx = new Elif_partContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_elif_part);
		try {
			setState(356);
			switch (_input.LA(1)) {
			case ELIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(ELIF);
				Micro.symbolTables.createNewScope(ScopeType.Block,null);
				setState(347);
				match(T__3);
				setState(348);
				cond();
				setState(349);
				match(T__4);
				setState(350);
				decl();
				setState(351);
				stmt_list();
				Micro.symbolTables.popTable();
				setState(353);
				elif_part();
				}
				break;
			case ELSE:
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				else_part();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_partContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MicroParser.ELSE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Else_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterElse_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitElse_part(this);
		}
	}

	public final Else_partContext else_part() throws RecognitionException {
		Else_partContext _localctx = new Else_partContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_else_part);
		try {
			setState(365);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				match(ELSE);
				Micro.symbolTables.createNewScope(ScopeType.Block,null);
				setState(360);
				decl();
				setState(361);
				stmt_list();
				Micro.symbolTables.popTable();
				}
				break;
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public AstNode node;
		public LitContext t1;
		public Cond_suffixContext t2;
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public Cond_suffixContext cond_suffix() {
			return getRuleContext(Cond_suffixContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			((CondContext)_localctx).t1 = lit();
			  ((CondContext)_localctx).node = ((CondContext)_localctx).t1.node; 
			setState(369);
			((CondContext)_localctx).t2 = cond_suffix(_localctx.node);
			if(((CondContext)_localctx).t2.node!=null) ((CondContext)_localctx).node = ((CondContext)_localctx).t2.node;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_suffixContext extends ParserRuleContext {
		public AstNode in_node;
		public AstNode node;
		public LitContext t1;
		public Cond_suffixContext t2;
		public LitContext t3;
		public Cond_suffixContext t4;
		public TerminalNode OR() { return getToken(MicroParser.OR, 0); }
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public Cond_suffixContext cond_suffix() {
			return getRuleContext(Cond_suffixContext.class,0);
		}
		public TerminalNode AND() { return getToken(MicroParser.AND, 0); }
		public Cond_suffixContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Cond_suffixContext(ParserRuleContext parent, int invokingState, AstNode in_node) {
			super(parent, invokingState);
			this.in_node = in_node;
		}
		@Override public int getRuleIndex() { return RULE_cond_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond_suffix(this);
		}
	}

	public final Cond_suffixContext cond_suffix(AstNode in_node) throws RecognitionException {
		Cond_suffixContext _localctx = new Cond_suffixContext(_ctx, getState(), in_node);
		enterRule(_localctx, 84, RULE_cond_suffix);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(OR);
				setState(373);
				((Cond_suffixContext)_localctx).t1 = lit();
				  boolExp tmp=new boolExp(); tmp.right=((Cond_suffixContext)_localctx).t1.node; tmp.left=_localctx.in_node; tmp.type=NodeType.cond; tmp.opType=LogicOp.or; ((Cond_suffixContext)_localctx).node = tmp; 
				setState(375);
				((Cond_suffixContext)_localctx).t2 = cond_suffix(_localctx.node);

				if(((Cond_suffixContext)_localctx).t2.node!=null) ((Cond_suffixContext)_localctx).node = ((Cond_suffixContext)_localctx).t2.node; 
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				match(AND);
				setState(379);
				((Cond_suffixContext)_localctx).t3 = lit();
				  boolExp tmp=new boolExp(); tmp.right=((Cond_suffixContext)_localctx).t3.node;  tmp.left=_localctx.in_node; tmp.type=NodeType.cond; tmp.opType=LogicOp.and; ((Cond_suffixContext)_localctx).node = tmp; 
				setState(381);
				((Cond_suffixContext)_localctx).t4 = cond_suffix(_localctx.node);

				if(((Cond_suffixContext)_localctx).t4.node!=null) ((Cond_suffixContext)_localctx).node = ((Cond_suffixContext)_localctx).t4.node;  
				}
				break;
			case T__1:
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				((Cond_suffixContext)_localctx).node = null;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LitContext extends ParserRuleContext {
		public AstNode node;
		public Basic_condContext t1;
		public Basic_condContext t2;
		public TerminalNode NOT() { return getToken(MicroParser.NOT, 0); }
		public Basic_condContext basic_cond() {
			return getRuleContext(Basic_condContext.class,0);
		}
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitLit(this);
		}
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_lit);
		try {
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(NOT);
				setState(388);
				((LitContext)_localctx).t1 = basic_cond();
				((boolExp)(((LitContext)_localctx).t1.node)).opType=LogicOp.not; ((LitContext)_localctx).node = ((LitContext)_localctx).t1.node;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				((LitContext)_localctx).t2 = basic_cond();
				((LitContext)_localctx).node = ((LitContext)_localctx).t2.node; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Basic_condContext extends ParserRuleContext {
		public AstNode node;
		public ExprContext t1;
		public CompopContext t2;
		public ExprContext t3;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(MicroParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MicroParser.FALSE, 0); }
		public Basic_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterBasic_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitBasic_cond(this);
		}
	}

	public final Basic_condContext basic_cond() throws RecognitionException {
		Basic_condContext _localctx = new Basic_condContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_basic_cond);
		try {
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				((Basic_condContext)_localctx).t1 = expr();
				setState(397);
				((Basic_condContext)_localctx).t2 = compop();
				setState(398);
				((Basic_condContext)_localctx).t3 = expr();
				 boolExp tmp=new boolExp(); tmp.left=((Basic_condContext)_localctx).t1.node; tmp.type=NodeType.cond; tmp.right=((Basic_condContext)_localctx).t3.node; tmp.opType=LogicOp.noOp; tmp.compOp=boolExp.getOpFromString((((Basic_condContext)_localctx).t2!=null?_input.getText(((Basic_condContext)_localctx).t2.start,((Basic_condContext)_localctx).t2.stop):null));  ((Basic_condContext)_localctx).node = tmp;  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(TRUE);
				 boolExp tmp=new boolExp(); tmp.left=null; tmp.right=null; tmp.opType=LogicOp.noOp;tmp.type=NodeType.cond;  tmp.compOp=CompOp.True;  ((Basic_condContext)_localctx).node = tmp; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(FALSE);
				 boolExp tmp=new boolExp(); tmp.left=null; tmp.right=null; tmp.opType=LogicOp.noOp; tmp.type=NodeType.cond; tmp.compOp=CompOp.False;  ((Basic_condContext)_localctx).node = tmp; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompopContext extends ParserRuleContext {
		public CompopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCompop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCompop(this);
		}
	}

	public final CompopContext compop() throws RecognitionException {
		CompopContext _localctx = new CompopContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_compop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Init_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterInit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitInit_stmt(this);
		}
	}

	public final Init_stmtContext init_stmt() throws RecognitionException {
		Init_stmtContext _localctx = new Init_stmtContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_init_stmt);
		try {
			setState(411);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				assign_expr();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Incr_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Incr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterIncr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitIncr_stmt(this);
		}
	}

	public final Incr_stmtContext incr_stmt() throws RecognitionException {
		Incr_stmtContext _localctx = new Incr_stmtContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_incr_stmt);
		try {
			setState(415);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				assign_expr();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MicroParser.FOR, 0); }
		public Init_stmtContext init_stmt() {
			return getRuleContext(Init_stmtContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public Incr_stmtContext incr_stmt() {
			return getRuleContext(Incr_stmtContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Aug_stmt_listContext aug_stmt_list() {
			return getRuleContext(Aug_stmt_listContext.class,0);
		}
		public TerminalNode ENDFOR() { return getToken(MicroParser.ENDFOR, 0); }
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(FOR);
			 Micro.symbolTables.createNewScope(ScopeType.Block,null);
			setState(419);
			match(T__3);
			setState(420);
			init_stmt();
			setState(421);
			match(T__1);
			setState(422);
			cond();
			setState(423);
			match(T__1);
			setState(424);
			incr_stmt();
			setState(425);
			match(T__4);
			setState(426);
			decl();
			setState(427);
			aug_stmt_list();
			setState(428);
			match(ENDFOR);
			Micro.symbolTables.popTable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aug_stmt_listContext extends ParserRuleContext {
		public Aug_stmtContext aug_stmt() {
			return getRuleContext(Aug_stmtContext.class,0);
		}
		public Aug_stmt_listContext aug_stmt_list() {
			return getRuleContext(Aug_stmt_listContext.class,0);
		}
		public Aug_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aug_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAug_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAug_stmt_list(this);
		}
	}

	public final Aug_stmt_listContext aug_stmt_list() throws RecognitionException {
		Aug_stmt_listContext _localctx = new Aug_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_aug_stmt_list);
		try {
			setState(435);
			switch (_input.LA(1)) {
			case READ:
			case WRITE:
			case IF:
			case FOR:
			case CONTINUE:
			case BREAK:
			case RETURN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				aug_stmt();
				setState(432);
				aug_stmt_list();
				}
				break;
			case ELIF:
			case ELSE:
			case ENDIF:
			case ENDFOR:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aug_stmtContext extends ParserRuleContext {
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public Aug_if_stmtContext aug_if_stmt() {
			return getRuleContext(Aug_if_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public TerminalNode CONTINUE() { return getToken(MicroParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(MicroParser.BREAK, 0); }
		public Aug_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aug_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAug_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAug_stmt(this);
		}
	}

	public final Aug_stmtContext aug_stmt() throws RecognitionException {
		Aug_stmtContext _localctx = new Aug_stmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_aug_stmt);
		try {
			setState(444);
			switch (_input.LA(1)) {
			case READ:
			case WRITE:
			case RETURN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				base_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				aug_if_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				for_stmt();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(440);
				match(CONTINUE);
				setState(441);
				match(T__1);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 5);
				{
				setState(442);
				match(BREAK);
				setState(443);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aug_if_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MicroParser.IF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Aug_stmt_listContext aug_stmt_list() {
			return getRuleContext(Aug_stmt_listContext.class,0);
		}
		public Aug_elif_partContext aug_elif_part() {
			return getRuleContext(Aug_elif_partContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(MicroParser.ENDIF, 0); }
		public Aug_if_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aug_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAug_if_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAug_if_stmt(this);
		}
	}

	public final Aug_if_stmtContext aug_if_stmt() throws RecognitionException {
		Aug_if_stmtContext _localctx = new Aug_if_stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_aug_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(IF);
			setState(447);
			match(T__3);
			setState(448);
			cond();
			setState(449);
			match(T__4);
			setState(450);
			decl();
			setState(451);
			aug_stmt_list();
			setState(452);
			aug_elif_part();
			setState(453);
			match(ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aug_elif_partContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(MicroParser.ELIF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Aug_stmt_listContext aug_stmt_list() {
			return getRuleContext(Aug_stmt_listContext.class,0);
		}
		public Aug_elif_partContext aug_elif_part() {
			return getRuleContext(Aug_elif_partContext.class,0);
		}
		public Aug_else_partContext aug_else_part() {
			return getRuleContext(Aug_else_partContext.class,0);
		}
		public Aug_elif_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aug_elif_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAug_elif_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAug_elif_part(this);
		}
	}

	public final Aug_elif_partContext aug_elif_part() throws RecognitionException {
		Aug_elif_partContext _localctx = new Aug_elif_partContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_aug_elif_part);
		try {
			setState(464);
			switch (_input.LA(1)) {
			case ELIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(ELIF);
				setState(456);
				match(T__3);
				setState(457);
				cond();
				setState(458);
				match(T__4);
				setState(459);
				decl();
				setState(460);
				aug_stmt_list();
				setState(461);
				aug_elif_part();
				}
				break;
			case ELSE:
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				aug_else_part();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aug_else_partContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MicroParser.ELSE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Aug_stmt_listContext aug_stmt_list() {
			return getRuleContext(Aug_stmt_listContext.class,0);
		}
		public Aug_else_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aug_else_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAug_else_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAug_else_part(this);
		}
	}

	public final Aug_else_partContext aug_else_part() throws RecognitionException {
		Aug_else_partContext _localctx = new Aug_else_partContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_aug_else_part);
		try {
			setState(471);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				match(ELSE);
				setState(467);
				decl();
				setState(468);
				aug_stmt_list();
				}
				break;
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return expr_prefix_sempred((Expr_prefixContext)_localctx, predIndex);
		case 30:
			return factor_prefix_sempred((Factor_prefixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_prefix_sempred(Expr_prefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean factor_prefix_sempred(Factor_prefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u01dc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u0095\n\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r"+
		"\5\r\u00a7\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00b2"+
		"\n\17\3\20\3\20\3\20\3\20\5\20\u00b8\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23"+
		"\u00cd\n\23\3\24\3\24\3\24\5\24\u00d2\n\24\3\25\3\25\3\25\3\25\5\25\u00d8"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00e6\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\7\36\u0111\n\36\f\36\16\36\u0114\13\36\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3 \7 \u0122\n \f \16 \u0125\13 \3!\3!\3!\3!\5!\u012b"+
		"\n!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\5#\u0136\n#\3$\3$\3$\3$\3$\5$\u013d"+
		"\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u014b\n%\3&\3&\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0167"+
		"\n)\3*\3*\3*\3*\3*\3*\3*\5*\u0170\n*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\5,\u0184\n,\3-\3-\3-\3-\3-\3-\3-\5-\u018d\n-\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0198\n.\3/\3/\3\60\3\60\5\60\u019e\n\60\3"+
		"\61\3\61\5\61\u01a2\n\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u01b6\n\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\5\64\u01bf\n\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u01d3"+
		"\n\66\3\67\3\67\3\67\3\67\3\67\5\67\u01da\n\67\3\67\2\4:>8\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"`bdfhjl\2\6\4\2\'\'**\3\2\b\t\3\2\n\13\3\2\f\21\u01cb\2n\3\2\2\2\4t\3"+
		"\2\2\2\6v\3\2\2\2\b\u0080\3\2\2\2\n\u0082\3\2\2\2\f\u0089\3\2\2\2\16\u008b"+
		"\3\2\2\2\20\u0090\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u00a0\3"+
		"\2\2\2\30\u00a6\3\2\2\2\32\u00a8\3\2\2\2\34\u00b1\3\2\2\2\36\u00b7\3\2"+
		"\2\2 \u00b9\3\2\2\2\"\u00c5\3\2\2\2$\u00cc\3\2\2\2&\u00d1\3\2\2\2(\u00d7"+
		"\3\2\2\2*\u00d9\3\2\2\2,\u00e5\3\2\2\2.\u00e7\3\2\2\2\60\u00ea\3\2\2\2"+
		"\62\u00f0\3\2\2\2\64\u00f8\3\2\2\2\66\u0100\3\2\2\28\u0104\3\2\2\2:\u0108"+
		"\3\2\2\2<\u0115\3\2\2\2>\u0119\3\2\2\2@\u012a\3\2\2\2B\u012c\3\2\2\2D"+
		"\u0135\3\2\2\2F\u013c\3\2\2\2H\u014a\3\2\2\2J\u014c\3\2\2\2L\u014e\3\2"+
		"\2\2N\u0150\3\2\2\2P\u0166\3\2\2\2R\u016f\3\2\2\2T\u0171\3\2\2\2V\u0183"+
		"\3\2\2\2X\u018c\3\2\2\2Z\u0197\3\2\2\2\\\u0199\3\2\2\2^\u019d\3\2\2\2"+
		"`\u01a1\3\2\2\2b\u01a3\3\2\2\2d\u01b5\3\2\2\2f\u01be\3\2\2\2h\u01c0\3"+
		"\2\2\2j\u01d2\3\2\2\2l\u01d9\3\2\2\2no\7+\2\2op\5\4\3\2pq\7,\2\2qr\5\6"+
		"\4\2rs\7-\2\2s\3\3\2\2\2tu\7/\2\2u\5\3\2\2\2vw\5\b\5\2wx\5\36\20\2x\7"+
		"\3\2\2\2yz\5\n\6\2z{\5\b\5\2{\u0081\3\2\2\2|}\5\16\b\2}~\5\b\5\2~\u0081"+
		"\3\2\2\2\177\u0081\3\2\2\2\u0080y\3\2\2\2\u0080|\3\2\2\2\u0080\177\3\2"+
		"\2\2\u0081\t\3\2\2\2\u0082\u0083\7)\2\2\u0083\u0084\5\4\3\2\u0084\u0085"+
		"\7\3\2\2\u0085\u0086\5\f\7\2\u0086\u0087\7\4\2\2\u0087\u0088\b\6\1\2\u0088"+
		"\13\3\2\2\2\u0089\u008a\7\24\2\2\u008a\r\3\2\2\2\u008b\u008c\5\20\t\2"+
		"\u008c\u008d\5\24\13\2\u008d\u008e\7\4\2\2\u008e\u008f\b\b\1\2\u008f\17"+
		"\3\2\2\2\u0090\u0091\t\2\2\2\u0091\21\3\2\2\2\u0092\u0095\5\20\t\2\u0093"+
		"\u0095\7(\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\23\3\2\2\2"+
		"\u0096\u0097\5\4\3\2\u0097\u0098\b\13\1\2\u0098\u0099\5\26\f\2\u0099\25"+
		"\3\2\2\2\u009a\u009b\7\5\2\2\u009b\u009c\5\4\3\2\u009c\u009d\b\f\1\2\u009d"+
		"\u009e\5\26\f\2\u009e\u00a1\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009a\3"+
		"\2\2\2\u00a0\u009f\3\2\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\5\32\16\2\u00a3"+
		"\u00a4\5\34\17\2\u00a4\u00a7\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a2\3"+
		"\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00a9\5\20\t\2\u00a9"+
		"\u00aa\5\4\3\2\u00aa\u00ab\b\16\1\2\u00ab\33\3\2\2\2\u00ac\u00ad\7\5\2"+
		"\2\u00ad\u00ae\5\32\16\2\u00ae\u00af\5\34\17\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\35\3\2\2"+
		"\2\u00b3\u00b4\5 \21\2\u00b4\u00b5\5\36\20\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\37\3\2\2"+
		"\2\u00b9\u00ba\7\33\2\2\u00ba\u00bb\5\22\n\2\u00bb\u00bc\5\4\3\2\u00bc"+
		"\u00bd\b\21\1\2\u00bd\u00be\7\6\2\2\u00be\u00bf\5\30\r\2\u00bf\u00c0\7"+
		"\7\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\5\"\22\2\u00c2\u00c3\7-\2\2\u00c3"+
		"\u00c4\b\21\1\2\u00c4!\3\2\2\2\u00c5\u00c6\5\b\5\2\u00c6\u00c7\5$\23\2"+
		"\u00c7#\3\2\2\2\u00c8\u00c9\5&\24\2\u00c9\u00ca\5$\23\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"%\3\2\2\2\u00ce\u00d2\5(\25\2\u00cf\u00d2\5N(\2\u00d0\u00d2\5b\62\2\u00d1"+
		"\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\'\3\2\2\2"+
		"\u00d3\u00d8\5.\30\2\u00d4\u00d8\5\62\32\2\u00d5\u00d8\5\64\33\2\u00d6"+
		"\u00d8\5\66\34\2\u00d7\u00d3\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d6\3\2\2\2\u00d8)\3\2\2\2\u00d9\u00da\b\26\1\2\u00da\u00db"+
		"\5\4\3\2\u00db\u00dc\b\26\1\2\u00dc\u00dd\5,\27\2\u00dd\u00de\b\26\1\2"+
		"\u00de+\3\2\2\2\u00df\u00e0\7\5\2\2\u00e0\u00e1\5\4\3\2\u00e1\u00e2\b"+
		"\27\1\2\u00e2\u00e3\5,\27\2\u00e3\u00e6\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00df\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6-\3\2\2\2\u00e7\u00e8\5\60\31"+
		"\2\u00e8\u00e9\7\4\2\2\u00e9/\3\2\2\2\u00ea\u00eb\b\31\1\2\u00eb\u00ec"+
		"\5\4\3\2\u00ec\u00ed\7\3\2\2\u00ed\u00ee\58\35\2\u00ee\u00ef\b\31\1\2"+
		"\u00ef\61\3\2\2\2\u00f0\u00f1\b\32\1\2\u00f1\u00f2\7\34\2\2\u00f2\u00f3"+
		"\7\6\2\2\u00f3\u00f4\5*\26\2\u00f4\u00f5\7\7\2\2\u00f5\u00f6\7\4\2\2\u00f6"+
		"\u00f7\b\32\1\2\u00f7\63\3\2\2\2\u00f8\u00f9\b\33\1\2\u00f9\u00fa\7\35"+
		"\2\2\u00fa\u00fb\7\6\2\2\u00fb\u00fc\5*\26\2\u00fc\u00fd\7\7\2\2\u00fd"+
		"\u00fe\7\4\2\2\u00fe\u00ff\b\33\1\2\u00ff\65\3\2\2\2\u0100\u0101\7&\2"+
		"\2\u0101\u0102\58\35\2\u0102\u0103\7\4\2\2\u0103\67\3\2\2\2\u0104\u0105"+
		"\5:\36\2\u0105\u0106\5<\37\2\u0106\u0107\b\35\1\2\u01079\3\2\2\2\u0108"+
		"\u0109\b\36\1\2\u0109\u010a\b\36\1\2\u010a\u0112\3\2\2\2\u010b\u010c\f"+
		"\4\2\2\u010c\u010d\5<\37\2\u010d\u010e\5J&\2\u010e\u010f\b\36\1\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010b\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113;\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116"+
		"\5> \2\u0116\u0117\5@!\2\u0117\u0118\b\37\1\2\u0118=\3\2\2\2\u0119\u011a"+
		"\b \1\2\u011a\u011b\b \1\2\u011b\u0123\3\2\2\2\u011c\u011d\f\4\2\2\u011d"+
		"\u011e\5@!\2\u011e\u011f\5L\'\2\u011f\u0120\b \1\2\u0120\u0122\3\2\2\2"+
		"\u0121\u011c\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124?\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\5H%\2\u0127\u0128"+
		"\b!\1\2\u0128\u012b\3\2\2\2\u0129\u012b\5B\"\2\u012a\u0126\3\2\2\2\u012a"+
		"\u0129\3\2\2\2\u012bA\3\2\2\2\u012c\u012d\5\4\3\2\u012d\u012e\7\6\2\2"+
		"\u012e\u012f\5D#\2\u012f\u0130\7\7\2\2\u0130C\3\2\2\2\u0131\u0132\58\35"+
		"\2\u0132\u0133\5F$\2\u0133\u0136\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0131"+
		"\3\2\2\2\u0135\u0134\3\2\2\2\u0136E\3\2\2\2\u0137\u0138\7\5\2\2\u0138"+
		"\u0139\58\35\2\u0139\u013a\5F$\2\u013a\u013d\3\2\2\2\u013b\u013d\3\2\2"+
		"\2\u013c\u0137\3\2\2\2\u013c\u013b\3\2\2\2\u013dG\3\2\2\2\u013e\u013f"+
		"\7\6\2\2\u013f\u0140\58\35\2\u0140\u0141\7\7\2\2\u0141\u0142\b%\1\2\u0142"+
		"\u014b\3\2\2\2\u0143\u0144\5\4\3\2\u0144\u0145\b%\1\2\u0145\u014b\3\2"+
		"\2\2\u0146\u0147\7\22\2\2\u0147\u014b\b%\1\2\u0148\u0149\7\23\2\2\u0149"+
		"\u014b\b%\1\2\u014a\u013e\3\2\2\2\u014a\u0143\3\2\2\2\u014a\u0146\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014bI\3\2\2\2\u014c\u014d\t\3\2\2\u014dK\3\2"+
		"\2\2\u014e\u014f\t\4\2\2\u014fM\3\2\2\2\u0150\u0151\7\36\2\2\u0151\u0152"+
		"\b(\1\2\u0152\u0153\7\6\2\2\u0153\u0154\5T+\2\u0154\u0155\7\7\2\2\u0155"+
		"\u0156\5\b\5\2\u0156\u0157\5$\23\2\u0157\u0158\5P)\2\u0158\u0159\7!\2"+
		"\2\u0159\u015a\b(\1\2\u015aO\3\2\2\2\u015b\u015c\7\37\2\2\u015c\u015d"+
		"\b)\1\2\u015d\u015e\7\6\2\2\u015e\u015f\5T+\2\u015f\u0160\7\7\2\2\u0160"+
		"\u0161\5\b\5\2\u0161\u0162\5$\23\2\u0162\u0163\b)\1\2\u0163\u0164\5P)"+
		"\2\u0164\u0167\3\2\2\2\u0165\u0167\5R*\2\u0166\u015b\3\2\2\2\u0166\u0165"+
		"\3\2\2\2\u0167Q\3\2\2\2\u0168\u0169\7 \2\2\u0169\u016a\b*\1\2\u016a\u016b"+
		"\5\b\5\2\u016b\u016c\5$\23\2\u016c\u016d\b*\1\2\u016d\u0170\3\2\2\2\u016e"+
		"\u0170\3\2\2\2\u016f\u0168\3\2\2\2\u016f\u016e\3\2\2\2\u0170S\3\2\2\2"+
		"\u0171\u0172\5X-\2\u0172\u0173\b+\1\2\u0173\u0174\5V,\2\u0174\u0175\b"+
		"+\1\2\u0175U\3\2\2\2\u0176\u0177\7\26\2\2\u0177\u0178\5X-\2\u0178\u0179"+
		"\b,\1\2\u0179\u017a\5V,\2\u017a\u017b\b,\1\2\u017b\u0184\3\2\2\2\u017c"+
		"\u017d\7\27\2\2\u017d\u017e\5X-\2\u017e\u017f\b,\1\2\u017f\u0180\5V,\2"+
		"\u0180\u0181\b,\1\2\u0181\u0184\3\2\2\2\u0182\u0184\b,\1\2\u0183\u0176"+
		"\3\2\2\2\u0183\u017c\3\2\2\2\u0183\u0182\3\2\2\2\u0184W\3\2\2\2\u0185"+
		"\u0186\7\30\2\2\u0186\u0187\5Z.\2\u0187\u0188\b-\1\2\u0188\u018d\3\2\2"+
		"\2\u0189\u018a\5Z.\2\u018a\u018b\b-\1\2\u018b\u018d\3\2\2\2\u018c\u0185"+
		"\3\2\2\2\u018c\u0189\3\2\2\2\u018dY\3\2\2\2\u018e\u018f\58\35\2\u018f"+
		"\u0190\5\\/\2\u0190\u0191\58\35\2\u0191\u0192\b.\1\2\u0192\u0198\3\2\2"+
		"\2\u0193\u0194\7\31\2\2\u0194\u0198\b.\1\2\u0195\u0196\7\32\2\2\u0196"+
		"\u0198\b.\1\2\u0197\u018e\3\2\2\2\u0197\u0193\3\2\2\2\u0197\u0195\3\2"+
		"\2\2\u0198[\3\2\2\2\u0199\u019a\t\5\2\2\u019a]\3\2\2\2\u019b\u019e\5\60"+
		"\31\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019e"+
		"_\3\2\2\2\u019f\u01a2\5\60\31\2\u01a0\u01a2\3\2\2\2\u01a1\u019f\3\2\2"+
		"\2\u01a1\u01a0\3\2\2\2\u01a2a\3\2\2\2\u01a3\u01a4\7\"\2\2\u01a4\u01a5"+
		"\b\62\1\2\u01a5\u01a6\7\6\2\2\u01a6\u01a7\5^\60\2\u01a7\u01a8\7\4\2\2"+
		"\u01a8\u01a9\5T+\2\u01a9\u01aa\7\4\2\2\u01aa\u01ab\5`\61\2\u01ab\u01ac"+
		"\7\7\2\2\u01ac\u01ad\5\b\5\2\u01ad\u01ae\5d\63\2\u01ae\u01af\7#\2\2\u01af"+
		"\u01b0\b\62\1\2\u01b0c\3\2\2\2\u01b1\u01b2\5f\64\2\u01b2\u01b3\5d\63\2"+
		"\u01b3\u01b6\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b4"+
		"\3\2\2\2\u01b6e\3\2\2\2\u01b7\u01bf\5(\25\2\u01b8\u01bf\5h\65\2\u01b9"+
		"\u01bf\5b\62\2\u01ba\u01bb\7$\2\2\u01bb\u01bf\7\4\2\2\u01bc\u01bd\7%\2"+
		"\2\u01bd\u01bf\7\4\2\2\u01be\u01b7\3\2\2\2\u01be\u01b8\3\2\2\2\u01be\u01b9"+
		"\3\2\2\2\u01be\u01ba\3\2\2\2\u01be\u01bc\3\2\2\2\u01bfg\3\2\2\2\u01c0"+
		"\u01c1\7\36\2\2\u01c1\u01c2\7\6\2\2\u01c2\u01c3\5T+\2\u01c3\u01c4\7\7"+
		"\2\2\u01c4\u01c5\5\b\5\2\u01c5\u01c6\5d\63\2\u01c6\u01c7\5j\66\2\u01c7"+
		"\u01c8\7!\2\2\u01c8i\3\2\2\2\u01c9\u01ca\7\37\2\2\u01ca\u01cb\7\6\2\2"+
		"\u01cb\u01cc\5T+\2\u01cc\u01cd\7\7\2\2\u01cd\u01ce\5\b\5\2\u01ce\u01cf"+
		"\5d\63\2\u01cf\u01d0\5j\66\2\u01d0\u01d3\3\2\2\2\u01d1\u01d3\5l\67\2\u01d2"+
		"\u01c9\3\2\2\2\u01d2\u01d1\3\2\2\2\u01d3k\3\2\2\2\u01d4\u01d5\7 \2\2\u01d5"+
		"\u01d6\5\b\5\2\u01d6\u01d7\5d\63\2\u01d7\u01da\3\2\2\2\u01d8\u01da\3\2"+
		"\2\2\u01d9\u01d4\3\2\2\2\u01d9\u01d8\3\2\2\2\u01dam\3\2\2\2\35\u0080\u0094"+
		"\u00a0\u00a6\u00b1\u00b7\u00cc\u00d1\u00d7\u00e5\u0112\u0123\u012a\u0135"+
		"\u013c\u014a\u0166\u016f\u0183\u018c\u0197\u019d\u01a1\u01b5\u01be\u01d2"+
		"\u01d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}