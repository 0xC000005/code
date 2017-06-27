package cn.dataidea.tinylang.env;

/**
 * <p>符号</p>
 * 
 * @author xiehui
 * @createTime 下午3:10:26
 * @version 1.0
 */
public class Symbol {
	String name; 	// 符号名称
	String cname;	// 代码生成时的代码名称
	Scope scope; 	// 符号对应一个作用域
	Type type; 		// 符号对应一种类型

	public Symbol(String name, Type type) {
		this(name);
		this.type = type;
	}

	public Symbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Scope getScope() {
		return scope;
	}

	public Type getType() {
		return type;
	}

	public String cname() {
		return cname;
	}

	public void set_cname(String name) {
		cname = name;
	}

	public String toString() {
		String s = "";
		if (scope != null) {
			s = scope.getScopeName() + ".";
		}
		if (type != null) {
			return '<' + s + getName() + ":" + type + '>';
		}
		return s + getName();
	}

	public static String stripBrackets(String s) {
		return s.substring(1, s.length() - 1);
	}
}
