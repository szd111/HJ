package model;

import com.sun.java.swing.plaf.windows.resources.windows;
import controller.DataMainTainFirstController;
import model.database.DatabaseDaoImp;
import util.CreateTable;
import view.Windows;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/9
 * @描述
 */
public class OperateLineImp implements OperateLine {

    DatabaseDaoImp databaseDaoImp = new DatabaseDaoImp();

    @Override
    public void addRowTable(int length, String key, String key2, String tablename, Windows w) {
        Connection c = databaseDaoImp.getConnection();

        String sql = "select * from " + tablename + " where " + key2 + " ='" + key + "'";

        System.out.println("====sql=a=" + sql);
        ResultSet rs = databaseDaoImp.executeQuery(sql, c);
        String[] rowValues = new String[31];
        try {
            rs.next();
            for (int i = 0; i < length; i++) {
                rowValues[i] = rs.getObject(i + 1) + "";
            }
            CreateTable cb = new CreateTable();
            cb.updateTable(rowValues, w);
            System.out.println("====add--=ssssss==");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteRowTable( String column, String tablename, Windows w) {

        CreateTable cb = new CreateTable();


        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??
        if (selectedRow != -1)//存在选中行??
        {
            Connection c = databaseDaoImp.getConnection();
            String key= w.jTable.getValueAt(selectedRow, 3) + "";
            String sql = "delete from " + tablename + " where " + column + " ='" + key + "'";
            System.out.println("====sql==" + sql);
            databaseDaoImp.executeUpdate(sql, c);
            databaseDaoImp.destroy(c);
            w.tableModel.removeRow(selectedRow);//删除行??
        } else {

            JOptionPane.showMessageDialog(w, "对不起！请选中一行！");
        }


    }

    @Override
    public void uploadRowTable(Windows w,String columnname ,String tablename, int length) {
        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??

        if (selectedRow != -1) {
            Connection c = databaseDaoImp.getConnection();
            String key=w.jTable.getValueAt(selectedRow, 3) + "";
            //String column="Dd";
            String sqls = "select * from " + tablename + " where " + columnname + " ='" + key + "'";
            ResultSet resultSet=databaseDaoImp.executeQuery(sqls,c);

            try {
                if(!resultSet.next()) {
                    String sql = "insert into " + tablename + " values(";

                    for (int i = 0; i < length; i++) {
                        if (i == length - 1) {

                            sql += "?)";
                        } else {
                            sql += "?,";
                        }
                    }
                    System.out.println("====sql==" + sql);
                    String str[] = new String[length];
                    for (int n = 0; n < length; n++) {
                        //object.add(jTable.getVauleAt(index,n));
                        System.out.println(selectedRow + "====ok--===" + w.jTable.getValueAt(selectedRow, n));

                        if(w.jTable.getValueAt(selectedRow, n).equals("null")) {
                            str[n] = null;
                            System.out.println(selectedRow + "====ok===");
                        }else{
                            str[n] = w.jTable.getValueAt(selectedRow, n) + "";
                        }
                    }
                    databaseDaoImp.executeQuerys(sql, str, c);
                    databaseDaoImp.destroy(c);
                    JOptionPane.showMessageDialog(w, "提交完毕！");
                }
                else{
                    JOptionPane.showMessageDialog(w, "重复提交！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(w, "请选择一行提交！");

        }
    }

    @Override
    public void updateRowTable(int length,String key, String column, String tablename, Windows w) {

        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??

        if (selectedRow != -1) {
            String str[] = new String[length];
            for (int n = 0; n < length; n++) {
                //object.add(jTable.getVauleAt(index,n));
                System.out.println(selectedRow + "====ok--===" + w.jTable.getValueAt(selectedRow, n));

                str[n] = w.jTable.getValueAt(selectedRow, n) + "";
            }
            deleteRowTable(column, tablename, w);

            String sql = "insert into " + tablename + " values(";

            for (int i = 0; i < length; i++) {
                if (i == length - 1) {

                    sql += "?)";
                } else {
                    sql += "?,";
                }
            }
            System.out.println("====sql==" + sql);
            Connection c=databaseDaoImp.getConnection();
            databaseDaoImp.executeQuerys(sql, str, c);
            databaseDaoImp.destroy(c);

            JOptionPane.showMessageDialog(w, "修改完毕！");
        } else {
            JOptionPane.showMessageDialog(w, "请选择一行修改！");

        }

    }

    @Override
    public void withdrawRowTable(int length,String key2, String tablename, Windows w) {
        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??

        if (selectedRow != -1) {
            Connection c = databaseDaoImp.getConnection();
            String  key=w.jTable.getValueAt(selectedRow, 3)+"";
            String sql = "select * from " + tablename + " where " + key2 + " ='" + key + "'";
            System.out.println("====sqlyy==" + sql);
            ResultSet rs = databaseDaoImp.executeQuery(sql, c);
            String[] rowValues = new String[31];
            try {
                rs.next();
                for (int i = 0; i < length; i++) {

                    rowValues[i]=rs.getObject(i+1)+"";
                }

                w.tableModel.removeRow(selectedRow);
                w.tableModel.addRow(rowValues);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{

            JOptionPane.showMessageDialog(w, "请选择一行！");
        }
    }

    public void updateTableStructure(Windows w, JScrollPane[] scrollPane){

        w.jp3.removeAll();
//        w.jp6 = new JPanel();
//        w.jp6.add(dd.jb11);
//        w.jp6.add(dd.jb22);
//        w.jp6.add(dd.jb33);
//        w.jp6.add(dd.jb44);
//        w.jp3Image.add(w.jp6, BorderLayout.NORTH);
        w.jp3Image.add(scrollPane[0], BorderLayout.CENTER);
        w.jp3.add(w.jp3Image);
        w.jp3.revalidate();
        w.jp3.repaint();
    }
}
