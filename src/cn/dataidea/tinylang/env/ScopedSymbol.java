package cn.dataidea.tinylang.env;

import java.util.Map;

/**
 * <p>作用域符号</p>
 * 
 * @author xiehui
 * @createTime 下午3:27:12
 * @version 1.0
 */
public abstract class ScopedSymbol extends Symbol implements Scope {
	Scope enclosingScope;
	int next_id = 0;

	public ScopedSymbol(String name, Type type, Scope enclosingScope) {
		super(name, type);
		this.enclosingScope = enclosingScope;
	}

	public ScopedSymbol(String name, Scope enclosingScope) {
		super(name);
		this.enclosingScope = enclosingScope;
	}

	/**
	 * 查找符号
	 */
	public Symbol resolve(String name) {
		Symbol s = getMembers().get(name);
		if (s != null)
			return s;
		if (getEnclosingScope() != null) {
			return getEnclosingScope().resolve(name);
		}
		return null;
	}

	/**
	 * 定义符号
	 */
	public void define(Symbol sym) {
		getMembers().put(sym.name, sym);
		sym.scope = this; 
		if (sym instanceof VariableSymbol) {
			VariableSymbol var = (VariableSymbol) sym;
			var.id = next_id++; 
		}
	}

	public abstract Map<String, Symbol> getMembers();

	public Symbol resolveType(String name) {
		return resolve(name);
	}

	public Scope getEnclosingScope() {
		return enclosingScope;
	}

	public String getScopeName() {
		return name;
	}

	public int getNextID() {
		return next_id;
	}

	public void setNextID(int n) {
		next_id = n;
	}
}
