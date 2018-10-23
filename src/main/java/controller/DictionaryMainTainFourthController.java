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
 * @���� ���windows�����е��ֵ�ά���е� ս�����̵�actionformed�����¼��Ŀ���
 */
public class DictionaryMainTainFourthController {
    public JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19, jl20, jl21, jl22, jl23, jl24, jl25, jl26, jl27, jl28, jl29, jl30, jl31;
    public JTextField jname1, jname2, jname3, jname4, jname5, jname6, jname7, jname8, jname9, jname10, jname11, jname12, jname13, jname14, jname15, jname16, jname17, jname18, jname19, jname20, jname21, jname22, jname23, jname24, jname25, jname26, jname27, jname28, jname29, jname30, jname31;
    public JButton jbt1, jbt2, jbt3, jbt4;
    public TextArea are1, are2;

    OperateLine oc = null;

    /**
     * @���� �˳�������� ͨ��������˳��������˳� ս�����̵�ά��
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
     * @���� ��ս�����̵�actionformed��������
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
        final JTree jt = w.jt4;

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
                ResultSet r = d.executeQuery("select * from scott.�ֵ�_ͨ��_ս������ where ս����������='" + object.toString() + "'", c);
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
                    jl1 = new JLabel("ս����������:");
                    jl1.setFont(FontTools.f5);
                    jl1.setBounds(410, 100, 150, 30);

                    jname1 = new JTextField(20);

                    jname1.setText(r.getObject("ս����������") + "");

                    jname1.setBounds(550, 100, 200, 30);

                    jl2 = new JLabel("ս���������:");
                    jl2.setFont(FontTools.f5);
                    jl2.setBounds(810, 100, 150, 30);

                    jname2 = new JTextField(20);
                    jname2.setText(r.getObject("ս���������") + "");
                    jname2.setBounds(950, 100, 200, 30);

                    jl3 = new JLabel("ս�����̴���:");
                    jl3.setFont(FontTools.f5);
                    jl3.setBounds(410, 150, 150, 30);

                    jname3 = new JTextField(20);
                    jname3.setText(r.getObject("ս�����̴���") + "");
                    jname3.setBounds(550, 150, 200, 30);

                    jl4 = new JLabel("ս�����̼��:");
                    jl4.setFont(FontTools.f5);
                    jl4.setBounds(810, 150, 200, 30);

                    jname4 = new JTextField(20);
                    jname4.setText(r.getObject("ս�����̼��") + "");
                    jname4.setBounds(950, 150, 200, 30);

                    jl5 = new JLabel("ս���������:");
                    jl5.setFont(FontTools.f5);
                    jl5.setBounds(410, 200, 150, 30);

                    jname5 = new JTextField(20);
                    jname5.setText(r.getObject("ս���������") + "");
                    jname5.setBounds(550, 200, 200, 30);

                    jl6 = new JLabel("ս����������:");
                    jl6.setFont(FontTools.f5);
                    jl6.setBounds(810, 200, 150, 30);

                    jname6 = new JTextField(20);
                    jname6.setText(r.getObject("ս����������") + "");
                    jname6.setBounds(950, 200, 200, 30);


                    jl7 = new JLabel("����:");
                    jl7.setFont(FontTools.f5);
                    jl7.setBounds(410, 250, 70, 30);

                    are1 = new TextArea();
                    are1.setBounds(480, 250, 320, 200);

                    jl8 = new JLabel("��ע:");
                    jl8.setFont(FontTools.f5);
                    jl8.setBounds(840, 250, 70, 30);

                    are2 = new TextArea();
                    are2.setBounds(910, 250, 320, 200);

                    jl9 = new JLabel("���ñ�־1:");
                    jl9.setFont(FontTools.f5);
                    jl9.setBounds(410, 470, 150, 30);

                    jname7 = new JTextField(20);
                    jname7.setText(r.getObject("���ñ�־1") + "");
                    jname7.setBounds(520, 470, 30, 30);


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
              //  w.jp3.repaint();
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
                w.jp3.add(are1);
                w.jp3.add(jl8);
                w.jp3.add(are2);
                w.jp3.add(jl9);
                w.jp3.add(jname7);

                w.jp3.repaint();
                w.jp3.revalidate();


            }

            //    }

        });


    }


}
