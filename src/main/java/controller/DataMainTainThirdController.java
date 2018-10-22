package controller;

import model.OperateLine;
import model.OperateLineImp;

import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import model.entity.Columns;
import model.entity.TreeNode;
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
 * @������ rduan
 * @����ʱ�� 2018/10/10
 * @���� ���windows�����е�����ά���е��Ҿ�װ����actionformed�����¼��Ŀ���
 */
public class DataMainTainThirdController {


    OperateLine oc = null;

    /**
     * @���� �˳�������� ͨ��������˳��������˳�
     * @���� JFrame����
     * @����ֵ null
     * @������ rduan
     * @����ʱ�� 2018/10/10
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
     * @����ʱ�� 2018/10/10
     * @�޸��˺�������Ϣ
     */

    public void armySituation(final Windows w) {


        //���ر�������
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();

        CreateTree ct = new CreateTree();
        //��һ�μ������ڵ�

        final JTree jt = w.jt33;


        w.jp1.removeAll();
        w.jp1.repaint();
        w.jp1.add(jt);
        w.jp1.revalidate();


        //�����ڵ�����¼�����
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("=======����ά��===�Ҿ�װ��====");
                d.database = "oracle";
                Connection c = d.getConnection();
                ResultSet r = d.executeQuery("select * from NSDB.����_��ɨ�����ĳ�����", c);
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                if (node == null)
                    return;
                Object object = node.getUserObject();
                //   if (node.isLeaf()) {

                System.out.println("You have chosen:" + object.toString());

                w.p2_jl1 = new JLabel("You have chosen:" + object.toString());

                w.flagObject = object.toString();

                //�����ݿ��и��ݱ�����̬��ȡ�ֶμ�����
                ArrayList<Columns> columnsArrayList = sp.getColumnName("����_��ɨ�����ĳ�����");
                String column[] = new String[columnsArrayList.size()];
                for (int i = 0; i < columnsArrayList.size(); i++) {
                    column[i] = columnsArrayList.get(i).getName();

                }
                HashMap<Integer, String[]> rows = new HashMap<Integer, String[]>();


                int i = 0;
                try {
                    while (r.next()) {


                        String row[] = new String[columnsArrayList.size()];


                        for (int k = 0; k < columnsArrayList.size(); k++) {

                            row[k] = r.getObject(columnsArrayList.get(k).getName()) + "";

                        }
                        System.out.println();
                        rows.put(i, row);
                        i++;

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                w.jTable = (JTable) cb.createTable(column, rows, w);

                w.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ

                w.jTable.addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ

                        if (e.getClickCount() == 1) {


                            // javax.swing.JOptionPane.showMessageDialog(null,info);
                        }
                    }

                });

                w.jTable.addKeyListener(new KeyListener() {


                    @Override
                    public void keyTyped(KeyEvent e) {

                        if (e.getKeyChar() == 'k') {

                            //  System.out.println(e.getKeyChar());

                        }
                        // System.out.println("====1=="+e.getKeyChar());
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                        //�õ�ѡ�е����е�����ֵ

                        int r = w.jTable.getSelectedRow();

                        int c = w.jTable.getSelectedColumn();

                        //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���

                        Object value = w.jTable.getValueAt(r, c);

                        String info = r + "��" + c + "��ֵ : " + value.toString();

                        System.out.println("==info==" + info);
                        if (RegExpValidatorUtils.IsIntNumber(e.getKeyChar() + "")) {

                            w.ok = true;
                            System.out.println(e.getKeyChar());

                            w.jTable.repaint();

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
                w.jb11 = new JButton("���");
                w.jb11.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        oc = new OperateLineImp();
                        oc.addRowTable(w);
                        System.out.println("====add--===");
                        oc = null;

                    }
                });


                w.jb22 = new JButton("ɾ��");
                w.jb22.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        oc = new OperateLineImp();
                        oc.deleteRowTable(w);
                        oc = null;
                        System.out.println("====delete--===");


                    }
                });


                w.jb33 = new JButton("�ύ");
                w.jb33.addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        oc = new OperateLineImp();
                        oc.uploadRowTable(w);
                        oc = null;

                    }
                });

                w.jb44 = new JButton("����");
                w.jb44.addActionListener(w);

                w.jp3.removeAll();
                w.jp6 = new JPanel();
                w.jp6.add(w.jb11);
                w.jp6.add(w.jb22);

                w.jp6.add(w.jb33);
                w.jp6.add(w.jb44);
                w.jp3Image.add(w.jp6, BorderLayout.NORTH);
                w.jp3Image.add(scrollPane, BorderLayout.CENTER);

                w.jp3.add(w.jp3Image);
                w.jp3.repaint();
                w.jp3.revalidate();


            }
            //  }
        });


    }


}
