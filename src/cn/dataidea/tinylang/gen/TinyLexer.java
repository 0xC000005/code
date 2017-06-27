package cn.dataidea.tinylang.gen;

// Generated from Tiny.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "SEMIC", "COLON", "COMMA", "EQ", "ASSIGN", "PLUS", "TIMES", 
		"TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", 
		"PRINT", "LET", "DO", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTENDS", 
		"DIGIT", "INTEGER", "CHAR", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
		"ERR"
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


	public TinyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tiny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\5\36\u00ae\n\36\3\36\6\36\u00b1\n\36\r\36\16\36\u00b2\3\37\3\37"+
		"\3 \3 \3 \7 \u00ba\n \f \16 \u00bd\13 \3!\6!\u00c0\n!\r!\16!\u00c1\3!"+
		"\3!\3\"\3\"\3\"\3\"\7\"\u00ca\n\"\f\"\16\"\u00cd\13\"\3\"\6\"\u00d0\n"+
		"\"\r\"\16\"\u00d1\3\"\3\"\3#\3#\3#\3#\7#\u00da\n#\f#\16#\u00dd\13#\3#"+
		"\3#\3#\3#\3#\3$\3$\3$\3$\4\u00cb\u00db\2%\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\2;\36=\2?\37A C!E\"G#\3\2\5\4\2C"+
		"\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00ec\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2"+
		"\13S\3\2\2\2\rU\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2"+
		"\2\27c\3\2\2\2\31i\3\2\2\2\33k\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!q\3\2\2"+
		"\2#t\3\2\2\2%y\3\2\2\2\'~\3\2\2\2)\u0084\3\2\2\2+\u0088\3\2\2\2-\u008b"+
		"\3\2\2\2/\u008f\3\2\2\2\61\u0093\3\2\2\2\63\u0097\3\2\2\2\65\u009c\3\2"+
		"\2\2\67\u00a2\3\2\2\29\u00aa\3\2\2\2;\u00ad\3\2\2\2=\u00b4\3\2\2\2?\u00b6"+
		"\3\2\2\2A\u00bf\3\2\2\2C\u00c5\3\2\2\2E\u00d5\3\2\2\2G\u00e3\3\2\2\2I"+
		"J\7p\2\2JK\7g\2\2KL\7y\2\2L\4\3\2\2\2MN\7\60\2\2N\6\3\2\2\2OP\7=\2\2P"+
		"\b\3\2\2\2QR\7<\2\2R\n\3\2\2\2ST\7.\2\2T\f\3\2\2\2UV\7?\2\2VW\7?\2\2W"+
		"\16\3\2\2\2XY\7?\2\2Y\20\3\2\2\2Z[\7-\2\2[\22\3\2\2\2\\]\7,\2\2]\24\3"+
		"\2\2\2^_\7v\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2b\26\3\2\2\2cd\7h\2\2de\7c\2"+
		"\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\30\3\2\2\2ij\7*\2\2j\32\3\2\2\2kl\7+\2"+
		"\2l\34\3\2\2\2mn\7}\2\2n\36\3\2\2\2op\7\177\2\2p \3\2\2\2qr\7k\2\2rs\7"+
		"h\2\2s\"\3\2\2\2tu\7v\2\2uv\7j\2\2vw\7g\2\2wx\7p\2\2x$\3\2\2\2yz\7g\2"+
		"\2z{\7n\2\2{|\7u\2\2|}\7g\2\2}&\3\2\2\2~\177\7r\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7v\2\2\u0083(\3\2\2\2\u0084"+
		"\u0085\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7v\2\2\u0087*\3\2\2\2\u0088"+
		"\u0089\7f\2\2\u0089\u008a\7q\2\2\u008a,\3\2\2\2\u008b\u008c\7x\2\2\u008c"+
		"\u008d\7c\2\2\u008d\u008e\7t\2\2\u008e.\3\2\2\2\u008f\u0090\7h\2\2\u0090"+
		"\u0091\7w\2\2\u0091\u0092\7p\2\2\u0092\60\3\2\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7v\2\2\u0096\62\3\2\2\2\u0097\u0098\7d\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7q\2\2\u009a\u009b\7n\2\2\u009b\64\3\2\2\2\u009c"+
		"\u009d\7e\2\2\u009d\u009e\7n\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7u\2\2"+
		"\u00a0\u00a1\7u\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7"+
		"z\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8"+
		"\7f\2\2\u00a8\u00a9\7u\2\2\u00a98\3\2\2\2\u00aa\u00ab\4\62;\2\u00ab:\3"+
		"\2\2\2\u00ac\u00ae\7/\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00b1\59\35\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3<\3\2\2\2\u00b4\u00b5"+
		"\t\2\2\2\u00b5>\3\2\2\2\u00b6\u00bb\5=\37\2\u00b7\u00ba\5=\37\2\u00b8"+
		"\u00ba\59\35\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc@\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be\u00c0\t\3\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b!"+
		"\2\2\u00c4B\3\2\2\2\u00c5\u00c6\7\61\2\2\u00c6\u00c7\7\61\2\2\u00c7\u00cb"+
		"\3\2\2\2\u00c8\u00ca\13\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2"+
		"\u00cb\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00d0\t\4\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\""+
		"\2\2\u00d4D\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\7,\2\2\u00d7\u00db"+
		"\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\b#\2\2\u00e2F\3\2\2\2\u00e3\u00e4\13\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e5\u00e6\b$\3\2\u00e6H\3\2\2\2\13\2\u00ad\u00b2\u00b9\u00bb\u00c1"+
		"\u00cb\u00d1\u00db\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}