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
 * @������ shizhendong
 * @����ʱ�� 2018/9/28
 * @���� �������ݽ������ݱ�
 */
public class CreateTable {


    /**
     * @���� �������
     * @���� columns �����ݣ� hp �����ݣ�w �����洰��
     * @����ֵ JTable
     * @������ szd
     * @����ʱ�� 2018/9/28
     * @�޸��˺�������Ϣ
     */
    public JTable createTable(String columns[], HashMap<Integer, String[]> hp, final Windows w) {

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

        //�������� ����ֵ
        Vector<String> columnNameV = new Vector<>();

        for (int i = 0; i < columns.length; i++) {

            columnNameV.add(columns[i]);
        }


        Vector<Vector<String>> tableValueV = new Vector<>();

        for (int i = 0; i < hp.size(); i++) {

            //��ȡÿһ�е�����
            String[] rows = hp.get(i);

            Vector<String> rowV = new Vector<>();
            for (int j = 0; j < rows.length; j++) {


                rowV.add(rows[j]);
                System.out.print("==" + rows[j] + "  ");

            }
            System.out.println("=========");
            tableValueV.add(rowV);
        }


        //����ָ����������ͱ�����ݵı��
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

        JTreeComboBox comboBox = new JTreeComboBox(ct.getJTree());

        //ѡ������һ�ж�������������
        TableColumn column = new TableColumn();
        column = table.getColumnModel().getColumn(1);

        //  DefaultCellEditor
        column.setCellEditor(new DefaultCellEditor(comboBox));

        return table;
    }

    /**
     * @���� ���±�� flagΪ0�����1�� Ϊ1��ɾ��һ��
     * @���� flag 0/1
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/9/28
     * @�޸��˺�������Ϣ
     */

    public void updateTable(int flag, Windows w) {


        String[] rowValues = {"", ""};
        w.tableModel.addRow(rowValues);


    }


}
