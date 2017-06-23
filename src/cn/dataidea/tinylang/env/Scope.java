package cn.dataidea.tinylang.env;


/**
*<p> 作用域 </p>
*@author xiehui
*@createTime 下午3:09:10
*@version 1.0
*/
public interface Scope {
    public String getScopeName();
    public Scope getEnclosingScope();
    public void define(Symbol sym);
    public Symbol resolve(String name);
    public void setNextID(int n);
    public int getNextID();
}
