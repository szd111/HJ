package util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/28
 * @描述 根据数据建立数据表
 */
public class CreateTable {


/**

 *@描述 创建表格

 *@参数

 *@返回值

 *@创建人  szd

 *@创建时间  2018/9/28

 *@修改人和其它信息

 */
public JScrollPane createTable(String x){

//    String[] columnNames = {"A","B"};    //定义表格列明数组
//    //定义表格数据数组
//    String[][] tableValues = {{"A1","B1"},{"A2","B2"},{"A3","B3"},
//            {"A4","B4"},{"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},
//            {"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},
//            {"A5","B5"},{"A5","B5"}};
//    //创建指定列明和数据的表格
//    JTable table = new JTable(tableValues,columnNames);
//
//   // DefaultTableModel model=new DefaultTableModel(columnNames,8);
//
//   // table.setModel(model);
//
//    return  table;

    Vector<String> columnNameV = new Vector<>();
    columnNameV.add("A");
    columnNameV.add("B");
    columnNameV.add("C");
    columnNameV.add("D");

    Vector<Vector<String>>tableValueV = new Vector<>();
    for(int row = 1;row<6;row++) {
        Vector<String>rowV = new Vector<>();
        rowV.add(x);
        rowV.add("B"+row);
        rowV.add("C"+row);
        rowV.add("D"+row);

        tableValueV.add(rowV);
    }
    //创建指定表格列名和表格数据的表格
    JTable table = new JTable(tableValueV,columnNameV);
    JScrollPane scrollPane = new JScrollPane(table);
    return  scrollPane;
}

}
