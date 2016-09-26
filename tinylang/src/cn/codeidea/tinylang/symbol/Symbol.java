package cn.codeidea.tinylang.symbol;

/**
 * TinyLang 1.0
 * Copyright(c) 2016, CodeIdea.cn.
 * @Author 0xC000005
 * @Date 2016-09-20
 * 说明: 符号表
 */

public class Symbol {
	public String value; //单词名称
	public int r; //寄存器
	public int c; //关联值
	public Type type; //数据类型
	public Symbol nextSymbol; //关联的其他符号
	public Symbol preSymbol; //指向前一定义的同名符号
	
}
