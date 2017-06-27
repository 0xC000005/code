package cn.dataidea.tinylang.env;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p> 类 </p>
 * 
 * @author xiehui
 * @createTime 下午4:20:48
 * @version 1.0
 */
public class ClassSymbol extends ScopedSymbol implements Type {
	static public final String top = "standard_object";
	private int typeIndex;
	static int nextTypeIndex = 100;
	MethodSymbol initFunction, newFunction;
	List<ClassSymbol> local_precedence_list;

	ClassSymbol superClass;

	public Map<String, Symbol> members = new LinkedHashMap<String, Symbol>();

	public ClassSymbol(String name, Scope enclosingScope, ClassSymbol superClass) {
		super(name, enclosingScope);
		this.superClass = superClass;
		this.typeIndex = nextTypeIndex++;

		List<ClassSymbol> list = new LinkedList<ClassSymbol>();
		ClassSymbol t = this;
		while (t != null) {
			list.add(t);
			t = t.superClass;
		}
		local_precedence_list = list;
	}

	public Scope getParentScope() {
		if (superClass == null)
			return enclosingScope;
		return superClass;
	}

	public Symbol resolveMember(String name) {
		Symbol s = members.get(name);
		if (s != null)
			return s;
		if (superClass != null) {
			return superClass.resolveMember(name);
		}
		return null;
	}

	public List<ClassSymbol> getLocalPrecedenceList() {
		return local_precedence_list;
	}

	public boolean isInstanceof(ClassSymbol ancestor) {
		ClassSymbol t = this;
		while (t != null) {
			if (t == ancestor)
				return true;
			t = t.superClass;
		}
		return false;
	}

	public String toString() {
		return "class " + name + "(" + superClass.name + "):{" + stripBrackets(members.keySet().toString()) + "}";
	}

	public boolean canAssignTo(Type destType) {
		if (destType == null)
			return true;
		else if (destType instanceof ClassSymbol)
			return isInstanceof((ClassSymbol) destType);
		else
			return (this == destType);
	}

	public int getTypeIndex() {
		return typeIndex;
	}

	public Map<String, Symbol> getMembers() {
		return members;
	}

	public void setInitFunction(MethodSymbol fun) {
		initFunction = fun;
	}

	public MethodSymbol initFunction() {
		return initFunction;
	}

	public void setNewFunction(MethodSymbol fun) {
		newFunction = fun;
	}

	public MethodSymbol newFunction() {
		return newFunction;
	}
}
