package controller;

import model.DictionaryMainTainOperate;
import model.DictionaryMainTainOperate1Imp;
import model.OperateLine;
import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.TreeNode;
import util.CreateTable;
import util.CreateTree;
import util.FontTools;
import util.Io;
import view.UserLogin;
import view.Windows;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @创建人 rduan
 * @创建时间 2018/10/17
 * @描述 针对windows界面中的字典维护中的部队番号的actionformed进行事件的控制
 */
public class DictionaryMainTainController {
    public JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19, jl20, jl21, jl22, jl23, jl24, jl25, jl26, jl27, jl28, jl29, jl30, jl31;
    public JTextField jname1, jname2, jname3, jname4, jname5, jname6, jname7, jname8, jname9, jname10, jname11, jname12, jname13, jname14, jname15, jname16, jname17, jname18, jname19, jname20, jname21, jname22, jname23, jname24, jname25, jname26, jname27, jname28, jname29, jname30, jname31;
    public JButton jbt1, jbt2, jbt3, jbt4;
    public TextArea are1, are2;

    OperateLine oc = null;

    /**
     * @描述 退出界面操作 通过鼠标点击退出键进行退出
     * @参数 JFrame窗体
     * @返回值 null
     * @创建人 rduan
     * @创建时间 2018/10/17
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
     * @创建时间 2018/10/17
     * @修改人和其它信息
     */

    public void armySituation(final Windows w) {

        //加载表格及相关类
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();
        final DictionaryMainTainOperate[] dictionaryMainTainOperate = {null};

        //第一次加载树节点 从本地文件夹tree中
        final JTree jt = w.jt;


        //更新面板
        w.jp1.removeAll();
        w.jp1.add(jt);
        w.jp1.revalidate();
        w.jp1.repaint();



        //对树节点进行事件监听
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();

                //根据右击的树状节点 在数据库表中查询

                System.out.println("You have chosen:" + object.toString());
                d.database = "oracle";
                Connection c = d.getConnection();
                ResultSet r = d.executeQuery("select * from NSDB.字典_通用_部队番号 where 部队番号='" + object.toString() + "'", c);
                try {
                    r.next();
                    System.out.println("=ssss===" + r.getObject("部队番号"));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                jbt1 = new JButton("修改提交");
                jbt1.setBounds(700, 30, 70, 30);
                //提交按钮事件
                jbt1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String id=jname1.getText();
                        String tt=jname3.getText();
                        System.out.println("====提交--==="+id);
                        dictionaryMainTainOperate[0] =new DictionaryMainTainOperate1Imp();
                        dictionaryMainTainOperate[0].updateTreeNode(id,tt);
                        JOptionPane.showMessageDialog(w, "修改 "+id);


                    }
                });
                jbt2 = new JButton("刷新树结构");
                jbt2.setBounds(770, 30, 70, 30);
                //撤销按钮事件
                jbt2.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                                //进行刷新

                                JOptionPane.showMessageDialog(w, "正在刷新树结构 稍等");
                                dictionaryMainTainOperate[0] =new DictionaryMainTainOperate1Imp();
                                //dictionaryMainTainOperate[0].updateTreeStructure(w);
                                JOptionPane.showMessageDialog(w, "刷新完毕");

                    }
                });

                jbt3 = new JButton("撤销");
                jbt3.setBounds(840, 30, 70, 30);
                //修改按钮事件
                jbt3.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====修改--===");

                    }
                });

                try {
                    jl1 = new JLabel("部队内码:");
                    jl1.setFont(FontTools.f5);
                    jl1.setBounds(450, 100, 150, 30);


                    jname1 = new JTextField(r.getObject("部队内码") + "", 20);

                    jname1.setBounds(550, 100, 200, 30);

                    jl2 = new JLabel("部队序号:");
                    jl2.setFont(FontTools.f5);
                    jl2.setBounds(850, 100, 150, 30);

                    jname2 = new JTextField(r.getObject("部队序号") + "", 20);
                    jname2.setBounds(950, 100, 200, 30);

                    jl3 = new JLabel("部队简称:");
                    jl3.setFont(FontTools.f5);
                    jl3.setBounds(450, 150, 150, 30);

                    jname3 = new JTextField(r.getObject("部队简称") + "", 20);
                    jname3.setBounds(550, 150, 200, 30);

                    jl10 = new JLabel("部队番号:");
                    jl10.setFont(FontTools.f5);
                    jl10.setBounds(850, 150, 150, 30);

                    jname10 = new JTextField(20);
                    jname10.setText(r.getObject("部队番号") + "");
                    jname10.setBounds(950, 150, 200, 30);

                    jl4 = new JLabel("航保标志:");
                    jl4.setFont(FontTools.f5);
                    jl4.setBounds(640, 350, 200, 30);

                    jname4 = new JTextField(20);
                    jname4.setBounds(740, 350, 30, 30);

                    jl5 = new JLabel("机构标志:");
                    jl5.setFont(FontTools.f5);
                    jl5.setBounds(830, 250, 150, 30);

                    jname5 = new JTextField(20);
                    jname5.setBounds(930, 250, 30, 30);

                    jl6 = new JLabel("直属标志:");
                    jl6.setFont(FontTools.f5);
                    jl6.setBounds(450, 250, 200, 30);

                    jname6 = new JTextField(20);
                    jname6.setBounds(550, 250, 30, 30);

                    jl7 = new JLabel("机要标志:");
                    jl7.setFont(FontTools.f5);
                    jl7.setBounds(640, 250, 150, 30);

                    jname7 = new JTextField(20);
                    jname7.setBounds(740, 250, 30, 30);

                    jl8 = new JLabel("作战标志:");
                    jl8.setFont(FontTools.f5);
                    jl8.setBounds(1020, 250, 200, 30);

                    jname8 = new JTextField(20);
                    jname8.setBounds(1120, 250, 30, 30);

                    jl9 = new JLabel("情报标志:");
                    jl9.setFont(FontTools.f5);
                    jl9.setBounds(450, 300, 150, 30);

                    jname9 = new JTextField(20);
                    jname9.setBounds(550, 300, 30, 30);

                    jl11 = new JLabel("通讯标志:");
                    jl11.setFont(FontTools.f5);
                    jl11.setBounds(640, 300, 200, 30);

                    jname11 = new JTextField(20);
                    jname11.setBounds(740, 300, 30, 30);

                    jl12 = new JLabel("四部标志:");
                    jl12.setFont(FontTools.f5);
                    jl12.setBounds(830, 300, 150, 30);

                    jname12 = new JTextField(20);
                    jname12.setBounds(930, 300, 30, 30);

                    jl13 = new JLabel("军训标志:");
                    jl13.setFont(FontTools.f5);
                    jl13.setBounds(1020, 300, 200, 30);

                    jname13 = new JTextField(20);
                    jname13.setBounds(1120, 300, 30, 30);

                    jl14 = new JLabel("军务标志:");
                    jl14.setFont(FontTools.f5);
                    jl14.setBounds(450, 350, 150, 30);

                    jname14 = new JTextField(20);
                    jname14.setBounds(550, 350, 30, 30);

                    jl15 = new JLabel("政工标志:");
                    jl15.setFont(FontTools.f5);
                    jl15.setBounds(830, 350, 150, 30);

                    jname15 = new JTextField(20);
                    jname15.setBounds(930, 350, 30, 30);

                    jl16 = new JLabel("后勤标志:");
                    jl16.setFont(FontTools.f5);
                    jl16.setBounds(1020, 350, 200, 30);
                    jname16 = new JTextField(20);
                    jname16.setBounds(1120, 350, 30, 30);

                    jl17 = new JLabel("海装标志:");
                    jl17.setFont(FontTools.f5);
                    jl17.setBounds(450, 400, 150, 30);

                    jname17 = new JTextField(20);
                    jname17.setBounds(550, 400, 30, 30);

                    jl18 = new JLabel("预备役标志:");
                    jl18.setFont(FontTools.f5);
                    jl18.setBounds(640, 400, 200, 30);

                    jname18 = new JTextField(20);
                    jname18.setBounds(740, 400, 30, 30);

                    jl19 = new JLabel("备用标志1:");
                    jl19.setFont(FontTools.f5);
                    jl19.setBounds(830, 400, 150, 30);

                    jname19 = new JTextField(20);
                    jname19.setBounds(930, 400, 30, 30);

                    jl20 = new JLabel("备用标志2:");
                    jl20.setFont(FontTools.f5);
                    jl20.setBounds(1020, 400, 200, 30);
                    jname20 = new JTextField(20);
                    jname20.setBounds(1120, 400, 30, 30);

                    jl21 = new JLabel("备用标志3:");
                    jl21.setFont(FontTools.f5);
                    jl21.setBounds(450, 450, 150, 30);

                    jname21 = new JTextField(20);
                    jname21.setBounds(550, 450, 30, 30);

                    jl22 = new JLabel("备用标志4:");
                    jl22.setFont(FontTools.f5);
                    jl22.setBounds(640, 450, 200, 30);

                    jname22 = new JTextField(20);
                    jname22.setBounds(740, 450, 30, 30);

                    jl23 = new JLabel("备用标志5:");
                    jl23.setFont(FontTools.f5);
                    jl23.setBounds(830, 450, 150, 30);

                    jname23 = new JTextField(20);
                    jname23.setBounds(930, 450, 30, 30);

                    jl24 = new JLabel("部队编制内码:");
                    jl24.setFont(FontTools.f5);
                    jl24.setBounds(450, 500, 150, 30);

                    jname24 = new JTextField(20);
                    jname24.setText(r.getObject("部队编制内码") + "");
                    jname24.setBounds(590, 500, 200, 30);

                    jl25 = new JLabel("部队编制序号:");
                    jl25.setFont(FontTools.f5);
                    jl25.setBounds(850, 500, 150, 30);

                    jname25 = new JTextField(20);
                    jname25.setText(r.getObject("部队编制序号") + "");
                    jname25.setBounds(990, 500, 200, 30);

                    jl26 = new JLabel("部队编制番号:");
                    jl26.setFont(FontTools.f5);
                    jl26.setBounds(450, 550, 150, 30);

                    jname26 = new JTextField(20);
                    jname26.setText(r.getObject("部队编制番号") + "");
                    jname26.setBounds(590, 550, 200, 30);

                    jl27 = new JLabel("部队编制简称:");

                    jl27.setFont(FontTools.f5);
                    jl27.setBounds(850, 550, 150, 30);

                    jname27 = new JTextField(20);
                    jname27.setText(r.getObject("部队编制简称") + "");
                    jname27.setBounds(990, 550, 200, 30);

                    jl28 = new JLabel("部队划分:");
                    jl28.setFont(FontTools.f5);
                    jl28.setBounds(450, 600, 150, 30);

                    jname28 = new JTextField(20);
                    jname28.setText(r.getObject("部队划分") + "");
                    jname28.setBounds(590, 600, 200, 30);

                    jl29 = new JLabel("退出现役标志:");
                    jl29.setFont(FontTools.f5);
                    jl29.setBounds(850, 600, 150, 30);

                    jname29 = new JTextField(20);
                    jname29.setBounds(990, 600, 30, 30);

                    jl30 = new JLabel("备用:");
                    jl30.setFont(FontTools.f5);
                    jl30.setBounds(450, 650, 70, 30);

                    are1 = new TextArea();
                    are1.setBounds(520, 650, 320, 200);

                    jl31 = new JLabel("备注:");
                    jl31.setFont(FontTools.f5);
                    jl31.setBounds(850, 650, 70, 30);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {
                    //关闭数据库连接
                    c.close();
                    r.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                are2 = new TextArea();
                are2.setBounds(920, 650, 320, 200);
                w.jp3.setLayout(null);


                w.jp3.removeAll();
               // w.jp3.repaint();


                w.jp3.add(jbt1);
                w.jp3.add(jbt2);
                w.jp3.add(jbt3);

                w.jp3.add(jl1);
                w.jp3.add(jname1);
                w.jp3.add(jl2);
                w.jp3.add(jname2);
                w.jp3.add(jl2);
                w.jp3.add(jname2);
                w.jp3.add(jl3);
                w.jp3.add(jname3);
                w.jp3.add(jl4);
                w.jp3.add(jname4);
                w.jp3.add(jl5);
                w.jp3.add(jname5);
                w.jp3.add(jl6);
                w.jp3.add(jname6);
                w.jp3.add(jl7);
                w.jp3.add(jname7);
                w.jp3.add(jl8);
                w.jp3.add(jname8);
                w.jp3.add(jl9);
                w.jp3.add(jname9);
                w.jp3.add(jl10);
                w.jp3.add(jname10);
                w.jp3.add(jl11);
                w.jp3.add(jname11);
                w.jp3.add(jl12);
                w.jp3.add(jname12);
                w.jp3.add(jl13);
                w.jp3.add(jname13);
                w.jp3.add(jl14);
                w.jp3.add(jname14);
                w.jp3.add(jl15);
                w.jp3.add(jname15);
                w.jp3.add(jl16);
                w.jp3.add(jname16);
                w.jp3.add(jl17);
                w.jp3.add(jname17);
                w.jp3.add(jl18);
                w.jp3.add(jname18);
                w.jp3.add(jl19);
                w.jp3.add(jname19);
                w.jp3.add(jl20);
                w.jp3.add(jname20);
                w.jp3.add(jl21);
                w.jp3.add(jname21);
                w.jp3.add(jl22);
                w.jp3.add(jname22);
                w.jp3.add(jl23);
                w.jp3.add(jname23);
                w.jp3.add(jl24);
                w.jp3.add(jname24);
                w.jp3.add(jl25);
                w.jp3.add(jname25);
                w.jp3.add(jl26);
                w.jp3.add(jname26);
                w.jp3.add(jl27);
                w.jp3.add(jname27);
                w.jp3.add(jl28);
                w.jp3.add(jname28);
                w.jp3.add(jl29);
                w.jp3.add(jname29);
                w.jp3.add(jl30);
                w.jp3.add(are1);
                w.jp3.add(jl31);
                w.jp3.add(are2);

                w.jp3.revalidate();
                  w.jp3.repaint();



            }

            //    }

        });


    }


}
