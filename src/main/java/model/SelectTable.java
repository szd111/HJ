package model;

import model.entity.Columns;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/8
 * @描述 对表进行查询 根据表名 获取表的字段和表的内容
 */
public interface SelectTable {


    /**
     * @描述 根据表名获取表的字段名和字段类型
     * @参数 name 表名
     * @返回值 ArrayList<Columns> 列名实体的list数组
     * @创建人 szd
     * @创建时间 2018/10/8
     * @修改人和其它信息
     */

    public ArrayList<Columns> getColumnName(String name) throws SQLException;


}
