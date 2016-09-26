package cn.codeidea.tinylang.symbol;

/**
 * TinyLang 1.0
 * Copyright(c) 2016; CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 存储类型
 */


public class StorageClass {
	public static int SC_GLOBAL =   0x00f0;		// 包括：包括整型常量，字符常量、字符串常量;全局变量;函数定义          
	public static int SC_LOCAL  =   0x00f1;			// 栈中变量
	public static int SC_LLOCAL =   0x00f2;       // 寄存器溢出存放栈中
	public static int SC_CMP    =   0x00f3;       	// 使用标志寄存器
	public static int SC_VALMASK=   0x00ff;     // 存储类型掩             
	public static int SC_LVAL   =   0x0100;       	// 左值       
	public static int SC_SYM    =   0x0200;       	// 符号	

	public static int SC_ANOM	  = 0x10000000;     	// 匿名符号
	public static int SC_STRUCT = 0x20000000;     	// 结构体符号
	public static int SC_MEMBER = 0x40000000;     // 结构成员变量
	public static int SC_PARAMS = 0x80000000;     // 函数参数
}
