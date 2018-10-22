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
 * @������ rduan
 * @����ʱ�� 2018/10/17
 * @���� ���windows�����е��ֵ�ά���еĲ��ӷ��ŵ�actionformed�����¼��Ŀ���
 */
public class DictionaryMainTainController {
    public JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19, jl20, jl21, jl22, jl23, jl24, jl25, jl26, jl27, jl28, jl29, jl30, jl31;
    public JTextField jname1, jname2, jname3, jname4, jname5, jname6, jname7, jname8, jname9, jname10, jname11, jname12, jname13, jname14, jname15, jname16, jname17, jname18, jname19, jname20, jname21, jname22, jname23, jname24, jname25, jname26, jname27, jname28, jname29, jname30, jname31;
    public JButton jbt1, jbt2, jbt3, jbt4;
    public TextArea are1, are2;

    OperateLine oc = null;

    /**
     * @���� �˳�������� ͨ��������˳��������˳�
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
     * @���� �Բ��������actionformed��������
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/17
     * @�޸��˺�������Ϣ
     */

    public void armySituation(final Windows w) {

        //���ر�������
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();
        final DictionaryMainTainOperate[] dictionaryMainTainOperate = {null};

        //��һ�μ������ڵ� �ӱ����ļ���tree��
        final JTree jt = w.jt;


        //�������
        w.jp1.removeAll();
        w.jp1.add(jt);
        w.jp1.revalidate();
        w.jp1.repaint();



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
                ResultSet r = d.executeQuery("select * from NSDB.�ֵ�_ͨ��_���ӷ��� where ���ӷ���='" + object.toString() + "'", c);
                try {
                    r.next();
                    System.out.println("=ssss===" + r.getObject("���ӷ���"));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                jbt1 = new JButton("�޸��ύ");
                jbt1.setBounds(700, 30, 70, 30);
                //�ύ��ť�¼�
                jbt1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String id=jname1.getText();
                        String tt=jname3.getText();
                        System.out.println("====�ύ--==="+id);
                        dictionaryMainTainOperate[0] =new DictionaryMainTainOperate1Imp();
                        dictionaryMainTainOperate[0].updateTreeNode(id,tt);
                        JOptionPane.showMessageDialog(w, "�޸� "+id);


                    }
                });
                jbt2 = new JButton("ˢ�����ṹ");
                jbt2.setBounds(770, 30, 70, 30);
                //������ť�¼�
                jbt2.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                                //����ˢ��

                                JOptionPane.showMessageDialog(w, "����ˢ�����ṹ �Ե�");
                                dictionaryMainTainOperate[0] =new DictionaryMainTainOperate1Imp();
                                //dictionaryMainTainOperate[0].updateTreeStructure(w);
                                JOptionPane.showMessageDialog(w, "ˢ�����");

                    }
                });

                jbt3 = new JButton("����");
                jbt3.setBounds(840, 30, 70, 30);
                //�޸İ�ť�¼�
                jbt3.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("====�޸�--===");

                    }
                });

                try {
                    jl1 = new JLabel("��������:");
                    jl1.setFont(FontTools.f5);
                    jl1.setBounds(450, 100, 150, 30);


                    jname1 = new JTextField(r.getObject("��������") + "", 20);

                    jname1.setBounds(550, 100, 200, 30);

                    jl2 = new JLabel("�������:");
                    jl2.setFont(FontTools.f5);
                    jl2.setBounds(850, 100, 150, 30);

                    jname2 = new JTextField(r.getObject("�������") + "", 20);
                    jname2.setBounds(950, 100, 200, 30);

                    jl3 = new JLabel("���Ӽ��:");
                    jl3.setFont(FontTools.f5);
                    jl3.setBounds(450, 150, 150, 30);

                    jname3 = new JTextField(r.getObject("���Ӽ��") + "", 20);
                    jname3.setBounds(550, 150, 200, 30);

                    jl10 = new JLabel("���ӷ���:");
                    jl10.setFont(FontTools.f5);
                    jl10.setBounds(850, 150, 150, 30);

                    jname10 = new JTextField(20);
                    jname10.setText(r.getObject("���ӷ���") + "");
                    jname10.setBounds(950, 150, 200, 30);

                    jl4 = new JLabel("������־:");
                    jl4.setFont(FontTools.f5);
                    jl4.setBounds(640, 350, 200, 30);

                    jname4 = new JTextField(20);
                    jname4.setBounds(740, 350, 30, 30);

                    jl5 = new JLabel("������־:");
                    jl5.setFont(FontTools.f5);
                    jl5.setBounds(830, 250, 150, 30);

                    jname5 = new JTextField(20);
                    jname5.setBounds(930, 250, 30, 30);

                    jl6 = new JLabel("ֱ����־:");
                    jl6.setFont(FontTools.f5);
                    jl6.setBounds(450, 250, 200, 30);

                    jname6 = new JTextField(20);
                    jname6.setBounds(550, 250, 30, 30);

                    jl7 = new JLabel("��Ҫ��־:");
                    jl7.setFont(FontTools.f5);
                    jl7.setBounds(640, 250, 150, 30);

                    jname7 = new JTextField(20);
                    jname7.setBounds(740, 250, 30, 30);

                    jl8 = new JLabel("��ս��־:");
                    jl8.setFont(FontTools.f5);
                    jl8.setBounds(1020, 250, 200, 30);

                    jname8 = new JTextField(20);
                    jname8.setBounds(1120, 250, 30, 30);

                    jl9 = new JLabel("�鱨��־:");
                    jl9.setFont(FontTools.f5);
                    jl9.setBounds(450, 300, 150, 30);

                    jname9 = new JTextField(20);
                    jname9.setBounds(550, 300, 30, 30);

                    jl11 = new JLabel("ͨѶ��־:");
                    jl11.setFont(FontTools.f5);
                    jl11.setBounds(640, 300, 200, 30);

                    jname11 = new JTextField(20);
                    jname11.setBounds(740, 300, 30, 30);

                    jl12 = new JLabel("�Ĳ���־:");
                    jl12.setFont(FontTools.f5);
                    jl12.setBounds(830, 300, 150, 30);

                    jname12 = new JTextField(20);
                    jname12.setBounds(930, 300, 30, 30);

                    jl13 = new JLabel("��ѵ��־:");
                    jl13.setFont(FontTools.f5);
                    jl13.setBounds(1020, 300, 200, 30);

                    jname13 = new JTextField(20);
                    jname13.setBounds(1120, 300, 30, 30);

                    jl14 = new JLabel("�����־:");
                    jl14.setFont(FontTools.f5);
                    jl14.setBounds(450, 350, 150, 30);

                    jname14 = new JTextField(20);
                    jname14.setBounds(550, 350, 30, 30);

                    jl15 = new JLabel("������־:");
                    jl15.setFont(FontTools.f5);
                    jl15.setBounds(830, 350, 150, 30);

                    jname15 = new JTextField(20);
                    jname15.setBounds(930, 350, 30, 30);

                    jl16 = new JLabel("���ڱ�־:");
                    jl16.setFont(FontTools.f5);
                    jl16.setBounds(1020, 350, 200, 30);
                    jname16 = new JTextField(20);
                    jname16.setBounds(1120, 350, 30, 30);

                    jl17 = new JLabel("��װ��־:");
                    jl17.setFont(FontTools.f5);
                    jl17.setBounds(450, 400, 150, 30);

                    jname17 = new JTextField(20);
                    jname17.setBounds(550, 400, 30, 30);

                    jl18 = new JLabel("Ԥ���۱�־:");
                    jl18.setFont(FontTools.f5);
                    jl18.setBounds(640, 400, 200, 30);

                    jname18 = new JTextField(20);
                    jname18.setBounds(740, 400, 30, 30);

                    jl19 = new JLabel("���ñ�־1:");
                    jl19.setFont(FontTools.f5);
                    jl19.setBounds(830, 400, 150, 30);

                    jname19 = new JTextField(20);
                    jname19.setBounds(930, 400, 30, 30);

                    jl20 = new JLabel("���ñ�־2:");
                    jl20.setFont(FontTools.f5);
                    jl20.setBounds(1020, 400, 200, 30);
                    jname20 = new JTextField(20);
                    jname20.setBounds(1120, 400, 30, 30);

                    jl21 = new JLabel("���ñ�־3:");
                    jl21.setFont(FontTools.f5);
                    jl21.setBounds(450, 450, 150, 30);

                    jname21 = new JTextField(20);
                    jname21.setBounds(550, 450, 30, 30);

                    jl22 = new JLabel("���ñ�־4:");
                    jl22.setFont(FontTools.f5);
                    jl22.setBounds(640, 450, 200, 30);

                    jname22 = new JTextField(20);
                    jname22.setBounds(740, 450, 30, 30);

                    jl23 = new JLabel("���ñ�־5:");
                    jl23.setFont(FontTools.f5);
                    jl23.setBounds(830, 450, 150, 30);

                    jname23 = new JTextField(20);
                    jname23.setBounds(930, 450, 30, 30);

                    jl24 = new JLabel("���ӱ�������:");
                    jl24.setFont(FontTools.f5);
                    jl24.setBounds(450, 500, 150, 30);

                    jname24 = new JTextField(20);
                    jname24.setText(r.getObject("���ӱ�������") + "");
                    jname24.setBounds(590, 500, 200, 30);

                    jl25 = new JLabel("���ӱ������:");
                    jl25.setFont(FontTools.f5);
                    jl25.setBounds(850, 500, 150, 30);

                    jname25 = new JTextField(20);
                    jname25.setText(r.getObject("���ӱ������") + "");
                    jname25.setBounds(990, 500, 200, 30);

                    jl26 = new JLabel("���ӱ��Ʒ���:");
                    jl26.setFont(FontTools.f5);
                    jl26.setBounds(450, 550, 150, 30);

                    jname26 = new JTextField(20);
                    jname26.setText(r.getObject("���ӱ��Ʒ���") + "");
                    jname26.setBounds(590, 550, 200, 30);

                    jl27 = new JLabel("���ӱ��Ƽ��:");

                    jl27.setFont(FontTools.f5);
                    jl27.setBounds(850, 550, 150, 30);

                    jname27 = new JTextField(20);
                    jname27.setText(r.getObject("���ӱ��Ƽ��") + "");
                    jname27.setBounds(990, 550, 200, 30);

                    jl28 = new JLabel("���ӻ���:");
                    jl28.setFont(FontTools.f5);
                    jl28.setBounds(450, 600, 150, 30);

                    jname28 = new JTextField(20);
                    jname28.setText(r.getObject("���ӻ���") + "");
                    jname28.setBounds(590, 600, 200, 30);

                    jl29 = new JLabel("�˳����۱�־:");
                    jl29.setFont(FontTools.f5);
                    jl29.setBounds(850, 600, 150, 30);

                    jname29 = new JTextField(20);
                    jname29.setBounds(990, 600, 30, 30);

                    jl30 = new JLabel("����:");
                    jl30.setFont(FontTools.f5);
                    jl30.setBounds(450, 650, 70, 30);

                    are1 = new TextArea();
                    are1.setBounds(520, 650, 320, 200);

                    jl31 = new JLabel("��ע:");
                    jl31.setFont(FontTools.f5);
                    jl31.setBounds(850, 650, 70, 30);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {
                    //�ر����ݿ�����
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
