package model;

import util.CreateTable;
import view.Windows;

import javax.swing.*;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/10/9
 * @����
 */
public class OperateLineImp implements OperateLine {
    @Override
    public void addRowTable(Windows w) {


        CreateTable cb = new CreateTable();

        cb.updateTable(1, w);
        System.out.println("====add--=ssssss==");

    }

    @Override
    public void deleteRowTable(Windows w) {

        CreateTable cb = new CreateTable();


        int selectedRow = w.jTable.getSelectedRow();//���ѡ���е�����??


        // System.out.println("====selectedRow--==="+getname);
        if (selectedRow != -1)//����ѡ����??
        {
            w.tableModel.removeRow(selectedRow);//ɾ����??
        } else {

            JOptionPane.showMessageDialog(w, "�Բ�����ѡ��һ��ɾ����");
        }


    }

    @Override
    public void uploadRowTable(Windows w) {

        int selectedRow = w.jTable.getSelectedRow();//���ѡ���е�����??

        for (int n = 0; n < 4; n++) {
            //object.add(jTable.getVauleAt(index,n));
            System.out.println(selectedRow + "====ok--===" + w.jTable.getValueAt(selectedRow, n));
        }

        System.out.println("====ok--===");
    }

    @Override
    public void withdrawRowTable(Windows w) {

    }
}
