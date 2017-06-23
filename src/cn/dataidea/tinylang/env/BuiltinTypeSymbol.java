package cn.dataidea.tinylang.env;

/**
 * <p>内置符号</p>
 * 
 * @author xiehui
 * @createTime 下午4:19:04
 * @version 1.0
 */
public class BuiltinTypeSymbol extends Symbol implements Type {
	int typeIndex;
	static int nextTypeIndex = 1;

	public BuiltinTypeSymbol(String name) {
		super(name);
		this.typeIndex = nextTypeIndex++;
	}

	public boolean canAssignTo(Type destType) {
		return (this == destType);
	}

	public int getTypeIndex() {
		return typeIndex;
	}

	public String toString() {
		return getName();
	}
}
