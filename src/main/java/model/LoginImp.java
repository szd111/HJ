package model;

import model.database.DatabaseDaoDmImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 描述
 * 时间 2018/9/29$
 * 作者 rduan
 */
public class LoginImp implements Login {


    @Override
    public int loginAccessDb(String user, String pass) {


        int flag = 0;

        DatabaseDaoDmImp d = new DatabaseDaoDmImp();

        Connection c = d.getConnection();

        ResultSet r = d.executeQuery("select * from DR.TABLE_1 where DATABASE_USER='" + user + "'", c);
        System.out.println(r);
        try {
            while (r.next()) {

                if (r.getString(2).equals(pass)) {
                    flag = 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        d.destroy(c);
        try {
            r.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
