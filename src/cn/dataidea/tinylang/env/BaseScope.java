package cn.dataidea.tinylang.env;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> 作用域 </p>
 * 
 * @author xiehui
 * @createTime 下午3:16:39
 * @version 1.0
 */
public abstract class BaseScope implements Scope {
	Scope enclosingScope;  // 外围作用域
	Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>(); // 符号表
	int next_id = 0;  // ID

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
			var.id = next_id++; 
		}
	}

	public String toString() {
		return symbols.keySet().toString();
	}

	public Scope getEnclosingScope() {
		return enclosingScope;
	}

	public void setNextID(int n) {
		next_id = n;
	}

	public int getNextID() {
		return next_id;
	}
}
