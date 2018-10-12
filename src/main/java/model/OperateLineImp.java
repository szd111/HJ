package model;

import util.CreateTable;
import view.Windows;

import javax.swing.*;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/9
 * @描述
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


        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??


        // System.out.println("====selectedRow--==="+getname);
        if (selectedRow != -1)//存在选中行??
        {
            w.tableModel.removeRow(selectedRow);//删除行??
        } else {

            JOptionPane.showMessageDialog(w, "对不起！请选中一行删除！");
        }


    }

    @Override
    public void uploadRowTable(Windows w) {

        int selectedRow = w.jTable.getSelectedRow();//获得选中行的索引??

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
