package controller;

import model.OperateLine;
import model.OperateLineImp;
import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.Columns;
import model.entity.TreeNode;
import thread.LoadTableThread;
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @���� ���windows�����е�����ά���е�bdqk ��actionformed�����¼��Ŀ���
 */
public class DataMainTainFirstController {

  //  public JPanel jp6;
    OperateLine oc = null;
    public JButton jb11, jb22, jb33, jb44;//����ά������ ��Ӧ����ɾ�Ĳ�;
    public JTable jTable=null;
    public final JScrollPane[] scrollPane = {null};
    /**
     * @���� �˳�������� ͨ��������˳��������˳�
     * @���� JFrame����
     * @����ֵ null
     * @������ shizhengdong
     * @����ʱ�� 2018/9/27
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
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public void armySituation(final Windows w) {

        //��һ�μ������ڵ� �ӱ����ļ���tree��
        final JTree jt = w.jt11;


        //���ر�����ݴ�������
        final LoadTableThread[] loadTableThread = {new LoadTableThread("����_ͨ��_BDFH", jt, w)};
        loadTableThread[0].start();

        //�������
        w.jp1.removeAll();
        w.jp1.add(jt);
        w.jp1.revalidate();
        w.jp1.repaint();

        //�����ڵ�����¼�����
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                System.out.println("=======����ά��===bdqk====");

                jTable = w.jTable;

                if (jTable != null) {
                    loadTableThread[0] =null;
                    jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
                    //���б���������
                    jTable.addKeyListener(new KeyListener() {

                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                        //���ڲ��Ϸ��������ֹ�༭
                            if (RegExpValidatorUtils.IsIntNumber(e.getKeyChar() + "")) {

                                w.ok = true;
                                System.out.println(e.getKeyChar());
                                //�õ�ѡ�е����е�����ֵ
                                int r = jTable.getSelectedRow();
                                int c = jTable.getSelectedColumn();

                                //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���
                                Object value = jTable.getValueAt(r, c);
                                jTable.repaint();

                                System.out.println("====2==" + r + " " + c + " " + value);
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            w.ok = false;
                        }
                    });
                    scrollPane[0] = new JScrollPane(jTable);
                    scrollPane[0].setViewportView(jTable);

                    try {
                        w.p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
                    } catch (IOException e1) {
                        // TODO �Զ����ɵ� catch ��
                        e1.printStackTrace();
                    }
                    w.jp3Image = new ImagePanel(w.p3Icon);
                    w.jp3Image.setLayout(new BorderLayout());
                    jb11 = new JButton("���");
                    jb11.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.addRowTable(31,object.toString(),"BDFH","�ֵ�_ͨ��_BDFH",w);
                            System.out.println("====add--===");
                            oc = null;

                        }
                    });

                    jb22 = new JButton("ɾ��");
                    jb22.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.deleteRowTable("BDFH","����_ͨ��_BDFH",w);
                            oc = null;
                            System.out.println("====delete--===");

                        }
                    });

                    jb33 = new JButton("�ύ");
                    jb33.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                            if (node == null)
                                return;
                            Object object = node.getUserObject();
                            System.out.println("You have szd chosen:" + object.toString());
                            oc = new OperateLineImp();
                            oc.uploadRowTable(w,"BDFH","����_ͨ��_BDFH",31);
                            oc = null;

                        }
                    });

                    jb44 = new JButton("����");
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
                            oc.withdrawRowTable(31,"BDFH","�ֵ�_ͨ��_BDFH",w);
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
                    w.jp3Image.add(scrollPane[0], BorderLayout.CENTER);
                    w.jp3.add(w.jp3Image);
                    w.jp3.revalidate();
                    w.jp3.repaint();
                }
            }
        });
    }
}
