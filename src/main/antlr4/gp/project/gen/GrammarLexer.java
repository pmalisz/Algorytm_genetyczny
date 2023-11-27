// Generated from java-escape by ANTLR 4.11.1
package gp.project.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, WHILE=3, IN=4, OUT=5, PROGRAM=6, SEMI=7, LEFT_PAREN=8, RIGHT_PAREN=9, 
		LEFT_BRACE=10, RIGHT_BRACE=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, ASSIGN=16, 
		GREATER_THEN=17, LESS_THEN=18, AND=19, OR=20, NOT=21, EQUAL=22, NOT_EQUAL=23, 
		ID=24, INT=25, WHITESPACE=26, NEWLINE=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LETTER", "IF", "ELSE", "WHILE", "IN", "OUT", "PROGRAM", "SEMI", 
			"LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "PLUS", "MINUS", 
			"TIMES", "DIV", "ASSIGN", "GREATER_THEN", "LESS_THEN", "AND", "OR", "NOT", 
			"EQUAL", "NOT_EQUAL", "ID", "INT", "WHITESPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", "'in'", "'out'", "'program'", "';'", 
			"'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'='", "'>'", 
			"'<'", "'&&'", "'||'", "'!'", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "WHILE", "IN", "OUT", "PROGRAM", "SEMI", "LEFT_PAREN", 
			"RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "PLUS", "MINUS", "TIMES", 
			"DIV", "ASSIGN", "GREATER_THEN", "LESS_THEN", "AND", "OR", "NOT", "EQUAL", 
			"NOT_EQUAL", "ID", "INT", "WHITESPACE", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\u0004\u0000\u001b\u009e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0086\b\u0019\n\u0019\f\u0019"+
		"\u0089\t\u0019\u0001\u001a\u0004\u001a\u008c\b\u001a\u000b\u001a\f\u001a"+
		"\u008d\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0003"+
		"\u001c\u0095\b\u001c\u0001\u001c\u0001\u001c\u0004\u001c\u0099\b\u001c"+
		"\u000b\u001c\f\u001c\u009a\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001"+
		"\u0000\u0003\u0000\u0005\u0001\u0007\u0002\t\u0003\u000b\u0004\r\u0005"+
		"\u000f\u0006\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019\u000b\u001b\f\u001d"+
		"\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013+\u0014-\u0015/\u0016"+
		"1\u00173\u00185\u00197\u001a9\u001b\u0001\u0000\u0003\u0001\u000009\u0002"+
		"\u0000AZaz\u0002\u0000\t\t  \u00a1\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001"+
		";\u0001\u0000\u0000\u0000\u0003=\u0001\u0000\u0000\u0000\u0005?\u0001"+
		"\u0000\u0000\u0000\u0007B\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000"+
		"\u0000\u000bM\u0001\u0000\u0000\u0000\rP\u0001\u0000\u0000\u0000\u000f"+
		"T\u0001\u0000\u0000\u0000\u0011\\\u0001\u0000\u0000\u0000\u0013^\u0001"+
		"\u0000\u0000\u0000\u0015`\u0001\u0000\u0000\u0000\u0017b\u0001\u0000\u0000"+
		"\u0000\u0019d\u0001\u0000\u0000\u0000\u001bf\u0001\u0000\u0000\u0000\u001d"+
		"h\u0001\u0000\u0000\u0000\u001fj\u0001\u0000\u0000\u0000!l\u0001\u0000"+
		"\u0000\u0000#n\u0001\u0000\u0000\u0000%p\u0001\u0000\u0000\u0000\'r\u0001"+
		"\u0000\u0000\u0000)t\u0001\u0000\u0000\u0000+w\u0001\u0000\u0000\u0000"+
		"-z\u0001\u0000\u0000\u0000/|\u0001\u0000\u0000\u00001\u007f\u0001\u0000"+
		"\u0000\u00003\u0082\u0001\u0000\u0000\u00005\u008b\u0001\u0000\u0000\u0000"+
		"7\u008f\u0001\u0000\u0000\u00009\u0098\u0001\u0000\u0000\u0000;<\u0007"+
		"\u0000\u0000\u0000<\u0002\u0001\u0000\u0000\u0000=>\u0007\u0001\u0000"+
		"\u0000>\u0004\u0001\u0000\u0000\u0000?@\u0005i\u0000\u0000@A\u0005f\u0000"+
		"\u0000A\u0006\u0001\u0000\u0000\u0000BC\u0005e\u0000\u0000CD\u0005l\u0000"+
		"\u0000DE\u0005s\u0000\u0000EF\u0005e\u0000\u0000F\b\u0001\u0000\u0000"+
		"\u0000GH\u0005w\u0000\u0000HI\u0005h\u0000\u0000IJ\u0005i\u0000\u0000"+
		"JK\u0005l\u0000\u0000KL\u0005e\u0000\u0000L\n\u0001\u0000\u0000\u0000"+
		"MN\u0005i\u0000\u0000NO\u0005n\u0000\u0000O\f\u0001\u0000\u0000\u0000"+
		"PQ\u0005o\u0000\u0000QR\u0005u\u0000\u0000RS\u0005t\u0000\u0000S\u000e"+
		"\u0001\u0000\u0000\u0000TU\u0005p\u0000\u0000UV\u0005r\u0000\u0000VW\u0005"+
		"o\u0000\u0000WX\u0005g\u0000\u0000XY\u0005r\u0000\u0000YZ\u0005a\u0000"+
		"\u0000Z[\u0005m\u0000\u0000[\u0010\u0001\u0000\u0000\u0000\\]\u0005;\u0000"+
		"\u0000]\u0012\u0001\u0000\u0000\u0000^_\u0005(\u0000\u0000_\u0014\u0001"+
		"\u0000\u0000\u0000`a\u0005)\u0000\u0000a\u0016\u0001\u0000\u0000\u0000"+
		"bc\u0005{\u0000\u0000c\u0018\u0001\u0000\u0000\u0000de\u0005}\u0000\u0000"+
		"e\u001a\u0001\u0000\u0000\u0000fg\u0005+\u0000\u0000g\u001c\u0001\u0000"+
		"\u0000\u0000hi\u0005-\u0000\u0000i\u001e\u0001\u0000\u0000\u0000jk\u0005"+
		"*\u0000\u0000k \u0001\u0000\u0000\u0000lm\u0005/\u0000\u0000m\"\u0001"+
		"\u0000\u0000\u0000no\u0005=\u0000\u0000o$\u0001\u0000\u0000\u0000pq\u0005"+
		">\u0000\u0000q&\u0001\u0000\u0000\u0000rs\u0005<\u0000\u0000s(\u0001\u0000"+
		"\u0000\u0000tu\u0005&\u0000\u0000uv\u0005&\u0000\u0000v*\u0001\u0000\u0000"+
		"\u0000wx\u0005|\u0000\u0000xy\u0005|\u0000\u0000y,\u0001\u0000\u0000\u0000"+
		"z{\u0005!\u0000\u0000{.\u0001\u0000\u0000\u0000|}\u0005=\u0000\u0000}"+
		"~\u0005=\u0000\u0000~0\u0001\u0000\u0000\u0000\u007f\u0080\u0005!\u0000"+
		"\u0000\u0080\u0081\u0005=\u0000\u0000\u00812\u0001\u0000\u0000\u0000\u0082"+
		"\u0087\u0003\u0003\u0001\u0000\u0083\u0086\u0003\u0003\u0001\u0000\u0084"+
		"\u0086\u0003\u0001\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"4\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008c"+
		"\u0003\u0001\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e6\u0001\u0000\u0000\u0000\u008f\u0090\u0007"+
		"\u0002\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006"+
		"\u001b\u0000\u0000\u00928\u0001\u0000\u0000\u0000\u0093\u0095\u0005\r"+
		"\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0005\n\u0000"+
		"\u0000\u0097\u0099\u0005\r\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0006\u001c\u0000\u0000"+
		"\u009d:\u0001\u0000\u0000\u0000\u0007\u0000\u0085\u0087\u008d\u0094\u0098"+
		"\u009a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}