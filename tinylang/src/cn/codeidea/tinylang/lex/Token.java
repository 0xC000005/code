package cn.codeidea.tinylang.lex;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 定义 Token
 */

public class Token {
	
	public final String value;
	public final TokenType type;
	public final int line;
	
	public Token(String value, TokenType type, int line){
		this.value = value;
		this.type = type;
		this.line = line;
	}
	
	public String toString(){
		return "{ value : "+value+" type : "+type+" line :"+line+" }";
	}
}
