package controller;

import model.OperateLine;
import model.OperateLineImp;
import util.CreateTable;
import util.CreateTree;
import util.ImagePanel;
import view.UserLogin;
import view.Windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;


/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 针对windows界面中的数据维护中的部队情况的actionformed进行事件的控制
 */
public class DataMainTainFirstController {


    OperateLine oc = null;

    /**
     * @描述 退出界面操作 通过鼠标点击退出键进行退出
     * @参数 JFrame窗体
     * @返回值 null
     * @创建人 shizhengdong
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public void exit(JFrame j) {

        j.dispose();
        UserLogin n = new UserLogin();

    }


    /**
     * @描述 对部队情况的actionformed作出监听
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public void armySituation(final Windows w) {


        final CreateTable cb = new CreateTable();


        CreateTree ct = new CreateTree();

        final JTree jt = ct.getJTree();


        w.jp1.removeAll();
        w.jp1.repaint();
        w.jp1.add(jt);
        w.jp1.revalidate();


        //对树节点进行事件监听
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt
                        .getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();
                if (node.isLeaf()) {

                    System.out.println("You have chosen:" + object.toString());

                    w.p2_jl1 = new JLabel("You have chosen:" + object.toString());

                    w.flagObject = object.toString();

                    String column[] = {"id", "name", "age", "sex"};

                    HashMap<Integer, String[]> rows = new HashMap<Integer, String[]>();


                    rows.put(0, new String[]{"1", "szd", "11", "boy"});
                    rows.put(1, new String[]{"2", "jetli", "21", "boy"});
                    rows.put(2, new String[]{"3", "tom", "31", "boy"});
                    rows.put(3, new String[]{"4", "jane", "1", "boy"});


                    w.jTable = (JTable) cb.createTable(column, rows, w);

                    w.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
                    JScrollPane scrollPane = new JScrollPane(w.jTable);
                    scrollPane.setViewportView(w.jTable);


                    w.jp3.removeAll();
                    w.jp3.repaint();
                    try {
                        w.p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
                    } catch (IOException e1) {
                        // TODO 自动生成的 catch 块
                        e1.printStackTrace();
                    }
                    w.jp3Image = new ImagePanel(w.p3Icon);
                    w.jp3Image.setLayout(new BorderLayout());
                    w.jb11 = new JButton("添加");
                    w.jb11.addActionListener(new ActionListener() {


                        @Override
                        public void actionPerformed(ActionEvent e) {

                            oc = new OperateLineImp();
                            oc.addRowTable(w);
                            System.out.println("====add--===");
                            oc = null;

                        }
                    });


                    w.jb22 = new JButton("删除");
                    w.jb22.addActionListener(new ActionListener() {


                        @Override
                        public void actionPerformed(ActionEvent e) {

                            oc = new OperateLineImp();
                            oc.deleteRowTable(w);
                            oc = null;
                            System.out.println("====delete--===");


                        }
                    });


                    w.jb33 = new JButton("提交");
                    w.jb33.addActionListener(new ActionListener() {


                        @Override
                        public void actionPerformed(ActionEvent e) {

                            oc = new OperateLineImp();
                            oc.uploadRowTable(w);
                            oc = null;

                        }
                    });

                    w.jb44 = new JButton("撤销");
                    w.jb44.addActionListener(w);


                    w.jp6 = new JPanel();
                    w.jp6.add(w.jb11);
                    w.jp6.add(w.jb22);

                    w.jp6.add(w.jb33);
                    w.jp6.add(w.jb44);
                    w.jp3Image.add(w.jp6, BorderLayout.NORTH);
                    w.jp3Image.add(scrollPane, BorderLayout.CENTER);

                    w.jp3.add(w.jp3Image);
                    w.jp3.revalidate();


                }
            }
        });


    }


}
