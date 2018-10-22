package controller;

import model.OperateLine;
import model.OperateLineImp;
import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.Columns;
import model.entity.TreeNode;
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
 * @���� ���windows�����е�����ά���еĲ��������actionformed�����¼��Ŀ���
 */
public class DataMainTainFirstController {

  //  public JPanel jp6;
    OperateLine oc = null;
    public JButton jb11, jb22, jb33, jb44;//����ά������ ��Ӧ����ɾ�Ĳ�;


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


        //���ر�������
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp=new SelectTableImp();


        //��һ�μ������ڵ� �ӱ����ļ���tree��

        //CreateTree.getJTreeStatic();
        final JTree jt = w.jt11;


        //�������
        w.jp1.removeAll();
        w.jp1.add(jt);
        w.jp1.revalidate();
        w.jp1.repaint();



        //�����ڵ�����¼�����
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                System.out.println("=======����ά��===�������====");

                 d.database="oracle";
                 Connection c = d.getConnection();
                 ResultSet r = d.executeQuery("select * from NSDB.�ֵ�_ͨ��_ս������", c);
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();
                //   if (node.isLeaf()) {

                System.out.println("You have chosen:" + object.toString());

                w.p2_jl1 = new JLabel("You have chosen:" + object.toString());

                w.flagObject = object.toString();

                //�����ݿ��и��ݱ�����̬��ȡ�ֶμ�����
                ArrayList<Columns> columnsArrayList=sp.getColumnName("�ֵ�_ͨ��_ս������");
                String column[] =new String[columnsArrayList.size()];
                for(int i=0;i<columnsArrayList.size();i++){
                    column[i]=columnsArrayList.get(i).getName();

                }

                HashMap<Integer, String[]> rows = new HashMap<Integer, String[]>();



                    int i=0;
                    try {
                        while(r.next()){


                            String row[]=new String[columnsArrayList.size()];


                            for(int k=0;k<columnsArrayList.size();k++){

                                row[k]=r.getObject(columnsArrayList.get(k).getName())+"";

                            }
                            System.out.println();
                            rows.put(i,row);

                            i++;

                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                w.jTable = (JTable) cb.createTable(column, rows, w);

                w.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ

                w.jTable.addKeyListener(new KeyListener() {


                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                        if (RegExpValidatorUtils.IsIntNumber(e.getKeyChar() + "")) {

                            w.ok = true;
                            System.out.println(e.getKeyChar());
                            //�õ�ѡ�е����е�����ֵ

                            int r = w.jTable.getSelectedRow();

                            int c = w.jTable.getSelectedColumn();

                            //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���

                            Object value = w.jTable.getValueAt(r, c);
                            w.jTable.repaint();

                            System.out.println("====2==" + r + " " + c + " " + value);

                        }

                        System.out.println("====2==" + e.getKeyChar());
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        //   System.out.println("====3=="+e.getKeyChar());
                        w.ok = false;
                    }
                });

                JScrollPane scrollPane = new JScrollPane(w.jTable);
                scrollPane.setViewportView(w.jTable);

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

                        oc = new OperateLineImp();
                        oc.addRowTable(w);
                        System.out.println("====add--===");
                        oc = null;

                    }
                });

                jb22 = new JButton("ɾ��");
                jb22.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        oc = new OperateLineImp();
                        oc.deleteRowTable(w);
                        oc = null;
                        System.out.println("====delete--===");


                    }
                });


                jb33 = new JButton("�ύ");
                jb33.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        oc = new OperateLineImp();
                        oc.uploadRowTable(w);
                        oc = null;

                    }
                });

                jb44 = new JButton("����");
                jb44.addActionListener(w);

                w.jp3.removeAll();

                w.jp6 = new JPanel();
                w.jp6.add(jb11);
                w.jp6.add(jb22);

                w.jp6.add(jb33);
                w.jp6.add(jb44);
                w.jp3Image.add(w.jp6, BorderLayout.NORTH);
                w.jp3Image.add(scrollPane, BorderLayout.CENTER);
                w.jp3.add(w.jp3Image);

                w.jp3.revalidate();
                w.jp3.repaint();



            }



        });


    }


}
