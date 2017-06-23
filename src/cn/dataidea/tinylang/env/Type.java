package cn.dataidea.tinylang.env;

/**
*<p> 类型 </p>
*@author xiehui
*@createTime 下午3:08:18
*@version 1.0
*/
public interface Type {
    public String getName();
    public int getTypeIndex();
    public boolean canAssignTo(Type destType);
}
