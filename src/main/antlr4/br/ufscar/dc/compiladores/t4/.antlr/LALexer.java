// Generated from /home/julio/java/T4-Compiladores/src/main/antlr4/br/ufscar/dc/compiladores/t4/LA.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALGORITMO=1, FIM_ALGORITMO=2, DECLARE=3, LEIA=4, ESCREVA=5, NAO=6, E=7, 
		OU=8, VERDADEIRO=9, FALSO=10, REGISTRO=11, FIM_REGISTRO=12, PROCEDIMENTO=13, 
		FIM_PROCEDIMENTO=14, FUNCAO=15, FIM_FUNCAO=16, VAR=17, SE=18, FIM_SE=19, 
		SENAO=20, ENTAO=21, CASO=22, FIM_CASO=23, SEJA=24, PARA=25, FIM_PARA=26, 
		ATE=27, FACA=28, ENQUANTO=29, FIM_ENQUANTO=30, RETORNE=31, TIPO=32, CONSTANTE=33, 
		LITERAL=34, INTEIRO=35, REAL=36, LOGICO=37, SOMA=38, SUBTRACAO=39, MULTIPLICACAO=40, 
		DIVISAO=41, PORCENTO=42, IGUAL=43, DIFERENTE=44, MENORIGUAL=45, MAIORIGUAL=46, 
		MENOR=47, MAIOR=48, PONTO=49, DOISPONTOS=50, VIRGULA=51, ABREPAR=52, FECHAPAR=53, 
		ABREBAR=54, FECHABAR=55, SEQ=56, SETA=57, PONTEIRO=58, ENDERECO=59, IDENT=60, 
		NUM_INT=61, NUM_REAL=62, CADEIA=63, CADEIA_NAO_FECHADA=64, COMENTARIO=65, 
		COMENTARIO_NAO_FECHADO=66, ERRO=67, IGNORE=68;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALGORITMO", "FIM_ALGORITMO", "DECLARE", "LEIA", "ESCREVA", "NAO", "E", 
			"OU", "VERDADEIRO", "FALSO", "REGISTRO", "FIM_REGISTRO", "PROCEDIMENTO", 
			"FIM_PROCEDIMENTO", "FUNCAO", "FIM_FUNCAO", "VAR", "SE", "FIM_SE", "SENAO", 
			"ENTAO", "CASO", "FIM_CASO", "SEJA", "PARA", "FIM_PARA", "ATE", "FACA", 
			"ENQUANTO", "FIM_ENQUANTO", "RETORNE", "TIPO", "CONSTANTE", "LITERAL", 
			"INTEIRO", "REAL", "LOGICO", "SOMA", "SUBTRACAO", "MULTIPLICACAO", "DIVISAO", 
			"PORCENTO", "IGUAL", "DIFERENTE", "MENORIGUAL", "MAIORIGUAL", "MENOR", 
			"MAIOR", "PONTO", "DOISPONTOS", "VIRGULA", "ABREPAR", "FECHAPAR", "ABREBAR", 
			"FECHABAR", "SEQ", "SETA", "PONTEIRO", "ENDERECO", "IDENT", "NUM_INT", 
			"NUM_REAL", "CADEIA", "CADEIA_NAO_FECHADA", "COMENTARIO", "COMENTARIO_NAO_FECHADO", 
			"ERRO", "IGNORE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'leia'", "'escreva'", 
			"'nao'", "'e'", "'ou'", "'verdadeiro'", "'falso'", "'registro'", "'fim_registro'", 
			"'procedimento'", "'fim_procedimento'", "'funcao'", "'fim_funcao'", "'var'", 
			"'se'", "'fim_se'", "'senao'", "'entao'", "'caso'", "'fim_caso'", "'seja'", 
			"'para'", "'fim_para'", "'ate'", "'faca'", "'enquanto'", "'fim_enquanto'", 
			"'retorne'", "'tipo'", "'constante'", "'literal'", "'inteiro'", "'real'", 
			"'logico'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'<>'", "'<='", 
			"'>='", "'<'", "'>'", "'.'", "':'", "','", "'('", "')'", "'['", "']'", 
			"'..'", "'<-'", "'^'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALGORITMO", "FIM_ALGORITMO", "DECLARE", "LEIA", "ESCREVA", "NAO", 
			"E", "OU", "VERDADEIRO", "FALSO", "REGISTRO", "FIM_REGISTRO", "PROCEDIMENTO", 
			"FIM_PROCEDIMENTO", "FUNCAO", "FIM_FUNCAO", "VAR", "SE", "FIM_SE", "SENAO", 
			"ENTAO", "CASO", "FIM_CASO", "SEJA", "PARA", "FIM_PARA", "ATE", "FACA", 
			"ENQUANTO", "FIM_ENQUANTO", "RETORNE", "TIPO", "CONSTANTE", "LITERAL", 
			"INTEIRO", "REAL", "LOGICO", "SOMA", "SUBTRACAO", "MULTIPLICACAO", "DIVISAO", 
			"PORCENTO", "IGUAL", "DIFERENTE", "MENORIGUAL", "MAIORIGUAL", "MENOR", 
			"MAIOR", "PONTO", "DOISPONTOS", "VIRGULA", "ABREPAR", "FECHAPAR", "ABREBAR", 
			"FECHABAR", "SEQ", "SETA", "PONTEIRO", "ENDERECO", "IDENT", "NUM_INT", 
			"NUM_REAL", "CADEIA", "CADEIA_NAO_FECHADA", "COMENTARIO", "COMENTARIO_NAO_FECHADO", 
			"ERRO", "IGNORE"
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


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LA.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 64:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			IGNORE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void IGNORE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u0227\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3."+
		"\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3<\3<\3=\3=\7"+
		"=\u01d9\n=\f=\16=\u01dc\13=\3=\7=\u01df\n=\f=\16=\u01e2\13=\3=\3=\7=\u01e6"+
		"\n=\f=\16=\u01e9\13=\5=\u01eb\n=\3>\6>\u01ee\n>\r>\16>\u01ef\3?\6?\u01f3"+
		"\n?\r?\16?\u01f4\3?\3?\6?\u01f9\n?\r?\16?\u01fa\3@\3@\7@\u01ff\n@\f@\16"+
		"@\u0202\13@\3@\3@\3A\3A\7A\u0208\nA\fA\16A\u020b\13A\3B\3B\7B\u020f\n"+
		"B\fB\16B\u0212\13B\3B\3B\3B\3C\3C\7C\u0219\nC\fC\16C\u021c\13C\3D\3D\3"+
		"D\3D\3D\5D\u0223\nD\3E\3E\3E\2\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\3\2\b\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17$$\6\2\13\f"+
		"\17\17}}\177\177\7\2##&&BB~~\u0080\u0080\5\2\13\f\17\17\"\"\2\u0233\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{"+
		"\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\3\u008b\3\2\2\2\5\u0095\3\2\2"+
		"\2\7\u00a3\3\2\2\2\t\u00ab\3\2\2\2\13\u00b0\3\2\2\2\r\u00b8\3\2\2\2\17"+
		"\u00bc\3\2\2\2\21\u00be\3\2\2\2\23\u00c1\3\2\2\2\25\u00cc\3\2\2\2\27\u00d2"+
		"\3\2\2\2\31\u00db\3\2\2\2\33\u00e8\3\2\2\2\35\u00f5\3\2\2\2\37\u0106\3"+
		"\2\2\2!\u010d\3\2\2\2#\u0118\3\2\2\2%\u011c\3\2\2\2\'\u011f\3\2\2\2)\u0126"+
		"\3\2\2\2+\u012c\3\2\2\2-\u0132\3\2\2\2/\u0137\3\2\2\2\61\u0140\3\2\2\2"+
		"\63\u0145\3\2\2\2\65\u014a\3\2\2\2\67\u0153\3\2\2\29\u0157\3\2\2\2;\u015c"+
		"\3\2\2\2=\u0165\3\2\2\2?\u0172\3\2\2\2A\u017a\3\2\2\2C\u017f\3\2\2\2E"+
		"\u0189\3\2\2\2G\u0191\3\2\2\2I\u0199\3\2\2\2K\u019e\3\2\2\2M\u01a5\3\2"+
		"\2\2O\u01a7\3\2\2\2Q\u01a9\3\2\2\2S\u01ab\3\2\2\2U\u01ad\3\2\2\2W\u01af"+
		"\3\2\2\2Y\u01b1\3\2\2\2[\u01b4\3\2\2\2]\u01b7\3\2\2\2_\u01ba\3\2\2\2a"+
		"\u01bc\3\2\2\2c\u01be\3\2\2\2e\u01c0\3\2\2\2g\u01c2\3\2\2\2i\u01c4\3\2"+
		"\2\2k\u01c6\3\2\2\2m\u01c8\3\2\2\2o\u01ca\3\2\2\2q\u01cc\3\2\2\2s\u01cf"+
		"\3\2\2\2u\u01d2\3\2\2\2w\u01d4\3\2\2\2y\u01d6\3\2\2\2{\u01ed\3\2\2\2}"+
		"\u01f2\3\2\2\2\177\u01fc\3\2\2\2\u0081\u0205\3\2\2\2\u0083\u020c\3\2\2"+
		"\2\u0085\u0216\3\2\2\2\u0087\u0222\3\2\2\2\u0089\u0224\3\2\2\2\u008b\u008c"+
		"\7c\2\2\u008c\u008d\7n\2\2\u008d\u008e\7i\2\2\u008e\u008f\7q\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091\u0092\7v\2\2\u0092\u0093\7o\2\2"+
		"\u0093\u0094\7q\2\2\u0094\4\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7k"+
		"\2\2\u0097\u0098\7o\2\2\u0098\u0099\7a\2\2\u0099\u009a\7c\2\2\u009a\u009b"+
		"\7n\2\2\u009b\u009c\7i\2\2\u009c\u009d\7q\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7k\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7o\2\2\u00a1\u00a2\7q\2\2"+
		"\u00a2\6\3\2\2\2\u00a3\u00a4\7f\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7e"+
		"\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\b\3\2\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7k\2\2\u00ae\u00af\7c\2\2\u00af\n\3\2\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2"+
		"\7u\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7x\2\2\u00b6\u00b7\7c\2\2\u00b7\f\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9"+
		"\u00ba\7c\2\2\u00ba\u00bb\7q\2\2\u00bb\16\3\2\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"\20\3\2\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7w\2\2\u00c0\22\3\2\2\2\u00c1"+
		"\u00c2\7x\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7f\2\2"+
		"\u00c5\u00c6\7c\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7q\2\2\u00cb\24\3\2\2\2\u00cc\u00cd"+
		"\7h\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7u\2\2\u00d0"+
		"\u00d1\7q\2\2\u00d1\26\3\2\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7g\2\2\u00d4"+
		"\u00d5\7i\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7v\2\2"+
		"\u00d8\u00d9\7t\2\2\u00d9\u00da\7q\2\2\u00da\30\3\2\2\2\u00db\u00dc\7"+
		"h\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7o\2\2\u00de\u00df\7a\2\2\u00df\u00e0"+
		"\7t\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7u\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7q\2\2"+
		"\u00e7\32\3\2\2\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7"+
		"q\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7f\2\2\u00ee\u00ef"+
		"\7k\2\2\u00ef\u00f0\7o\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7p\2\2\u00f2"+
		"\u00f3\7v\2\2\u00f3\u00f4\7q\2\2\u00f4\34\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6"+
		"\u00f7\7k\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9\7a\2\2\u00f9\u00fa\7r\2\2"+
		"\u00fa\u00fb\7t\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe"+
		"\7g\2\2\u00fe\u00ff\7f\2\2\u00ff\u0100\7k\2\2\u0100\u0101\7o\2\2\u0101"+
		"\u0102\7g\2\2\u0102\u0103\7p\2\2\u0103\u0104\7v\2\2\u0104\u0105\7q\2\2"+
		"\u0105\36\3\2\2\2\u0106\u0107\7h\2\2\u0107\u0108\7w\2\2\u0108\u0109\7"+
		"p\2\2\u0109\u010a\7e\2\2\u010a\u010b\7c\2\2\u010b\u010c\7q\2\2\u010c "+
		"\3\2\2\2\u010d\u010e\7h\2\2\u010e\u010f\7k\2\2\u010f\u0110\7o\2\2\u0110"+
		"\u0111\7a\2\2\u0111\u0112\7h\2\2\u0112\u0113\7w\2\2\u0113\u0114\7p\2\2"+
		"\u0114\u0115\7e\2\2\u0115\u0116\7c\2\2\u0116\u0117\7q\2\2\u0117\"\3\2"+
		"\2\2\u0118\u0119\7x\2\2\u0119\u011a\7c\2\2\u011a\u011b\7t\2\2\u011b$\3"+
		"\2\2\2\u011c\u011d\7u\2\2\u011d\u011e\7g\2\2\u011e&\3\2\2\2\u011f\u0120"+
		"\7h\2\2\u0120\u0121\7k\2\2\u0121\u0122\7o\2\2\u0122\u0123\7a\2\2\u0123"+
		"\u0124\7u\2\2\u0124\u0125\7g\2\2\u0125(\3\2\2\2\u0126\u0127\7u\2\2\u0127"+
		"\u0128\7g\2\2\u0128\u0129\7p\2\2\u0129\u012a\7c\2\2\u012a\u012b\7q\2\2"+
		"\u012b*\3\2\2\2\u012c\u012d\7g\2\2\u012d\u012e\7p\2\2\u012e\u012f\7v\2"+
		"\2\u012f\u0130\7c\2\2\u0130\u0131\7q\2\2\u0131,\3\2\2\2\u0132\u0133\7"+
		"e\2\2\u0133\u0134\7c\2\2\u0134\u0135\7u\2\2\u0135\u0136\7q\2\2\u0136."+
		"\3\2\2\2\u0137\u0138\7h\2\2\u0138\u0139\7k\2\2\u0139\u013a\7o\2\2\u013a"+
		"\u013b\7a\2\2\u013b\u013c\7e\2\2\u013c\u013d\7c\2\2\u013d\u013e\7u\2\2"+
		"\u013e\u013f\7q\2\2\u013f\60\3\2\2\2\u0140\u0141\7u\2\2\u0141\u0142\7"+
		"g\2\2\u0142\u0143\7l\2\2\u0143\u0144\7c\2\2\u0144\62\3\2\2\2\u0145\u0146"+
		"\7r\2\2\u0146\u0147\7c\2\2\u0147\u0148\7t\2\2\u0148\u0149\7c\2\2\u0149"+
		"\64\3\2\2\2\u014a\u014b\7h\2\2\u014b\u014c\7k\2\2\u014c\u014d\7o\2\2\u014d"+
		"\u014e\7a\2\2\u014e\u014f\7r\2\2\u014f\u0150\7c\2\2\u0150\u0151\7t\2\2"+
		"\u0151\u0152\7c\2\2\u0152\66\3\2\2\2\u0153\u0154\7c\2\2\u0154\u0155\7"+
		"v\2\2\u0155\u0156\7g\2\2\u01568\3\2\2\2\u0157\u0158\7h\2\2\u0158\u0159"+
		"\7c\2\2\u0159\u015a\7e\2\2\u015a\u015b\7c\2\2\u015b:\3\2\2\2\u015c\u015d"+
		"\7g\2\2\u015d\u015e\7p\2\2\u015e\u015f\7s\2\2\u015f\u0160\7w\2\2\u0160"+
		"\u0161\7c\2\2\u0161\u0162\7p\2\2\u0162\u0163\7v\2\2\u0163\u0164\7q\2\2"+
		"\u0164<\3\2\2\2\u0165\u0166\7h\2\2\u0166\u0167\7k\2\2\u0167\u0168\7o\2"+
		"\2\u0168\u0169\7a\2\2\u0169\u016a\7g\2\2\u016a\u016b\7p\2\2\u016b\u016c"+
		"\7s\2\2\u016c\u016d\7w\2\2\u016d\u016e\7c\2\2\u016e\u016f\7p\2\2\u016f"+
		"\u0170\7v\2\2\u0170\u0171\7q\2\2\u0171>\3\2\2\2\u0172\u0173\7t\2\2\u0173"+
		"\u0174\7g\2\2\u0174\u0175\7v\2\2\u0175\u0176\7q\2\2\u0176\u0177\7t\2\2"+
		"\u0177\u0178\7p\2\2\u0178\u0179\7g\2\2\u0179@\3\2\2\2\u017a\u017b\7v\2"+
		"\2\u017b\u017c\7k\2\2\u017c\u017d\7r\2\2\u017d\u017e\7q\2\2\u017eB\3\2"+
		"\2\2\u017f\u0180\7e\2\2\u0180\u0181\7q\2\2\u0181\u0182\7p\2\2\u0182\u0183"+
		"\7u\2\2\u0183\u0184\7v\2\2\u0184\u0185\7c\2\2\u0185\u0186\7p\2\2\u0186"+
		"\u0187\7v\2\2\u0187\u0188\7g\2\2\u0188D\3\2\2\2\u0189\u018a\7n\2\2\u018a"+
		"\u018b\7k\2\2\u018b\u018c\7v\2\2\u018c\u018d\7g\2\2\u018d\u018e\7t\2\2"+
		"\u018e\u018f\7c\2\2\u018f\u0190\7n\2\2\u0190F\3\2\2\2\u0191\u0192\7k\2"+
		"\2\u0192\u0193\7p\2\2\u0193\u0194\7v\2\2\u0194\u0195\7g\2\2\u0195\u0196"+
		"\7k\2\2\u0196\u0197\7t\2\2\u0197\u0198\7q\2\2\u0198H\3\2\2\2\u0199\u019a"+
		"\7t\2\2\u019a\u019b\7g\2\2\u019b\u019c\7c\2\2\u019c\u019d\7n\2\2\u019d"+
		"J\3\2\2\2\u019e\u019f\7n\2\2\u019f\u01a0\7q\2\2\u01a0\u01a1\7i\2\2\u01a1"+
		"\u01a2\7k\2\2\u01a2\u01a3\7e\2\2\u01a3\u01a4\7q\2\2\u01a4L\3\2\2\2\u01a5"+
		"\u01a6\7-\2\2\u01a6N\3\2\2\2\u01a7\u01a8\7/\2\2\u01a8P\3\2\2\2\u01a9\u01aa"+
		"\7,\2\2\u01aaR\3\2\2\2\u01ab\u01ac\7\61\2\2\u01acT\3\2\2\2\u01ad\u01ae"+
		"\7\'\2\2\u01aeV\3\2\2\2\u01af\u01b0\7?\2\2\u01b0X\3\2\2\2\u01b1\u01b2"+
		"\7>\2\2\u01b2\u01b3\7@\2\2\u01b3Z\3\2\2\2\u01b4\u01b5\7>\2\2\u01b5\u01b6"+
		"\7?\2\2\u01b6\\\3\2\2\2\u01b7\u01b8\7@\2\2\u01b8\u01b9\7?\2\2\u01b9^\3"+
		"\2\2\2\u01ba\u01bb\7>\2\2\u01bb`\3\2\2\2\u01bc\u01bd\7@\2\2\u01bdb\3\2"+
		"\2\2\u01be\u01bf\7\60\2\2\u01bfd\3\2\2\2\u01c0\u01c1\7<\2\2\u01c1f\3\2"+
		"\2\2\u01c2\u01c3\7.\2\2\u01c3h\3\2\2\2\u01c4\u01c5\7*\2\2\u01c5j\3\2\2"+
		"\2\u01c6\u01c7\7+\2\2\u01c7l\3\2\2\2\u01c8\u01c9\7]\2\2\u01c9n\3\2\2\2"+
		"\u01ca\u01cb\7_\2\2\u01cbp\3\2\2\2\u01cc\u01cd\7\60\2\2\u01cd\u01ce\7"+
		"\60\2\2\u01cer\3\2\2\2\u01cf\u01d0\7>\2\2\u01d0\u01d1\7/\2\2\u01d1t\3"+
		"\2\2\2\u01d2\u01d3\7`\2\2\u01d3v\3\2\2\2\u01d4\u01d5\7(\2\2\u01d5x\3\2"+
		"\2\2\u01d6\u01ea\t\2\2\2\u01d7\u01d9\t\3\2\2\u01d8\u01d7\3\2\2\2\u01d9"+
		"\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01eb\3\2"+
		"\2\2\u01dc\u01da\3\2\2\2\u01dd\u01df\t\3\2\2\u01de\u01dd\3\2\2\2\u01df"+
		"\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2"+
		"\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e7\7a\2\2\u01e4\u01e6\t\3\2\2\u01e5"+
		"\u01e4\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01da\3\2\2\2\u01ea"+
		"\u01e0\3\2\2\2\u01ebz\3\2\2\2\u01ec\u01ee\4\62;\2\u01ed\u01ec\3\2\2\2"+
		"\u01ee\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0|\3"+
		"\2\2\2\u01f1\u01f3\4\62;\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\7\60"+
		"\2\2\u01f7\u01f9\4\62;\2\u01f8\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb~\3\2\2\2\u01fc\u0200\7$\2\2\u01fd"+
		"\u01ff\n\4\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u0200\3\2\2\2\u0203"+
		"\u0204\7$\2\2\u0204\u0080\3\2\2\2\u0205\u0209\7$\2\2\u0206\u0208\n\4\2"+
		"\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u0082\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u0210\7}\2\2\u020d"+
		"\u020f\n\5\2\2\u020e\u020d\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u0210\3\2\2\2\u0213"+
		"\u0214\7\177\2\2\u0214\u0215\bB\2\2\u0215\u0084\3\2\2\2\u0216\u021a\7"+
		"}\2\2\u0217\u0219\n\5\2\2\u0218\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a"+
		"\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u0086\3\2\2\2\u021c\u021a\3\2"+
		"\2\2\u021d\u0223\t\6\2\2\u021e\u021f\5\177@\2\u021f\u0220\7\177\2\2\u0220"+
		"\u0223\3\2\2\2\u0221\u0223\7\177\2\2\u0222\u021d\3\2\2\2\u0222\u021e\3"+
		"\2\2\2\u0222\u0221\3\2\2\2\u0223\u0088\3\2\2\2\u0224\u0225\t\7\2\2\u0225"+
		"\u0226\bE\3\2\u0226\u008a\3\2\2\2\17\2\u01da\u01e0\u01e7\u01ea\u01ef\u01f4"+
		"\u01fa\u0200\u0209\u0210\u021a\u0222\4\3B\2\3E\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}