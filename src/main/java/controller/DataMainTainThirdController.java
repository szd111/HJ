package controller;

import model.OperateLine;
import model.OperateLineImp;
import model.database.DatabaseDaoImp;
import util.CreateTable;
import util.CreateTree;
import util.ImagePanel;
import util.RegExpValidatorUtils;
import view.UserLogin;
import view.Windows;

import model.database.Databasezb;
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
import java.util.HashMap;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


/**
 * @创建人 rduan
 * @创建时间 2018/10/10
 * @描述 针对windows界面中的数据维护中的我军装备的actionformed进行事件的控制
 */
public class DataMainTainThirdController {


    OperateLine oc = null;

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
     * @描述 对战备工程的actionformed作出监听
     * @参数
     * @返回值
     * @创建人 rduan
     * @创建时间 2018/10/10
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
                Databasezb d = new Databasezb();

                Connection c = d.getConnection();

                ResultSet r = d.executeQuery("select * from DR.表三", c);

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt
                        .getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();
                if (node.isLeaf()) {

                    System.out.println("You have chosen:" + object.toString());

                    w.p2_jl1 = new JLabel("You have chosen:" + object.toString());

                    w.flagObject = object.toString();

                    String column[] = {"id", "name", "age"};

                    HashMap<Integer, String[]> rows = new HashMap<Integer, String[]>();

                    int i=0;
                    try {
                        while(r.next()){

                            rows.put(i, new String[]{r.getInt("ID")+"", r.getString("NAME"), r.getString("AGE")});
                            i++;

                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

//                    rows.put(0, new String[]{"1", "dr", "11", "boy","中国"});
//                    rows.put(1, new String[]{"2", "mary", "11", "boy","中国"});
//                    rows.put(2, new String[]{"3", "tom", "12", "girl","美国"});
//                    rows.put(3, new String[]{"4", "bort", "12", "boy","美国"});


                    w.jTable = (JTable) cb.createTable(column, rows, w);

                    w.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选

                    w.jTable.addMouseListener(new MouseAdapter(){

                        public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

                            if(e.getClickCount()==1) {

                                //得到选中的行列的索引值

                                int r = w.jTable.getSelectedRow();

                                int c = w.jTable.getSelectedColumn();

                                //得到选中的单元格的值，表格中都是字符串

                                Object value = w.jTable.getValueAt(r, c);

                                String info = r + "行" + c + "列值 : " + value.toString();

                                System.out.println("==info==" + info);
                                // javax.swing.JOptionPane.showMessageDialog(null,info);
                            }
                        }

                    });

                    w.jTable.addKeyListener(new KeyListener() {


                        @Override
                        public void keyTyped(KeyEvent e) {

                            if(e.getKeyChar()=='k'){

                                //  System.out.println(e.getKeyChar());

                            }
                            // System.out.println("====1=="+e.getKeyChar());
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                            if(RegExpValidatorUtils.IsIntNumber(e.getKeyChar()+"")){

                                w.ok=true;
                                System.out.println(e.getKeyChar());
                                w.jTable.repaint();

                            }

                            System.out.println("====2=="+e.getKeyChar());
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            //   System.out.println("====3=="+e.getKeyChar());
                            w.ok=false;
                        }
                    });

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
