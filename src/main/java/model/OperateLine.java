package model;

import view.Windows;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/9
 * @描述 对表格一行进行操作 包括添加一行，删除一行，提交一行，撤销一行
 */
public interface OperateLine {


    /**
     * @描述 向表格中添加一行
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void addRowTable(final Windows w);

    /**
     * @描述 向表格中删除一行
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void deleteRowTable(final Windows w);

    /**
     * @描述 将表格中指定的行提交到数据库中
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void uploadRowTable(final Windows w);


    /**
     * @描述 将表格中的行进行撤销
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/9
     * @修改人和其它信息
     */
    public void withdrawRowTable(final Windows w);
}
