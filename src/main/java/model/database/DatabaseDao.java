package model.database;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 数据库的抽象接口 对达梦数据库的链接 查找 更新 删除
 */
public interface DatabaseDao {


    /**
     * @描述 获取数据库的连接
     * @参数
     * @返回值 Connection
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */
    public Connection getConnection();


    /**
     * @描述 关闭数据库的连接
     * @参数 connection 数据库连接
     * @返回值 null
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */
    public void destroy(Connection connection);


    /**
     * @描述 根据相应的sql语句执行查询操作
     * @参数 sql 语句
     * @返回值 ResultSet 结果集
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */
    public ResultSet executeQuery(String sql,Connection connection);

    /**
     * @描述 根据相应的sql语句执行查询操作,带参数
     * @参数 sql 语句
     * @返回值 ResultSet 结果集
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */
    public ResultSet executeQuerys(String sql,String []params,Connection connection);



    /**
     * @描述 根据sql语句进行跟新操作
     * @参数 sql 语句
     * @返回值 int 成功与否
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public int executeUpdate(String sql,Connection connection);

    /**
     * @描述 根据sql语句进行跟新操作,带参数的
     * @参数 sql 语句
     * @返回值 int 成功与否
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public int executeUpdates(String sql,String []params,Connection connection);



}

