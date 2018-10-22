package util;


import view.Windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Vector;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/28
 * @描述 根据数据建立数据表
 */
public class CreateTable {


    /**
     * @描述 创建表格
     * @参数 columns 列数据， hp 行数据，w 主界面窗体
     * @返回值 JTable
     * @创建人 szd
     * @创建时间 2018/9/28
     * @修改人和其它信息
     */
    public JTable createTable(String columns[], HashMap<Integer, String[]> hp, final Windows w) {



        //创建列名 并赋值
        Vector<String> columnNameV = new Vector<>();

        for (int i = 0; i < columns.length; i++) {

            columnNameV.add(columns[i]);
        }


        Vector<Vector<String>> tableValueV = new Vector<>();

        for (int i = 0; i < hp.size(); i++) {

            //获取每一行的数据
            String[] rows = hp.get(i);

            Vector<String> rowV = new Vector<>();
            //System.out.println("=====rows.length===="+rows.length);

            for (int j = 0; j < rows.length; j++) {


                rowV.add(rows[j]);

                System.out.print("==" + rows[j] + "  ");

            }
            System.out.println("=========");
            tableValueV.add(rowV);
        }


        //创建指定表格列名和表格数据的表格
        w.tableModel = new DefaultTableModel(tableValueV, columnNameV) {

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==1){
                    return true;
                }
                return w.ok;
            }
        };
        JTable table = new JTable(w.tableModel);

        CreateTree ct = new CreateTree();


     //   JTreeComboBox comboBox = new JTreeComboBox(ct.getJTree());

        //选中其中一列定义树形下拉框
      //  TableColumn column = new TableColumn();
      //  column = table.getColumnModel().getColumn(1);
     //   column.setCellEditor(new DefaultCellEditor(comboBox));


        return table;
    }

    /**
     * @描述 跟新表格 flag为0是添加1行 为1是删除一行
     * @参数 flag 0/1
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/28
     * @修改人和其它信息
     */

    public void updateTable(int flag, Windows w) {


        String[] rowValues = {"", ""};
        w.tableModel.addRow(rowValues);


    }


}
