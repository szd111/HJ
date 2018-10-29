package controller;

import model.OperateLine;
import model.OperateLineImp;
import thread.LoadTableThread;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * @������ rduan
 * @����ʱ�� 2018/10/10
 * @���� ���windows�����е�����ά���е�wjzb ��actionformed�����¼��Ŀ���
 */
public class DataMainTainFourthController {


    OperateLine oc = null;
    public JButton jb11, jb22, jb33, jb44;//����ά������ ��Ӧ����ɾ�Ĳ�;
    public JTable jTable = null;

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
     * @���� ��wjzb ��actionformed��������
     * @����
     * @����ֵ
     * @������ rduan
     * @����ʱ�� 2018/10/10
     * @�޸��˺�������Ϣ
     */
    public void armySituation(final Windows w) {

        //��һ�μ������ڵ� �ӱ����ļ���tree��
        final JTree jt = w.jt22;

        //���б�����ݵļ���
        final LoadTableThread[] loadTableThread = {new LoadTableThread("�ֵ�_ͨ��_ZB", jt, w)};
        loadTableThread[0].start();

        //�������
        w.jp1.removeAll();
        w.jp1.repaint();
        w.jp1.add(jt);
        w.jp1.revalidate();

        //�����ڵ�����¼�����
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                System.out.println("=======����ά��===zb====");
                jTable = w.jTable;
                JScrollPane scrollPane = null;
                if (jTable != null) {
                    loadTableThread[0] = null;
                    jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
                    jTable.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                            if (RegExpValidatorUtils.IsIntNumber(e.getKeyChar() + "")) {

                                w.ok = true;
                                System.out.println(e.getKeyChar());
                                w.jTable.repaint();

                            }

                            System.out.println("====2==" + e.getKeyChar());
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            w.ok = false;
                        }
                    });

                    scrollPane = new JScrollPane(jTable);
                    scrollPane.setViewportView(jTable);

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
                            oc.addRowTable(27, object.toString(), "JLDW", "�ֵ�_ͨ��_ZB", w);
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
                            oc.deleteRowTable("JLDW", "����_ͨ��_ZB", w);
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
                            oc.uploadRowTable(w, "JLDW", "����_ͨ��_ZB", 27);
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
                            oc.withdrawRowTable(27, "JLDW", "�ֵ�_ͨ��_ZB", w);
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
                    w.jp3.revalidate();
                    w.jp3.repaint();
                }
            }
        });
    }

}
