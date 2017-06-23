package cn.dataidea.tinylang.env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>通用方法</p>
 * 
 * @author xiehui
 * @createTime 下午3:38:52
 * @version 1.0
 */
public class GenericFunction extends ScopedSymbol {
	int nargs;
	Map<String, MethodSymbol> methods = new LinkedHashMap<String, MethodSymbol>();
	boolean called = false;

	public GenericFunction(String name, Scope parent, int nargs) {
		super(name, parent);
		this.nargs = nargs;
	}

	public List<MethodSymbol> getMethods() {
		List<MethodSymbol> list = new ArrayList<MethodSymbol>(methods.values());
		return list;
	}

	public boolean addMethod(MethodSymbol method) {
		String fname = method.getName();
		if (methods.get(fname) != null) {
			System.err.println("[addMethod] duplicated method detected: " + fname);
			return false;
		}
		if (nargs != method.nargs()) {
			System.err.println("[addMethod] incompatible method (nargs is different): " + fname);
			return false;
		}
		methods.put(fname, method);
		method.setGenericFunction(this);
		return true;
	}

	
	public List<MethodSymbol> findMethods(List<Type> argTypes) {
		Iterator<Entry<String, MethodSymbol>> iter = methods.entrySet().iterator();
		List<MethodSymbol> list = new ArrayList<MethodSymbol>();
		while (iter.hasNext()) {
			MethodSymbol method = iter.next().getValue();
			if (argTypes == null || method.isApplicable(argTypes)) {
				list.add(method);
			}
		}
		Collections.sort(list, new MoreSpecificMethod());
		return list;
	}

	public MethodSymbol findMethod(List<Type> argTypes) {
		List<MethodSymbol> methods = findMethods(argTypes);
		if (methods.size() != 0)
			return findMethods(argTypes).get(0);
		else
			return null;
	}

	public static class MoreSpecificMethod implements Comparator<MethodSymbol> {
		public int compare(MethodSymbol o1, MethodSymbol o2) {
			List<Type> types1 = o1.getTypes();
			List<Type> types2 = o2.getTypes();
			Iterator<Type> iter1 = types1.iterator();
			Iterator<Type> iter2 = types2.iterator();
			while (iter1.hasNext()) {
				Type type1 = iter1.next();
				Type type2 = iter2.next();
				if (type1 == type2)
					; 
				else if (type1.canAssignTo(type2))
					return -1; 
				else
					return 1;
			}
			return 0;
		}
	}

	public boolean canAssignTo(Type destType) {
		if (destType instanceof MethodSymbol)
			return (this.name == ((MethodSymbol) destType).name);
		else
			return (this == destType);
	}
	
	public Map<String, Symbol> getMembers() {
		return null;
	}

	public String getName() {
		return name;
	}

	public int nargs() {
		return nargs;
	}

	public boolean called() {
		return called;
	}

	public void setCalled(boolean p) {
		called = p;
	}
}
