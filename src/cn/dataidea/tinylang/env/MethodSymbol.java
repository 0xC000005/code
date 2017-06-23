package cn.dataidea.tinylang.env;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>方法符号</p>
 * 
 * @author xiehui
 * @createTime 下午3:37:25
 * @version 1.0
 */
public class MethodSymbol extends ScopedSymbol {

	Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();
	List<Type> orderedArgTypes = null;
	GenericFunction gf;
	int nlocals = 0;

	public MethodSymbol(String name, Type retType, Scope parent) {
		super(name, retType, parent);
	}

	public String getName() {
		Iterator<Entry<String, Symbol>> iter = orderedArgs.entrySet().iterator();
		String acc = name + "(";
		boolean first = true;
		while (iter.hasNext()) {
			Entry<String, Symbol> entry = iter.next();
			Symbol sym = entry.getValue();
			Type typ = sym.getType();
			if (!first)
				acc += ",";
			else
				first = false;
			acc += typ.getName();
		}
		return acc + ")";
	}

	public List<Type> getTypes() {
		if (orderedArgTypes == null) {
			Iterator<Entry<String, Symbol>> iter = orderedArgs.entrySet().iterator();
			List<Type> argTypes = new LinkedList<Type>();
			while (iter.hasNext()) {
				Entry<String, Symbol> entry = iter.next();
				Symbol sym = entry.getValue();
				Type typ = sym.getType();
				argTypes.add(typ);
			}
			orderedArgTypes = argTypes;
			return argTypes;
		} else
			return orderedArgTypes;
	}

	public boolean canAssignTo(Type destType) {
		if (destType instanceof GenericFunction) {
			GenericFunction gf = (GenericFunction) destType;
			return (this.name == gf.name && this.nargs() == gf.nargs());
		} else
			return (this == destType);
	}

	public boolean isApplicable(List<Type> destTypes) {
		Iterator<Type> srcIter = getTypes().iterator();
		Iterator<Type> dstIter = destTypes.iterator();
		if (destTypes.size() != nargs())
			return false;
		while (srcIter.hasNext()) {
			Type srcType = srcIter.next();
			Type dstType = dstIter.next();
			if (dstType != null && !dstType.canAssignTo(srcType)) {
				return false;
			}
		}
		return true;
	}

	public boolean agreeWith(MethodSymbol that) {
		if (this.nargs() != that.nargs())
			return false;
		Iterator<Type> srcIter = this.getTypes().iterator();
		Iterator<Type> dstIter = that.getTypes().iterator();
		while (srcIter.hasNext()) {
			Type thisType = srcIter.next();
			Type thatType = dstIter.next();
			if (thisType != thatType)
				return false;
		}
		return true;
	}

	public Map<String, Symbol> getMembers() {
		return orderedArgs;
	}

	public int nargs() {
		return orderedArgs.size();
	}

	public void setLocals(int n) {
		nlocals = n;
	}

	public int nlocals() {
		return nlocals;
	}

	public void setGenericFunction(GenericFunction gf) {
		this.gf = gf;
	}

	public GenericFunction genericFunction() {
		return gf;
	}
}
