package model;

import model.database.DatabaseDaoImp;

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

        DatabaseDaoImp d = new DatabaseDaoImp();

        Connection c = d.getConnection();

        ResultSet r = d.executeQuery("select * from scott.HJ_USER where NAME='" + user + "'", c);
        try {
            while (r.next()) {

                if (r.getString("PASSWORD").equals(pass)) {
                    flag = 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        d.destroy(c);
        return flag;
    }


    public void checkAut(String check){
        System.out.println("aaa"+check);



    }


}
