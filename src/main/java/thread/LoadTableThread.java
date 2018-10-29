package thread;

import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.Columns;
import util.CreateTable;
import view.Windows;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/26
 * @描述 进行表格数据加载 根据表名
 */
public class LoadTableThread extends Thread{

    //加载表格及相关类
    final CreateTable cb = new CreateTable();
    DatabaseDaoImp d = new DatabaseDaoImp();
    SelectTableImp sp=new SelectTableImp();

    JTree jt=null;   //初始化树结构
    String tablename="";//表名
    public JTable jTable=null;
    Windows windows=null;
    public LoadTableThread(String tablename, JTree jt, Windows windows){

        this.jt=jt;
        this.tablename=tablename;
        this.windows=windows;
    }

    public void run(){
     System.out.println("====表格数据加载====="+tablename+"  "+"select * from scott."+tablename+"");
        Connection c = d.getConnection();
        ResultSet r = d.executeQuery("select * from scott."+tablename+"", c);

        //从数据库中根据表名动态获取字段及类型
        ArrayList<Columns> columnsArrayList = sp.getColumnName(tablename);
        String column[] = new String[columnsArrayList.size()];
        int kk=columnsArrayList.size();
            for (int i = 0; i < columnsArrayList.size(); i++) {
                kk--;
            column[kk] = columnsArrayList.get(i).getName();

        }
        HashMap<Integer, String[]> rows = new HashMap<Integer, String[]>();
        int i = 0;
        try {
            while (r.next()) {
             //   System.out.println("====r.next======");
                String row[] = new String[columnsArrayList.size()];
                int tt=columnsArrayList.size();
                for (int k = 0; k < columnsArrayList.size(); k++) {
                   tt--;
                row[tt]= r.getObject(columnsArrayList.get(k).getName()) + "";
                //    row[tt] = r.getObject(column[tt]) + "";
                }
                rows.put(i, row);
                i++;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        windows.jTable = (JTable) cb.createTable(column, rows, windows);

        d.destroy(c);
        System.out.println("====表格数据加载 完毕=====");
    }

}
