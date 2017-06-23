package cn.dataidea.tinylang.env;
/**
*<p> 局部作用域 </p>
*@author xiehui
*@createTime 下午3:23:50
*@version 1.0
*/
public class LocalScope extends BaseScope{

	public LocalScope(Scope parent) {
		super(parent);
	}

	@Override
	public String getScopeName() {
		return "local";
	}

}
