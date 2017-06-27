package cn.dataidea.tinylang.env;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> 作用域 </p>
 * <p> 每一个作用域都存在一个符号表, 用来管理此作用域下的所有符号. </p>
 * 
 * @author xiehui
 * @createTime 下午3:16:39
 * @version 1.0
 */
public abstract class BaseScope implements Scope {
	Scope enclosingScope;  // 外围作用域
	Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>(); // 符号表
	int id = 0;  // ID

	public BaseScope(Scope parent) {
		enclosingScope = parent;
	}
   
	/**
	 * 递归通过符号名称从作用域符号表中查找符号
	 * @param name 符号名称
	 */
	public Symbol resolve(String name) {
		Symbol s = symbols.get(name);
		if (s != null)
			return s;
		if (enclosingScope != null)
			return enclosingScope.resolve(name);
		return null;
	}
    
	/**
	 * 定义符号
	 * @param sym 符号
	 */
	public void define(Symbol sym) {
		symbols.put(sym.name, sym);
		sym.scope = this;
		if (sym instanceof VariableSymbol) {
			VariableSymbol var = (VariableSymbol) sym;
			var.id = id++; 
		}
	}

	/**
	 * 输出此作用域范围所有符号的名称
	 */
	public String toString() {
		return symbols.keySet().toString();
	}

	public Scope getEnclosingScope() {
		return enclosingScope;
	}

	public void setID(int n) {
		id = n;
	}

	public int getID() {
		return id;
	}
}
