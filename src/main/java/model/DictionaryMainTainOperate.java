package model;

import view.Windows;

/**
 * 描述 树形字典维护操作接口
 * 时间 2018/10/18$
 * 作者 szd
 */
public interface DictionaryMainTainOperate {


    /**
     *@描述 进行树形目录的维护 通过对数据库中的字典表进行更新
     *@参数
     *@返回值
     *@创建人 szd
     *@创建时间 2018/10/15
     *@修改人和其它信息

     */
    public void updateTreeNode(String id,String tt);

    /**
     *@描述 进行树形目录维护 再字典跟新结束之后对树状结构进行更新
     *@参数
     *@返回值
     *@创建人 szd
     *@创建时间 2018/10/15
     *@修改人和其它信息

     */
    public void updateTreeStructure(Windows w,String name);


}
