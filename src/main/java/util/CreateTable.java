package util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/28
 * @���� �������ݽ������ݱ�
 */
public class CreateTable {


/**

 *@���� �������

 *@����

 *@����ֵ

 *@������  szd

 *@����ʱ��  2018/9/28

 *@�޸��˺�������Ϣ

 */
public JScrollPane createTable(String x){

//    String[] columnNames = {"A","B"};    //��������������
//    //��������������
//    String[][] tableValues = {{"A1","B1"},{"A2","B2"},{"A3","B3"},
//            {"A4","B4"},{"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},
//            {"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},{"A5","B5"},
//            {"A5","B5"},{"A5","B5"}};
//    //����ָ�����������ݵı��
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
    //����ָ����������ͱ�����ݵı��
    JTable table = new JTable(tableValueV,columnNameV);
    JScrollPane scrollPane = new JScrollPane(table);
    return  scrollPane;
}

}
