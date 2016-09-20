package cn.codeidea.tinylang.lex;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 定义 Token 类型
 */

public enum TokenType {
	/*运算符与分隔符*/
	PLUS, 				// + 
	MINUS, 			// -
	STAR,				// *
	DIVIDE,			// /
	MOD,				// %
	EQ,					// ==
	NEQ,				// !=
	LT,					// <
	LEQ,					// <=
	GT,					// >
	GEQ,				// >=
	ASSIGN,			// =
	POINTSTO,		// ->
	DOT,				// .
	AND,				// &
	OPENPA,			// (
	CLOSEPA,		// )
	OPENBR,			// [
	CLOSEBR,		// ]
	BEGIN,			// {
	END,				// }
	SEMICOLON,	// ;
	COMMA,			// ,
	ELLIPSIS,			// ...
	EOF,					// 文件结束符
	
	/*常量*/
	CINT,				 	// constant int
	CCHAR,				// constant char
	CSTR,					// constant string
	
	/*关键字*/
	CHAR,					// char
	SHORT,				// short
	INT,						// int
	VOID,					// void
	STRUCT,				// struct
	IF,						// if
	ELSE,					// else
	FOR,					// for
	CONTINUE,		// continue
	BREAK,				// break
	RETURN,				// return
	SIZEOF,				// sizeof
	
	ALIGN,					// __align
	CDECL,					// __cdecl
	STDCALL,				// __stdcall
	
	/*标识符*/
	IDENT
}
