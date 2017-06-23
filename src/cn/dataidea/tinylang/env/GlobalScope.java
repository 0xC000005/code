package cn.dataidea.tinylang.env;


/**
*<p> 全局范围 </p>
*@author xiehui
*@createTime 下午3:25:51
*@version 1.0
*/
public class GlobalScope extends BaseScope {
    public GlobalScope() { super(null); }
    public String getScopeName() { return "global"; }
}
