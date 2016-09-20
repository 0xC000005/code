package cn.codeidea.tinylang.lex;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 语法分析
 */

public class Lexer {
	private static Map<String,TokenType> keywords = new HashMap<>();
	private char[] codebuffer;
	private int index;
	private char ch;
	private boolean endfile;
	private int line = 1;
	
	static{
		keywords.put("char",TokenType.CHAR);
		keywords.put("short",TokenType.SHORT);
		keywords.put("int",TokenType.INT);
		keywords.put("void",TokenType.VOID);
		keywords.put("struct",TokenType.STRUCT);
		keywords.put("if",TokenType.IF);
		keywords.put("else",TokenType.ELSE);
		keywords.put("for",TokenType.FOR);
		keywords.put("continue",TokenType.CONTINUE);
		keywords.put("return",TokenType.RETURN);
		keywords.put("sizeof",TokenType.SIZEOF);
		keywords.put("__align",TokenType.ALIGN);
		keywords.put("__cdecl",TokenType.CDECL);
		keywords.put("__stdcall",TokenType.STDCALL);
	}
	public Lexer(char[] codebuffer){
		this.codebuffer = codebuffer;
	}
	
	/**
	 * 获取token
	 * @return
	 */
	public Token getToken(){
		Token token = null;
		preprocess();
		if(endfile){
			return new Token(" ", TokenType.EOF,line);
		}
		if(Character.isLetter(ch)){
			token = parseIdentifier();
		}else if(Character.isDigit(ch)){
			token = parseNumber();
		}else if(ch == '+'){
			token = new Token("+",TokenType.PLUS, line);
			getch();
		}else if(ch == '-'){
			getch();
			if(ch == '>'){
				token = new Token("->",TokenType.POINTSTO,line);
				getch();
			}else{
				token = new Token("-",TokenType.MINUS,line);
			}
		}else if(ch == '/'){
			token = new Token("/",TokenType.DIVIDE,line);
			getch();
		}else if(ch == '%'){
			token = new Token("%",TokenType.MOD,line);
		}else if(ch == '='){
			getch();
			if(ch == '='){
				token = new Token("==",TokenType.EQ,line);
				getch();
			}else{
				token = new Token("=",TokenType.ASSIGN,line);
			}
		}else if(ch == '!'){
			getch();
			if(ch == '='){
				token = new Token("!=", TokenType.NEQ,line);
				getch();
			}else{
				System.err.println("暂不支持！操作符 , 错误行 : "+line);
				System.exit(-1);
			}
		}else if(ch == '<'){
			getch();
			if(ch == '='){
				token = new Token("<=", TokenType.LEQ,line);
				getch();
			}else{
				token = new Token("<",TokenType.LT,line);
			}
		}else if(ch == '>'){
			getch();
			if(ch == '='){
				token = new Token(">=", TokenType.GEQ, line);
				getch();
			}else{
				token = new Token(">", TokenType.GT, line);
			}
		}else if(ch == '.'){
			getch();
			if(ch == '.'){
				getch();
				if(ch != '.'){
					System.err.println("省略号拼写错误, 错误行 : "+line);
					System.exit(-1);
				}else{
					token = new Token("...",TokenType.ELLIPSIS, line);
					getch();
				}
			}else{
				token = new Token(".",TokenType.DOT, line);
			}
		}else if(ch == '&'){
			token = new Token("&", TokenType.AND, line);
			getch();
		}else if(ch == ';'){
			token = new Token(";", TokenType.SEMICOLON, line);
			getch();
		}else if(ch == '('){
			token = new Token("(", TokenType.OPENPA, line);
			getch();
		}else if(ch == ')'){
			token = new Token(")", TokenType.CLOSEPA, line);
			getch();
		}else if(ch == '['){
			token = new Token("[", TokenType.OPENBR, line);
			getch();
		}else if(ch == ']'){
			token = new Token("]", TokenType.CLOSEBR, line);
			getch();
		}else if(ch == '{'){
			token = new Token("{", TokenType.BEGIN, line);
			getch();
		}else if(ch == '}'){
			token = new Token("}", TokenType.END, line);
			getch();
		}else if(ch == ','){
			token = new Token(",", TokenType.COMMA,line);
			getch();
		}else if(ch == '*'){
			token = new Token("*", TokenType.STAR, line);
			getch();
		}else if(ch =='\''){
			token = parseString(ch);
		}else if(ch =='\"'){
			token = parseString(ch);
		}else{
			System.err.println("无法识别的字符, 错误行 : "+line);
			System.exit(-1);
		}
		return token;
	}
	
	/**
	 * 预处理，去掉空格和注释。
	 */
	public void preprocess(){
		while(!endfile){
			if(Character.isWhitespace(ch)){
				skipWhitespace();
			}else if(ch == '/'){
				getch();
				if(ch == '*'){
					parseComment();
				}else{
					ungetch();
					break;
				}
			}else{
				break;
			}
				
		}
	}
	
	/**
	 * 获取下一个字符
	 */
	public void getch(){
		ch =  codebuffer[index++];
		if(index == codebuffer.length){
			endfile = true;
		}
	}
	
    /**
     * 退回上一个字符
     */
	public void ungetch(){
		ch = codebuffer[--index];
	}
	
	/**
	 * 跳过空白字符
	 */
	public void skipWhitespace(){
		while(Character.isWhitespace(ch)){
			if( ch == '\r'){
				getch();
				if(ch != '\n'){
					return;
				}else{
					line++;
				}
			}
			getch();
		}
	}
	
	/**
	 * 处理注释
	 */
	public void parseComment(){
		getch();
		do{
			do{
				if(ch == '\n' || ch == '*'){
					break;
				}else{
					getch();
				}
			}while(!endfile);
			if(ch == '\n'){
				line++;
				getch();
			}else if(ch == '*'){
				getch();
				if(ch == '/'){
					getch();
					return;
				}
			}else{
				System.err.println("解析代码注释失败！错误行 : "+line);
				System.exit(-1);
			}
		}while(!endfile);
	}
	
	/**
	 * 处理标识符
	 * @return token
	 */
	public Token parseIdentifier(){
		int start = index-1;
		getch();
		while(Character.isLetterOrDigit(ch)){
			getch();
		}
		String str = new String(codebuffer,start,index-start-1);
		TokenType type =  keywords.get(str);
		if(type == null){
			type = TokenType.IDENT;
		}
		return new Token(str, type, line);
	}
	
	/**
	 * 处理数字
	 * @return token
	 */
	public Token parseNumber(){
		int start = index-1;
		do{
			getch();
		}while(Character.isDigit(ch));
		if(ch == '.'){
			do{
				getch();
			}while(Character.isDigit(ch));
		}
		return new Token(new String(codebuffer,start,index-start-1), TokenType.CINT, line);
	}
	
	/**
	 * 处理字符串
	 * @param seq
	 * @return token
	 */
	public Token parseString(char seq){
		int start = index-1;
		getch();
		while(!endfile){
			if(ch == seq){
				break;
			}
			getch();
		}
		Token token = new Token(new String(codebuffer, start, index-start-1),TokenType.CSTR, line);
		getch();
		return token;
	}
	
	/**
	 * 获取行号
	 * @return 行号
	 */
	public int getLine(){
		return line;
	}
}
