package cn.codeidea.tinylang.symbol;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 类型编码
 */

public class TypeCode {
	public static int T_INT = 0; 					//整型
	public static int 	T_CHAR = 1;				// 字符型                 
	public static int 	T_SHORT = 2;				// 短整型                       
	public static int 	T_VOID = 3;					// 空类型                     
	public static int 	T_PTR  =  4;					// 指针                          
	public static int 	T_FUNC = 5;				// 函数                    
	public static int 	T_STRUCT =  6;			// 结构体 
	public static int 	T_BTYPE  = 0x000f;		// 基本类型掩码          
	public static int 	T_ARRAY  = 0x0010;	// 数组
}
