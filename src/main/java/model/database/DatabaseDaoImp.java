package model.database;

import util.Io;

import java.sql.*;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/27
 * @���� �����ݿ�ײ�����Ľӿڽ���ʵ��
 */
public class DatabaseDaoImp implements DatabaseDao {

    public String database = "oracle";
    Statement statement = null;
    PreparedStatement ps = null;

    String PATH = "src/main/resources/dm.sql.propertites";
    String PATHS = "src/main/resources/oracle.sql.propertites";

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            try {

                if (database.equals("dm")) {
                    Class.forName(Io.readPropertites(PATH, "DRIVER_NAME"));
                } else if (database.equals("oracle")) {

                    PATH = PATHS;

                    Class.forName(Io.readPropertites(PATHS, "DRIVER_NAME"));
                }
                {

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String dbURL = Io.readPropertites(PATH, "DATABASE_URL");
            String username = Io.readPropertites(PATH, "DATABASE_USER");
            String password = Io.readPropertites(PATH, "DATABASE_PASSWORD");
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("���ݿ����ӳɹ���");
        } catch (Exception e) {
            System.out.println("�Ҳ������ݿ���������.");
        }

        return connection;
    }

    @Override
    public void destroy(Connection connection) {
        try {
            connection.close();

            if (ps != null) {

                ps.close();
            }

            if (statement != null) {

                statement.close();
            }

        } catch (SQLException e) {
            System.out.println("���ܹر����ݿ�����: " + e.getMessage());
        }
    }

    @Override
    public ResultSet executeQuery(String sql, Connection connection) {

        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {// TODO Auto-generated catch block

            e.printStackTrace();

        } finally {


        }
        return resultSet;


    }
    public ResultSet executeQuerys(String sql, Connection connection) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            statement.close();


        } catch (SQLException e) {// TODO Auto-generated catch block

            e.printStackTrace();

        } finally {


        }
        return resultSet;


    }
    @Override
    public ResultSet executeQuerys(String sql, String[] params, Connection connection) {

        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);

            }

            resultSet = ps.executeQuery();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return resultSet;
    }

    @Override
    public int executeUpdate(String sql, Connection connection) {

        int count = 0;
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public int executeUpdates(String sql, String[] params, Connection connection) {
        int b = 1;


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

       // d.database = "oracle";

        Connection c = d.getConnection();

        ResultSet r = d.executeQuery("select * from DR.�ֵ�_ͨ��_���ӷ���", c);


        System.out.println(r);

        while (r.next()) {

            System.out.println(r.getString("���ӷ���"));
            //   System.out.println(r.getDate("����ʱ��"));
            //   System.out.println(r.getString("DATABASE_PASSWORD"));


        }

    }
}
