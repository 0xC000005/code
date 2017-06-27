package cn.dataidea.tinylang.gen;

// Generated from Tiny.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SEMIC=3, COLON=4, COMMA=5, EQ=6, ASSIGN=7, PLUS=8, TIMES=9, 
		TRUE=10, FALSE=11, LPAR=12, RPAR=13, CLPAR=14, CRPAR=15, IF=16, THEN=17, 
		ELSE=18, PRINT=19, LET=20, DO=21, VAR=22, FUN=23, INT=24, BOOL=25, CLASS=26, 
		EXTENDS=27, INTEGER=28, ID=29, WS=30, LINECOMENTS=31, BLOCKCOMENTS=32, 
		ERR=33;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_body = 2, RULE_defcls = 3, RULE_supers = 4, 
		RULE_slots = 5, RULE_slotd = 6, RULE_let = 7, RULE_dec = 8, RULE_fun = 9, 
		RULE_varasm = 10, RULE_vardec = 11, RULE_type = 12, RULE_exp = 13, RULE_term = 14, 
		RULE_factor = 15, RULE_value = 16;
	public static final String[] ruleNames = {
		"prog", "block", "body", "defcls", "supers", "slots", "slotd", "let", 
		"dec", "fun", "varasm", "vardec", "type", "exp", "term", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'.'", "';'", "':'", "','", "'=='", "'='", "'+'", "'*'", 
		"'true'", "'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", 
		"'print'", "'let'", "'do'", "'var'", "'fun'", "'int'", "'bool'", "'class'", 
		"'extends'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "SEMIC", "COLON", "COMMA", "EQ", "ASSIGN", "PLUS", "TIMES", 
		"TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", 
		"PRINT", "LET", "DO", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTENDS", 
		"INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
	public String getGrammarFileName() { return "Tiny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				block();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << LET) | (1L << INT) | (1L << BOOL) | (1L << CLASS) | (1L << INTEGER) | (1L << ID))) != 0) );
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CodeBodyContext extends BlockContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public CodeBodyContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterCodeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitCodeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitCodeBody(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDefContext extends BlockContext {
		public DefclsContext defcls() {
			return getRuleContext(DefclsContext.class,0);
		}
		public ClassDefContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GlobalVarContext extends BlockContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public GlobalVarContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterGlobalVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitGlobalVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitGlobalVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new CodeBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				body();
				}
				break;
			case 2:
				_localctx = new GlobalVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				varasm();
				}
				break;
			case 3:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				defcls();
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

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	 
		public BodyContext() { }
		public void copyFrom(BodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpContext extends BodyContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LetInExpContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterLetInExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitLetInExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends BodyContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SingleExpContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSingleExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSingleExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case PRINT:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				exp();
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				let();
				setState(46);
				exp();
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

	public static class DefclsContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(TinyParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TerminalNode CLPAR() { return getToken(TinyParser.CLPAR, 0); }
		public SlotsContext slots() {
			return getRuleContext(SlotsContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(TinyParser.CRPAR, 0); }
		public SupersContext supers() {
			return getRuleContext(SupersContext.class,0);
		}
		public DefclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defcls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterDefcls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitDefcls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitDefcls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefclsContext defcls() throws RecognitionException {
		DefclsContext _localctx = new DefclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defcls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(CLASS);
			setState(51);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(52);
				supers();
				}
			}

			setState(55);
			match(CLPAR);
			setState(56);
			slots();
			setState(57);
			match(CRPAR);
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

	public static class SupersContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(TinyParser.EXTENDS, 0); }
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public SupersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSupers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSupers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSupers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SupersContext supers() throws RecognitionException {
		SupersContext _localctx = new SupersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_supers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(EXTENDS);
			setState(60);
			match(ID);
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

	public static class SlotsContext extends ParserRuleContext {
		public List<SlotdContext> slotd() {
			return getRuleContexts(SlotdContext.class);
		}
		public SlotdContext slotd(int i) {
			return getRuleContext(SlotdContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(TinyParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(TinyParser.SEMIC, i);
		}
		public SlotsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slots; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSlots(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSlots(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSlots(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotsContext slots() throws RecognitionException {
		SlotsContext _localctx = new SlotsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_slots);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				{
				setState(62);
				slotd();
				setState(63);
				match(SEMIC);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SlotdContext extends ParserRuleContext {
		public SlotdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotd; }
	 
		public SlotdContext() { }
		public void copyFrom(SlotdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SlotNoInitContext extends SlotdContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public SlotNoInitContext(SlotdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSlotNoInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSlotNoInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSlotNoInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SlotInitContext extends SlotdContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public SlotInitContext(SlotdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSlotInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSlotInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSlotInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotdContext slotd() throws RecognitionException {
		SlotdContext _localctx = new SlotdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_slotd);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SlotNoInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				vardec();
				}
				break;
			case 2:
				_localctx = new SlotInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				varasm();
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(TinyParser.LET, 0); }
		public TerminalNode DO() { return getToken(TinyParser.DO, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(TinyParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(TinyParser.SEMIC, i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LET);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				dec();
				setState(76);
				match(SEMIC);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0) );
			setState(82);
			match(DO);
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignmentContext extends DecContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarAssignmentContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitVarAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterFunDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitFunDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitFunDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dec);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				fun();
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TinyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TinyParser.RPAR, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TinyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TinyParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			setState(89);
			match(ID);
			setState(90);
			match(LPAR);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				setState(91);
				vardec();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					match(COMMA);
					setState(93);
					vardec();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(101);
			match(RPAR);
			setState(102);
			body();
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

	public static class VarasmContext extends ParserRuleContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(TinyParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterVarasm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitVarasm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitVarasm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			vardec();
			setState(105);
			match(ASSIGN);
			setState(106);
			exp();
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			type();
			setState(109);
			match(ID);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TinyParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(TinyParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class ExpContext extends ParserRuleContext {
		public TermContext left;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(TinyParser.PLUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			((ExpContext)_localctx).left = term();
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(114);
				match(PLUS);
				setState(115);
				((ExpContext)_localctx).right = exp();
				}
				break;
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(TinyParser.TIMES, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((TermContext)_localctx).left = factor();
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(119);
				match(TIMES);
				setState(120);
				((TermContext)_localctx).right = term();
				}
				break;
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(TinyParser.EQ, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			((FactorContext)_localctx).left = value(0);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(124);
				match(EQ);
				setState(125);
				((FactorContext)_localctx).right = value(0);
				}
				break;
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(TinyParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TinyParser.RPAR, 0); }
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterBaseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitBaseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TinyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TinyParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TinyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TinyParser.COMMA, i);
		}
		public ClassExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterClassExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitClassExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitClassExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public VarExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitVarExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(TinyParser.INTEGER, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitIntVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodExpContext extends ValueContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TinyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TinyParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TinyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TinyParser.COMMA, i);
		}
		public MethodExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterMethodExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitMethodExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitMethodExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SlotExpContext extends ValueContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public SlotExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterSlotExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitSlotExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitSlotExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpContext extends ValueContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(TinyParser.IF, 0); }
		public TerminalNode THEN() { return getToken(TinyParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(TinyParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(TinyParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(TinyParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(TinyParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(TinyParser.ELSE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterIfExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitIfExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitIfExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExpContext extends ValueContext {
		public TerminalNode PRINT() { return getToken(TinyParser.PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterPrintExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitPrintExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitPrintExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(TinyParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TinyParser.FALSE, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterBoolVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitBoolVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(TinyParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TinyParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TinyParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TinyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TinyParser.COMMA, i);
		}
		public FunExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).enterFunExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyListener ) ((TinyListener)listener).exitFunExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyVisitor ) return ((TinyVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new IntValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new BoolValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new BaseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(LPAR);
				setState(132);
				exp();
				setState(133);
				match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new IfExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(IF);
				setState(136);
				((IfExpContext)_localctx).cond = exp();
				setState(137);
				match(THEN);
				setState(138);
				match(CLPAR);
				setState(139);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(140);
				match(CRPAR);
				setState(141);
				match(ELSE);
				setState(142);
				match(CLPAR);
				setState(143);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(144);
				match(CRPAR);
				}
				break;
			case 5:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new FunExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(ID);
				setState(148);
				match(LPAR);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(149);
					exp();
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(150);
						match(COMMA);
						setState(151);
						exp();
						}
						}
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(159);
				match(RPAR);
				}
				break;
			case 7:
				{
				_localctx = new PrintExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(PRINT);
				setState(161);
				exp();
				}
				break;
			case 8:
				{
				_localctx = new ClassExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(T__0);
				setState(163);
				match(ID);
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(164);
					match(LPAR);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(165);
						exp();
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(166);
							match(COMMA);
							setState(167);
							exp();
							}
							}
							setState(172);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(175);
					match(RPAR);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MethodExpContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(180);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(181);
						match(T__1);
						setState(182);
						match(ID);
						setState(183);
						match(LPAR);
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
							{
							setState(184);
							exp();
							setState(189);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(185);
								match(COMMA);
								setState(186);
								exp();
								}
								}
								setState(191);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(194);
						match(RPAR);
						}
						break;
					case 2:
						{
						_localctx = new SlotExpContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(195);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(196);
						match(T__1);
						setState(197);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00ce\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\5\4\63\n"+
		"\4\3\5\3\5\3\5\5\58\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7D\n"+
		"\7\f\7\16\7G\13\7\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\6\tQ\n\t\r\t\16\tR"+
		"\3\t\3\t\3\n\3\n\5\nY\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13a\n\13\f\13"+
		"\16\13d\13\13\5\13f\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\5\17w\n\17\3\20\3\20\3\20\5\20|\n\20\3\21\3\21"+
		"\3\21\5\21\u0081\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\7\22\u009b\n\22\f\22\16\22\u009e\13\22\5\22\u00a0\n\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00ab\n\22\f\22\16\22\u00ae\13\22"+
		"\5\22\u00b0\n\22\3\22\5\22\u00b3\n\22\5\22\u00b5\n\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\7\22\u00be\n\22\f\22\16\22\u00c1\13\22\5\22\u00c3\n"+
		"\22\3\22\3\22\3\22\3\22\7\22\u00c9\n\22\f\22\16\22\u00cc\13\22\3\22\2"+
		"\3\"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\4\2\32\33\37\37"+
		"\3\2\f\r\2\u00da\2%\3\2\2\2\4,\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\n=\3"+
		"\2\2\2\fE\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22X\3\2\2\2\24Z\3\2\2\2\26j"+
		"\3\2\2\2\30n\3\2\2\2\32q\3\2\2\2\34s\3\2\2\2\36x\3\2\2\2 }\3\2\2\2\"\u00b4"+
		"\3\2\2\2$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2"+
		"\2)-\5\6\4\2*-\5\26\f\2+-\5\b\5\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\5\3\2"+
		"\2\2.\63\5\34\17\2/\60\5\20\t\2\60\61\5\34\17\2\61\63\3\2\2\2\62.\3\2"+
		"\2\2\62/\3\2\2\2\63\7\3\2\2\2\64\65\7\34\2\2\65\67\7\37\2\2\668\5\n\6"+
		"\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\20\2\2:;\5\f\7\2;<\7\21\2\2"+
		"<\t\3\2\2\2=>\7\35\2\2>?\7\37\2\2?\13\3\2\2\2@A\5\16\b\2AB\7\5\2\2BD\3"+
		"\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\r\3\2\2\2GE\3\2\2\2HK"+
		"\5\30\r\2IK\5\26\f\2JH\3\2\2\2JI\3\2\2\2K\17\3\2\2\2LP\7\26\2\2MN\5\22"+
		"\n\2NO\7\5\2\2OQ\3\2\2\2PM\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2"+
		"\2\2TU\7\27\2\2U\21\3\2\2\2VY\5\26\f\2WY\5\24\13\2XV\3\2\2\2XW\3\2\2\2"+
		"Y\23\3\2\2\2Z[\5\32\16\2[\\\7\37\2\2\\e\7\16\2\2]b\5\30\r\2^_\7\7\2\2"+
		"_a\5\30\r\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2"+
		"\2e]\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\17\2\2hi\5\6\4\2i\25\3\2\2\2jk\5"+
		"\30\r\2kl\7\t\2\2lm\5\34\17\2m\27\3\2\2\2no\5\32\16\2op\7\37\2\2p\31\3"+
		"\2\2\2qr\t\2\2\2r\33\3\2\2\2sv\5\36\20\2tu\7\n\2\2uw\5\34\17\2vt\3\2\2"+
		"\2vw\3\2\2\2w\35\3\2\2\2x{\5 \21\2yz\7\13\2\2z|\5\36\20\2{y\3\2\2\2{|"+
		"\3\2\2\2|\37\3\2\2\2}\u0080\5\"\22\2~\177\7\b\2\2\177\u0081\5\"\22\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081!\3\2\2\2\u0082\u0083\b\22\1\2\u0083"+
		"\u00b5\7\36\2\2\u0084\u00b5\t\3\2\2\u0085\u0086\7\16\2\2\u0086\u0087\5"+
		"\34\17\2\u0087\u0088\7\17\2\2\u0088\u00b5\3\2\2\2\u0089\u008a\7\22\2\2"+
		"\u008a\u008b\5\34\17\2\u008b\u008c\7\23\2\2\u008c\u008d\7\20\2\2\u008d"+
		"\u008e\5\34\17\2\u008e\u008f\7\21\2\2\u008f\u0090\7\24\2\2\u0090\u0091"+
		"\7\20\2\2\u0091\u0092\5\34\17\2\u0092\u0093\7\21\2\2\u0093\u00b5\3\2\2"+
		"\2\u0094\u00b5\7\37\2\2\u0095\u0096\7\37\2\2\u0096\u009f\7\16\2\2\u0097"+
		"\u009c\5\34\17\2\u0098\u0099\7\7\2\2\u0099\u009b\5\34\17\2\u009a\u0098"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u0097\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00b5\7\17\2\2\u00a2\u00a3\7\25\2\2\u00a3"+
		"\u00b5\5\34\17\2\u00a4\u00a5\7\3\2\2\u00a5\u00b2\7\37\2\2\u00a6\u00af"+
		"\7\16\2\2\u00a7\u00ac\5\34\17\2\u00a8\u00a9\7\7\2\2\u00a9\u00ab\5\34\17"+
		"\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00a7\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\7\17\2\2\u00b2\u00a6\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u0082\3\2\2\2\u00b4"+
		"\u0084\3\2\2\2\u00b4\u0085\3\2\2\2\u00b4\u0089\3\2\2\2\u00b4\u0094\3\2"+
		"\2\2\u00b4\u0095\3\2\2\2\u00b4\u00a2\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b5"+
		"\u00ca\3\2\2\2\u00b6\u00b7\f\4\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\7\37"+
		"\2\2\u00b9\u00c2\7\16\2\2\u00ba\u00bf\5\34\17\2\u00bb\u00bc\7\7\2\2\u00bc"+
		"\u00be\5\34\17\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3"+
		"\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00ba\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c9\7\17"+
		"\2\2\u00c5\u00c6\f\3\2\2\u00c6\u00c7\7\4\2\2\u00c7\u00c9\7\37\2\2\u00c8"+
		"\u00b6\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb#\3\2\2\2\u00cc\u00ca\3\2\2\2\31\',\62\67"+
		"EJRXbev{\u0080\u009c\u009f\u00ac\u00af\u00b2\u00b4\u00bf\u00c2\u00c8\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}