package cn.dataidea.tinylang.env;


/**
*<p> 作用域 </p>
*@author xiehui
*@createTime 下午3:09:10
*@version 1.0
*/
public interface Scope {
    public String getScopeName(); 		 	//名称
    public Scope getEnclosingScope();		//外部作用域
    public void define(Symbol sym); 			//在作用域中定义符号
    public Symbol resolve(String name); 	//根据名称查找
    public void setID(int n);
    public int getID();
}
