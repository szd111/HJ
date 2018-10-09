package model;

import model.database.DatabaseDaoImp;
import model.entity.Columns;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/8
 * @描述
 */
public class SelectTableImp implements SelectTable {

    DatabaseDaoImp di = null;
    Columns cl = null;

    @Override
    public ArrayList<Columns> getColumnName(String name) {

        ArrayList<Columns> als = new ArrayList<Columns>();
        di = new DatabaseDaoImp();
        String sql = "select COLUMN_NAME, DATA_TYPE, DATA_LENGTH from ALL_tab_cols where TABLE_NAME='"+name+"'";
        Connection cn = di.getConnection();
        ResultSet rs = di.executeQuery(sql, cn);

        try {
            while (rs.next()) {

                cl = new Columns();
                cl.setLength(rs.getInt("DATA_LENGTH"));
                cl.setName(rs.getString("COLUMN_NAME"));
                cl.setType(rs.getString("DATA_TYPE"));

                als.add(cl);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        di.destroy(cn);

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return als;

    }


}
