package model;

import view.Windows;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/9
 * @描述 对表格一行进行操作 包括添加一行，删除一行，提交一行，撤销一行
 */
public interface OperateLine {


    /**
     * @描述 向表格中添加一行 从一个数据库表中读取一行数据插入到另一个数据库表
     * @参数 length列的个数,key是进行插入的实体关键字,column是table1中对应key的列名,table1 读取的表, w 主界面窗口
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void addRowTable(int length,String key,String column,String tablename,final Windows w);

    /**
     * @描述 向表格中删除一行,根据特定的属性 在特定的数据库表中
     * @参数 column 对应的列名,tablename 对应的要删除的表,w主界面的窗体
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void deleteRowTable(String column,String tablename,final Windows w);

    /**
     * @描述 将表格中指定的行提交到数据库表中
     * @参数 w 主界面窗体 ,columnname table中的主键属性进行重复判断,tablename 提交的数据库表名,length 列名的长度
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void uploadRowTable(final Windows w,String columnname,String tablename,int length);


    /**
     * @描述 将表格中的行中的数据进行修改;
     * @参数 length 列的个数, key修改行的主键信息, column key所对应的列名,tablename 修改的表,w 主界面的窗体
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void updateRowTable(int length,String key, String column, String tablename, Windows w);


    /**
     * @描述 将表格中的行进行撤销 还原回最初在数据库表中的状态
     * @参数 length列的个数,key是进行插入的实体关键字,column是table1中对应key的列名,table1 读取的表, w 主界面窗口
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void withdrawRowTable(int length, String key2, String tablename, Windows w);
}
