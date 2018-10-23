package controller;

import model.OperateLine;
import model.OperateLineImp;
import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import util.*;
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

import java.util.HashMap;


/**
 * @������ rduan
 * @����ʱ�� 2018/10/17
 * @���� ���windows�����е��ֵ�ά���е� �����װ����actionformed�����¼��Ŀ���
 */
public class DictionaryMainTainThirdController {
    public JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19, jl20, jl21, jl22, jl23, jl24, jl25, jl26, jl27, jl28, jl29, jl30, jl31;
    public JTextField jname1, jname2, jname3, jname4, jname5, jname6, jname7, jname8, jname9, jname10, jname11, jname12, jname13, jname14, jname15, jname16, jname17, jname18, jname19, jname20, jname21, jname22, jname23, jname24, jname25, jname26, jname27, jname28, jname29, jname30, jname31;
    public JButton jbt1, jbt2, jbt3, jbt4;
    public TextArea are1, are2;

    OperateLine oc = null;

    /**
     * @���� �˳�������� ͨ��������˳��������˳� ���װ����ά��
     * @���� JFrame����
     * @����ֵ null
     * @������ rduan
     * @����ʱ�� 2018/10/17
     * @�޸��˺�������Ϣ
     */

    public void exit(JFrame j) {

        j.dispose();
        UserLogin n = new UserLogin();

    }


    /**
     * @���� �����װ����actionformed��������
     * @����
     * @����ֵ
     * @������ rduan
     * @����ʱ�� 2018/10/17
     * @�޸��˺�������Ϣ
     */

    public void armySituation(final Windows w) {


        //���ر�������
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();


        //��һ�μ������ڵ� �ӱ����ļ���tree��
        // CreateTree cc=new  CreateTree();
        final JTree jt = w.jt3;


        //�������
        w.jp1.removeAll();
        w.jp1.repaint();
        w.jp1.add(jt);
        w.jp1.revalidate();


        //�����ڵ�����¼�����
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();

                //�����һ�����״�ڵ� �����ݿ���в�ѯ

                System.out.println("You have chosen:" + object.toString());
                d.database = "oracle";
                Connection c = d.getConnection();
                ResultSet r = d.executeQuery("select * from scott.�ֵ�_ͨ��_���װ�� where װ������='" + object.toString() + "'", c);
                try {
                    r.next();
                    // System.out.println("=ssss===" + r.getObject("���ӷ���"));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                jbt1 = new JButton("�ύ");
                jbt1.setBounds(700, 30, 70, 30);
                //�ύ��ť�¼�
                jbt1.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====�ύ--===");

                    }
                });
                jbt2 = new JButton("����");
                jbt2.setBounds(770, 30, 70, 30);
                //������ť�¼�
                jbt2.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====����--===");

                    }
                });
                jbt3 = new JButton("����");
                jbt3.setBounds(840, 30, 70, 30);
                //�޸İ�ť�¼�
                jbt3.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====����--===");

                    }
                });
                jbt4 = new JButton("ɾ��");
                jbt4.setBounds(910, 30, 70, 30);
                //ˢ�°�ť�¼�
                jbt4.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====ɾ��--===");

                    }
                });
                try {
                    jl1 = new JLabel("װ������:");
                    jl1.setFont(FontTools.f5);
                    jl1.setBounds(450, 100, 150, 30);

                    jname1 = new JTextField(20);

                    jname1.setText(r.getObject("װ������") + "");

                    jname1.setBounds(550, 100, 200, 30);

                    jl2 = new JLabel("װ�����:");
                    jl2.setFont(FontTools.f5);
                    jl2.setBounds(850, 100, 150, 30);

                    jname2 = new JTextField(20);
                    jname2.setText(r.getObject("װ�����") + "");
                    jname2.setBounds(950, 100, 200, 30);

                    jl3 = new JLabel("װ������:");
                    jl3.setFont(FontTools.f5);
                    jl3.setBounds(450, 150, 150, 30);

                    jname3 = new JTextField(20);
                    jname3.setText(r.getObject("װ������") + "");
                    jname3.setBounds(550, 150, 200, 30);

                    jl4 = new JLabel("װ�����ҵ���:");
                    jl4.setFont(FontTools.f5);
                    jl4.setBounds(810, 150, 200, 30);

                    jname4 = new JTextField(20);
                    jname4.setText(r.getObject("װ�����ҵ���") + "");
                    jname4.setBounds(950, 150, 200, 30);

                    jl5 = new JLabel("������λ:");
                    jl5.setFont(FontTools.f5);
                    jl5.setBounds(450, 200, 150, 30);

                    jname5 = new JTextField(20);
                    jname5.setText(r.getObject("������λ") + "");
                    jname5.setBounds(550, 200, 30, 30);

                    jl6 = new JLabel("װ�����:");
                    jl6.setFont(FontTools.f5);
                    jl6.setBounds(850, 200, 150, 30);

                    jname6 = new JTextField(20);
                    jname6.setBounds(950, 200, 200, 30);

                    jl7 = new JLabel("װ�����:");
                    jl7.setFont(FontTools.f5);
                    jl7.setBounds(450, 250, 150, 30);

                    jname7 = new JTextField(20);
                    jname7.setBounds(550, 250, 200, 30);

                    jl8 = new JLabel("��������:");
                    jl8.setFont(FontTools.f5);
                    jl8.setBounds(850, 250, 150, 30);

                    jname8 = new JTextField(20);
                    jname8.setBounds(950, 250, 30, 30);

                    jl9 = new JLabel("Ӣ������:");
                    jl9.setFont(FontTools.f5);
                    jl9.setBounds(450, 300, 150, 30);

                    jname9 = new JTextField(20);
                    jname9.setBounds(550, 300, 200, 30);

                    jl10 = new JLabel("ԭ������:");
                    jl10.setFont(FontTools.f5);
                    jl10.setBounds(850, 300, 150, 30);

                    jname10 = new JTextField(20);
                    jname10.setBounds(950, 300, 200, 30);

                    jl11 = new JLabel("��������:");
                    jl11.setFont(FontTools.f5);
                    jl11.setBounds(450, 350, 150, 30);

                    jname11 = new JTextField(20);
                    jname11.setBounds(550, 350, 200, 30);

                    jl12 = new JLabel("�������:");
                    jl12.setFont(FontTools.f5);
                    jl12.setBounds(850, 350, 150, 30);

                    jname12 = new JTextField(20);
                    jname12.setBounds(950, 350, 200, 30);

                    jl13 = new JLabel("��������:");
                    jl13.setFont(FontTools.f5);
                    jl13.setBounds(450, 400, 150, 30);

                    jname13 = new JTextField(20);
                    jname13.setBounds(550, 400, 200, 30);

                    jl14 = new JLabel("�������:");
                    jl14.setFont(FontTools.f5);
                    jl14.setBounds(850, 400, 150, 30);

                    jname14 = new JTextField(20);
                    jname14.setBounds(950, 400, 200, 30);

                    jl15 = new JLabel("�������:");
                    jl15.setFont(FontTools.f5);
                    jl15.setBounds(450, 450, 150, 30);

                    jname15 = new JTextField(20);
                    jname15.setBounds(550, 450, 200, 30);

                    jl16 = new JLabel("�������Ĵ���:");
                    jl16.setFont(FontTools.f5);
                    jl16.setBounds(810, 450, 150, 30);

                    jname16 = new JTextField(20);
                    jname16.setBounds(950, 450, 200, 30);

                    jl17 = new JLabel("������ɫ:");
                    jl17.setFont(FontTools.f5);
                    jl17.setBounds(450, 500, 150, 30);

                    jname17 = new JTextField(20);
                    jname17.setBounds(550, 500, 200, 30);

                    jl18 = new JLabel("������ɫ����:");
                    jl18.setFont(FontTools.f5);
                    jl18.setBounds(810, 500, 150, 30);

                    jname18 = new JTextField(20);
                    jname18.setBounds(950, 500, 200, 30);

                    jl19 = new JLabel("����ǰ��ɫ:");
                    jl19.setFont(FontTools.f5);
                    jl19.setBounds(430, 550, 150, 30);

                    jname19 = new JTextField(20);
                    jname19.setBounds(550, 550, 200, 30);

                    jl20 = new JLabel("����ǰ��ɫ����:");
                    jl20.setFont(FontTools.f5);
                    jl20.setBounds(795, 550, 150, 30);

                    jname20 = new JTextField(20);
                    jname20.setBounds(950, 550, 200, 30);

                    jl21 = new JLabel("�����߿�:");
                    jl21.setFont(FontTools.f5);
                    jl21.setBounds(450, 600, 150, 30);

                    jname21 = new JTextField(20);
                    jname21.setBounds(550, 600, 200, 30);

                    jl22 = new JLabel("������:");
                    jl22.setFont(FontTools.f5);
                    jl22.setBounds(850, 600, 150, 30);

                    jname22 = new JTextField(20);
                    jname22.setBounds(950, 600, 200, 30);

                    jl23 = new JLabel("���궨λ����:");
                    jl23.setFont(FontTools.f5);
                    jl23.setBounds(410, 650, 150, 30);

                    jname23 = new JTextField(20);
                    jname23.setBounds(550, 650, 200, 30);

                    jl24 = new JLabel("���귽��:");
                    jl24.setFont(FontTools.f5);
                    jl24.setBounds(850, 650, 150, 30);

                    jname24 = new JTextField(20);
                    jname24.setBounds(950, 650, 200, 30);

                    jl27 = new JLabel("�ڵ��־:");
                    jl27.setFont(FontTools.f5);
                    jl27.setBounds(450, 700, 150, 30);

                    jname27 = new JTextField(20);
                    jname27.setBounds(550, 700, 30, 30);


                    jl25 = new JLabel("����:");
                    jl25.setFont(FontTools.f5);
                    jl25.setBounds(450, 750, 70, 30);

                    are1 = new TextArea();
                    are1.setBounds(520, 750, 320, 200);

                    jl26 = new JLabel("��ע:");
                    jl26.setFont(FontTools.f5);
                    jl26.setBounds(850, 750, 70, 30);

                    are2 = new TextArea();
                    are2.setBounds(920, 750, 320, 200);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                try {
                    //�ر����ݿ�����
                    d.destroy(c);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                w.jp3.removeAll();

                w.jp3.setLayout(null);
                w.jp3.add(jbt1);
                w.jp3.add(jbt2);
                w.jp3.add(jbt3);
                w.jp3.add(jbt4);

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
                w.jp3.add(are1);
                w.jp3.add(jl26);
                w.jp3.add(are2);
                w.jp3.add(jl27);
                w.jp3.add(jname27);
                w.jp3.repaint();
                w.jp3.revalidate();


            }

            //    }

        });


    }


}
