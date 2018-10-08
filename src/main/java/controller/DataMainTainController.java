package controller;

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
import java.io.File;
import java.io.IOException;

import java.util.HashMap;


/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @���� ���windows�����е�����ά���е�actionformed�����¼��Ŀ���
 */
public class DataMainTainController {


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


        final CreateTable cb = new CreateTable();


        CreateTree ct = new CreateTree();

        final JTree jt = ct.getJTree();


        w.jp1.removeAll();
        w.jp1.repaint();
        w.jp1.add(jt);
        w.jp1.revalidate();


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


                    String column[]={"id","name","age","sex"};

                    HashMap<Integer,String[]> rows=new HashMap<Integer,String[]>();


                    rows.put(0,new String[]{"1","szd","11","boy"});
                    rows.put(1,new String[]{"2","jetli","21","boy"});
                    rows.put(2,new String[]{"3","tom","31","boy"});
                    rows.put(3,new String[]{"4","jane","1","boy"});


                    w.jTable = (JTable) cb.createTable(column, rows,w);

                    w.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
                    JScrollPane scrollPane = new JScrollPane(w.jTable);
                    scrollPane.setViewportView(w.jTable);


                    w.jp3.removeAll();
                    w.jp3.repaint();
                    try {
                        w.p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
                    } catch (IOException e1) {
                        // TODO �Զ����ɵ� catch ��
                        e1.printStackTrace();
                    }
                    w.jp3Image = new ImagePanel(w.p3Icon);
                    w.jp3Image.setLayout(new BorderLayout());
                    w.jb11 = new JButton("���");
                    w.jb11.addActionListener(w);
                    w.jb22 = new JButton("ɾ��");

                    w.jb22.addActionListener(w);
                    w.jb33 = new JButton("�ύ");
                    w.jb33.addActionListener(w);
                    w.jb44 = new JButton("����");
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


    /**
     * @���� �Բ�������е���� ɾ��������Ӧ
     * @���� flag 0����� 1��ɾ��
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/9/28
     * @�޸��˺�������Ϣ
     */

    public void addDeleteTable(int flag, final Windows w) {
        CreateTable cb = new CreateTable();

        if (flag == 0) {
            cb.updateTable(1, w);
        } else if (flag == 1) {

            int selectedRow = w.jTable.getSelectedRow();//���ѡ���е�����??


            // System.out.println("====selectedRow--==="+getname);
            if (selectedRow != -1)//����ѡ����??
            {
                w.tableModel.removeRow(selectedRow);//ɾ����??
            }
            else{

                JOptionPane.showMessageDialog(w, "�Բ�����ѡ��һ��ɾ����");
            }

        }


    }
}
