package model.database;

import util.Io;

import java.sql.*;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/27
 * @描述 对数据库底层操作的接口进行实现
 */
public class DatabaseDaoImp implements DatabaseDao {

    String PATH = "src/main/resources/sql.propertites";

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            try {
                Class.forName(Io.readPropertites(PATH, "DRIVER_NAME"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String dbURL = Io.readPropertites(PATH, "DATABASE_URL");
            String username = Io.readPropertites(PATH, "DATABASE_USER");
            String password = Io.readPropertites(PATH, "DATABASE_PASSWORD");
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            System.out.println("找不到数据库驱动程序.");
        }

        return connection;
    }

    @Override
    public void destroy(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("不能关闭数据库连接: " + e.getMessage());
        }
    }

    @Override
    public ResultSet executeQuery(String sql, Connection connection) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {// TODO Auto-generated catch block

            e.printStackTrace();

        }
        return resultSet;


    }

    @Override
    public ResultSet executeQuerys(String sql, String[] params, Connection connection) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }

            resultSet = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return resultSet;
    }

    @Override
    public int executeUpdate(String sql, Connection connection) {

        Statement statement;
        int count = 0;
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(sql);
            //statement.close();
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public int executeUpdates(String sql, String[] params, Connection connection) {
        int b = 1;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }

            if (ps.executeUpdate() != 1) {
                b = 0;
            }
        } catch (Exception e) {

            e.printStackTrace();
            // TODO: handle exception
        }
        return b;
    }


    public static void main(String args[]) throws SQLException {

        DatabaseDaoImp d = new DatabaseDaoImp();

        Connection c = d.getConnection();

        ResultSet r = d.executeQuery("select * from DR.TABLE_1;", c);

        while (r.next()) {

            System.out.println(r.getString("DATABASE_USER"));
            System.out.println(r.getString("DATABASE_PASSWORD"));
        }

    }
}
