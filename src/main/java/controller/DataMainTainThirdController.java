package controller;

import model.OperateLine;
import model.OperateLineImp;
import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.Columns;
import model.entity.TreeNode;
import thread.LoadTableThread;
import util.CreateTable;
import util.CreateTree;
import util.ImagePanel;
import util.RegExpValidatorUtils;
import view.UserLogin;
import view.Windows;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @创建人 rduan
 * @创建时间 2018/10/10
 * @描述 针对windows界面中的数据维护中的wjzb 的actionformed进行事件的控制
 */
public class DataMainTainThirdController {


    OperateLine oc = null;
    public JButton jb11, jb22, jb33, jb44;//数据维护界面 对应的增删改查;
    public JTable jTable = null;
    /**
     * @描述 退出界面操作 通过鼠标点击退出键进行退出
     * @参数 JFrame窗体
     * @返回值 null
     * @创建人 rduan
     * @创建时间 2018/10/10
     * @修改人和其它信息
     */
    public void exit(JFrame j) {

        j.dispose();
        UserLogin n = new UserLogin();

    }
    /**
     * @描述 对wjzb 的actionformed作出监听
     * @参数
     * @返回值
     * @创建人 rduan
     * @创建时间 2018/10/10
     * @修改人和其它信息
     */
    public void armySituation(final Windows w) {

        //第一次加载树节点 从本地文件夹tree中
        final JTree jt = w.jt33;

        //进行表格数据的加载
        final LoadTableThread[] loadTableThread = {new LoadTableThread("数据_通用_WJZB", jt, w)};
        loadTableThread[0].start();

        //更新面板
        w.jp1.removeAll();
        w.jp1.add(jt);
        w.jp1.revalidate();
        w.jp1.repaint();

        //对树节点进行事件监听
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                System.out.println("=======数据维护===wjzb====");
                jTable = w.jTable;
                JScrollPane scrollPane = null;
                if (jTable != null) {
                    loadTableThread[0] = null;
                    jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
                    jTable.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                            //得到选中的行列的索引值

                            int r = jTable.getSelectedRow();

                            int c = jTable.getSelectedColumn();

                            //得到选中的单元格的值，表格中都是字符串

                            Object value = jTable.getValueAt(r, c);

                            String info = r + "行" + c + "列值 : " + value.toString();

                            System.out.println("==info==" + info);
                            if (RegExpValidatorUtils.IsIntNumber(e.getKeyChar() + "")) {

                                w.ok = true;
                                System.out.println(e.getKeyChar());

                                jTable.repaint();

                            }

                            System.out.println("====2==" + e.getKeyChar());
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            //   System.out.println("====3=="+e.getKeyChar());
                            w.ok = false;
                        }
                    });

                   scrollPane = new JScrollPane(jTable);
                    scrollPane.setViewportView(jTable);
                    try {
                        w.p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
                    } catch (IOException e1) {
                        // TODO 自动生成的 catch 块
                        e1.printStackTrace();
                    }
                    w.jp3Image = new ImagePanel(w.p3Icon);
                    w.jp3Image.setLayout(new BorderLayout());
                    jb11 = new JButton("添加");
                    jb11.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.addRowTable(27,object.toString(),"ZBGJDQ","字典_通用_WJZB",w);
                            System.out.println("====add--===");
                            oc = null;


                        }
                    });

                    jb22 = new JButton("删除");
                    jb22.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.deleteRowTable("ZBGJDQ","数据_通用_WJZB",w);
                            oc = null;
                            System.out.println("====delete--===");


                        }
                    });

                    jb33 = new JButton("提交");
                    jb33.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.uploadRowTable(w,"ZBGJDQ","数据_通用_WJZB",27);
                            oc = null;

                        }
                    });

                    jb44 = new JButton("撤销");
                    jb44.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            // ((OperateLineImp) oc).updateTableStructure(w,scrollPane);
                            oc.withdrawRowTable(27,"ZBGJDQ","字典_通用_WJZB",w);
                            oc = null;
                        }
                    });

                    w.jp3.removeAll();
                    w.jp6 = new JPanel();
                    w.jp6.add(jb11);
                    w.jp6.add(jb22);
                    w.jp6.add(jb33);
                    w.jp6.add(jb44);
                    w.jp3Image.add(w.jp6, BorderLayout.NORTH);
                    w.jp3Image.add(scrollPane, BorderLayout.CENTER);
                    w.jp3.add(w.jp3Image);
                    w.jp3.repaint();
                    w.jp3.revalidate();
                }
            }
        });
    }
}
