package cn.dataidea.tinylang.env;

/**
 * <p> 变量符号 </p>
 * 
 * @author xiehui
 * @createTime 下午3:13:57
 * @version 1.0
 */
public class VariableSymbol extends Symbol {
	int id; 					// ID
	boolean polyp; 	// 多态类型
	boolean initp; 	// 初始化

	public VariableSymbol(String name, Type type) {
		super(name, type);
	}

	public int getID() {
		return id;
	}

	public void setPoly(boolean b) {
		polyp = b;
	}

	public boolean polyp() {
		return polyp;
	}

	public void setInit(boolean b) {
		initp = b;
	}

	public boolean initp() {
		return initp;
	}
}
