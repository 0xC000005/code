package cn.codeidea.tinylang.syntax;

import cn.codeidea.tinylang.lex.Lexer;
import cn.codeidea.tinylang.lex.Token;
import cn.codeidea.tinylang.lex.TokenType;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 语法分析
 */

public class Syntax {
	private Lexer lexer;
	private Token token;
	
	public Syntax(Lexer lexer){
		this.lexer = lexer;
	}
	public void translationUnit(){
		token = lexer.getToken();
		while(token.type != TokenType.EOF){
			externalDeclaration("global");
		}
	}
	
	public void externalDeclaration(String scope){
		if(!typeSpec()){
			error("期望正确的类型定义 ！");
		}
		if(token.type == TokenType.SEMICOLON){
			token = lexer.getToken();
			return;
		}
		while(true){
			declarator();
			if(token.type == TokenType.BEGIN){
				if("local".equals(scope)){
					error("不支持函数嵌套定义");
				}else{
					funcbody();
				}
				break;
			}else{
				if(token.type == TokenType.ASSIGN){
					token = lexer.getToken();
					initializer();
				}
				if(token.type == TokenType.COMMA){
					token = lexer.getToken();
				}else{
					skip(TokenType.SEMICOLON);
					break;
				}
			}
		}
	}
	

	public boolean typeSpec(){
		boolean hasType = false;
		if(token.type == TokenType.CHAR){
			hasType = true;
			token = lexer.getToken();
		}else if(token.type == TokenType.SHORT){
			hasType = true;
			token = lexer.getToken();
		}else if(token.type == TokenType.VOID){
			hasType = true;
			token = lexer.getToken();
		}else if(token.type == TokenType.INT){
			hasType = true;
			token = lexer.getToken();
		}else if(token.type == TokenType.STRUCT){
			hasType = true;
			structSpec();
		}else{
			
		}
		return hasType;
	}
	
	public boolean isTypeSpec(){
		if(token.type == TokenType.CHAR || token.type == TokenType.SHORT || 
				token.type == TokenType.INT || token.type == TokenType.INT ||
				token.type == TokenType.VOID || token.type == TokenType.STRUCT){
			return true;
		}else{
			return false;
		}
	}
	
	public void structSpec(){
		token = lexer.getToken();
		if(lexer.isKeyword(token.value)){
			error("不能使用关键字作为结构体名称");
		}
		token = lexer.getToken();
		if(token.type == TokenType.BEGIN){
			structDeclarationList();
		}
	   
	}
	
	public void structDeclarationList(){
		token = lexer.getToken();
		while(token.type != TokenType.END){
			structDeclaration();
		}
		skip(TokenType.END);
	}
	
	public void structDeclaration(){
		typeSpec();
		while(true){
			declarator();
			if(token.type == TokenType.SEMICOLON || token.type == TokenType.EOF){
				break;
			}
			skip(TokenType.COMMA);
		}
		skip(TokenType.SEMICOLON);
	}
	
	public void declarator(){
		while(token.type == TokenType.STAR){
			token = lexer.getToken();
		}
		functionConvention();
		structAlignment();
		directDeclarator();
	}
	
	
	public void functionConvention(){
		if(token.type == TokenType.CDECL || token.type == TokenType.STDCALL){
			token = lexer.getToken();
		}
	}
	
	public void structAlignment(){
		if(token.type == TokenType.ALIGN){
			token = lexer.getToken();
			skip(TokenType.OPENPA);
			if(token.type == TokenType.CINT){
				token = lexer.getToken();
			}else{
				error("期望正确的整数常量 ！");
			}
			skip(TokenType.CLOSEPA);
		}
	}
	
	public void directDeclarator(){
		if(token.type == TokenType.IDENT){
			token = lexer.getToken();
		}else{
			error("期望正确的标识符 !");
		}
		directDeclaratorPostfix();
	}
	
	public void directDeclaratorPostfix(){
		if(token.type == TokenType.OPENPA){
			parameterTypeList();
		}else if(token.type == TokenType.OPENBR){
			token = lexer.getToken();
			if(token.type == TokenType.CINT){
				token = lexer.getToken();
			}
			skip(TokenType.CLOSEBR);
			directDeclaratorPostfix();
		}
	}
	
	public void parameterTypeList(){
		token = lexer.getToken();
		while(token.type != TokenType.CLOSEPA){
			if(!typeSpec()){
				error("期望类型标识符！");
			}
			declarator();
			if(token.type == TokenType.CLOSEPA){
				break;
			}
			skip(TokenType.COMMA);
			if(token.type == TokenType.ELLIPSIS){
				token = lexer.getToken();
				break;
			}
		}
		skip(TokenType.CLOSEPA);
	}
	
	public void funcbody(){
		compoundStmt();
	}
	
	public void  statement(){
		if(token.type == TokenType.BEGIN){
			compoundStmt();
		}else if(token.type == TokenType.IF){
			ifStmt();
		}else if(token.type == TokenType.RETURN){
			returnStmt();
		}else if(token.type == TokenType.BREAK){
			breakStmt();
		}else if(token.type == TokenType.CONTINUE){
			continueStmt();
		}else if(token.type == TokenType.FOR){
			forStmt();
		}else{
			expressionStmt();
		}
	}
	
	public void ifStmt(){
		token = lexer.getToken();
		skip(TokenType.OPENPA);
		expression();
		skip(TokenType.CLOSEPA);
		statement();
		if( token.type == TokenType.ELSE){
			token = lexer.getToken();
			statement();
		}
	}
	
	public void forStmt(){
		token = lexer.getToken();
		skip(TokenType.OPENPA);
		if(token.type != TokenType.SEMICOLON){
			expression();
		}
		skip(TokenType.SEMICOLON);
		if(token.type != TokenType.SEMICOLON){
			expression();
		}
		skip(TokenType.SEMICOLON);
		if(token.type != TokenType.CLOSEPA){
			expression();
		}
		skip(TokenType.CLOSEPA);
		statement();
	}
	
	public void continueStmt(){
		token = lexer.getToken();
		skip(TokenType.SEMICOLON);
	}
	
	public void breakStmt(){
		token = lexer.getToken();
		skip(TokenType.SEMICOLON);
	}
	
	public void returnStmt(){
		token = lexer.getToken();
		syntaxIndent();
		if(token.type != TokenType.SEMICOLON){
			expression();
		}
		skip(TokenType.SEMICOLON);
	}
	
	public void expressionStmt(){
		if(token.type != TokenType.SEMICOLON){
			expression();
		}
		skip(TokenType.SEMICOLON);
	}
	
	
	public void compoundStmt(){
		token = lexer.getToken();
		while(isTypeSpec()){
			externalDeclaration("local");
		}
		while(token.type != TokenType.END){
			statement();
		}
		token = lexer.getToken();
	}
	

	public void initializer(){
		assignExp();
	}
	
	public void assignExp(){
		equalExp();
		if(token.type == TokenType.ASSIGN){
			token = lexer.getToken();
			assignExp();
		}
	}
	
	public void equalExp(){
		relationExp();
		while( token.type == TokenType.EQ || token.type == TokenType.NEQ){
			token =lexer.getToken();
			relationExp();
		}
	}
	
	public void relationExp(){
		addExp();
		while( token.type == TokenType.LT || token.type == TokenType.LEQ ||
				token.type == TokenType.GT || token.type == TokenType.GEQ){
			token = lexer.getToken();
			addExp();
		}
	}
	
	public void addExp(){
		multiExp();
		while( token.type == TokenType.PLUS || token.type == TokenType.MINUS){
			token = lexer.getToken();
			multiExp();
		}
	}
	
	public void multiExp(){
		unaryExp();
		while(token.type == TokenType.STAR || token.type == TokenType.DIVIDE || token.type == TokenType.MOD){
			token = lexer.getToken();
			unaryExp();
		}
	}
	
	public void unaryExp(){
		if(token.type == TokenType.AND){
			token = lexer.getToken();
			unaryExp();
		}else if(token.type == TokenType.STAR){
			token = lexer.getToken();
			unaryExp();
		}else if(token.type == TokenType.PLUS){
			token = lexer.getToken();
			unaryExp();
		}else if(token.type == TokenType.MINUS){
			token = lexer.getToken();
			unaryExp();
		}else if(token.type == TokenType.SIZEOF){
			sizeofExp();
		}else{
			postfixExp();
		}
	}
	
	public void sizeofExp(){
		token = lexer.getToken();
		skip(TokenType.OPENPA);
		typeSpec();
		skip(TokenType.CLOSEPA);
	}
	
	
	public void postfixExp(){
		primaryExp();
		while(true){
			if(token.type == TokenType.DOT || token.type == TokenType.POINTSTO){
				token = lexer.getToken();
				token = lexer.getToken();
			}else if(token.type == TokenType.OPENBR){
				token = lexer.getToken();
				expression();
				skip(TokenType.CLOSEBR);
			}else if(token.type == TokenType.OPENPA){
				argExpList();
			}else{
				break;
			}
		}
	}
	
	public void primaryExp(){
		if(token.type == TokenType.CINT || token.type == TokenType.CCHAR){
			token = lexer.getToken();
		}else if(token.type == TokenType.CSTR){
			token = lexer.getToken();
		}else if(token.type == TokenType.OPENPA){
			token = lexer.getToken();
			expression();
			skip(TokenType.CLOSEPA);;
		}else{
			if(token.type != TokenType.IDENT){
				error("需要标识符或者常量");
			}
			token = lexer.getToken();
		}
	}
	
	public void argExpList(){
		token = lexer.getToken();
		if(token.type != TokenType.CLOSEPA){
			while(true){
				assignExp();
				if( token.type == TokenType.CLOSEPA){
					break;
				}
				skip(TokenType.COMMA);
			}
		}
		skip(TokenType.CLOSEPA);
	}
	
	public void expression(){
		while(true){
			assignExp();
			if(token.type != TokenType.COMMA){
				break;
			}
			token =lexer.getToken();
		}
	}
	public void skip(TokenType tokenType){
		if(token.type != tokenType){
			error(tokenType);
		}else{
			token = lexer.getToken();
		}
	}
	
	public void syntaxIndent(){
		
	}
	public void error(Object msg){
		System.err.println("语法解析错误,  "+msg+"  line : "+lexer.getLine());
		System.exit(-1);
	}
}
