package view;

import controller.*;

import controller.factory.ControllerFactory;


import model.SelectTableImp;
import model.database.DatabaseDaoImp;
import thread.LoadDataThread;
import util.CreateTable;
import util.FontTools;
import util.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @������ shizhendong
 * @����ʱ�� 2018.9.25
 * @���� ����������������ά�����ֵ�ά��
 */


public class Windows extends JFrame implements ActionListener, MouseListener {

    //������Ҫ�����
    public Image titleIcon, timeBg, p1_bg, p3Icon, chart;  //ͼƬ����
    public ImagePanel p1_bgImage, jp3Image, ct;          //ͼƬ���
    public JMenuBar jmb;                              //�˵���
    public JSplitPane jsp;                           //�ع�
    public JMenu jm1, jm2, jm3, jm4, jm5, jm6, jmi6, jm7, jmi7;           //�˵�һ��
    public JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi8, jmi9, jmi10, jmi11, jmi12;//��Ӧ�Ĳ˵�������

    public JMenuItem jmii1, jmii2, jmii3, jmii4, jmii5, jmii6, jmii7, jmii8;//��Ӧ�Ĳ˵�������

    public ImageIcon jmi1_icon1, jmi2_icon2, jmi3_icon3, jmi4_icon4, jmi5_icon5, jmi6_icon6, jmi7_icon7, jmi8_icon8, jmi9_icon9, jmi10_icon10, jmi11_icon11, jmi12_icon12;//ͼ�����
    public JToolBar jtb; //������
    public static JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;//��������Ӧ�İ�ť;
    public JButton jb11, jb22, jb33, jb44;//����ά������ ��Ӧ����ɾ�Ĳ�;
    public JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
    public JLabel showTime;//��ʾʱ��
    public JLabel p2_jl1, p2_jl2;
    public JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8;

    public JTable jTable;//��
    public DefaultTableModel tableModel;//
    public JScrollPane jp11scrollPane;
    CardLayout myCard; //��Ƭģʽ
    public static String flagObject = "";//ָ�����ݿ�Ĳ�������
    Timer t;//�ɶ�ʱ����Action�¼�
    ControllerFactory cft;//����������
    public static boolean ok = false;//��Ԫ���Ƿ�ɱ༭
    public JTree jt, jt2, jt3, jt4;//�ֵ�ά�� ���νṹ
    public JTree jt11, jt22, jt33, jt44;//����ά�� ���νṹ

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������


        System.out.println("yark man");

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                //�˴�����Ƥ��������

                try {

                    System.out.println("yark man222");

                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }

                // ��������������������Э��������������������DefaultLookAndFeelDecorated����Ϊtrue��

                JFrame.setDefaultLookAndFeelDecorated(true);

                JDialog.setDefaultLookAndFeelDecorated(true);


            }
        });


    }


    //�������Խṹ�ӱ����ļ�tree
    public void initTree(JTree jt, JTree jt2, JTree jt3, JTree jt4, JTree jt11, JTree jt22, JTree jt33, JTree jt44) {

        //���ر�������
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();

        //��һ�μ������ڵ�tree1 �ӱ����ļ���tree��
        this.jt = jt;
        this.jt2 = jt2;
        this.jt3 = jt3;
        this.jt4 = jt4;
        this.jt11 = jt11;
        this.jt22 = jt22;
        this.jt33 = jt33;
        this.jt44 = jt44;

    }

    //��ʼ���˵�
    public void initMenu() {
        //һ���˵�

        jmi1_icon1 = new ImageIcon("src/main/resources/image/jm1_icon1.jpg");
        jmi2_icon2 = new ImageIcon("src/main/resources/image/jm1_icon2.jpg");
        jmi3_icon3 = new ImageIcon("src/main/resources/image/jm1_icon3.jpg");
        jmi4_icon4 = new ImageIcon("src/main/resources/image/jm1_icon4.jpg");
        jmi5_icon5 = new ImageIcon("src/main/resources/image/jm1_icon5.jpg");
        jm1 = new JMenu("ϵͳ����");
        jm1.setFont(FontTools.f3);
        //����������˵�
        jmi1 = new JMenuItem("�л��û�", jmi1_icon1);
        jmi1.setFont(FontTools.f2);
        jmi5 = new JMenuItem("�˳�", jmi5_icon5);
        jmi5.setFont(FontTools.f2);
        jmi5.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi5);

        jmi6_icon6 = new ImageIcon("src/main/resources/image/toolBar_image/jb4.jpg");

        jm2 = new JMenu("����ά��");
        jm2.setFont(FontTools.f3);
        jmi6 = new JMenu("zz");
        jmi6.setFont(FontTools.f2);
        jmii1 = new JMenuItem("bdqk", jmi6_icon6);
        jmii1.setFont(FontTools.f2);
        jmii1.addActionListener(this);
        jmii2 = new JMenuItem("zbgc", jmi6_icon6);
        jmii2.setFont(FontTools.f2);
        jmii2.addActionListener(this);
        jmi6.add(jmii1);
        jmi6.add(jmii2);

        jmi7 = new JMenu("zb");
        jmi7.setFont(FontTools.f2);
        jmii7 = new JMenuItem("wjzb2", jmi6_icon6);
        jmii7.setFont(FontTools.f2);

        jmii7.addActionListener(this);
        jmii8 = new JMenuItem("wjzb", jmi6_icon6);
        jmii8.setFont(FontTools.f2);
        jmii8.addActionListener(this);

        jmi7.add(jmii7);
        jmi7.add(jmii8);

        jm2.add(jmi6);
        jm2.add(jmi7);

        jmi7_icon7 = new ImageIcon("src/main/resources/image/toolBar_image/jb6.jpg");
        jm3 = new JMenu("�ֵ�ά��");
        jm3.setFont(FontTools.f3);
        jmi7 = new JMenu("�����ֵ�ά��");
        jmi7.setFont(FontTools.f2);
        jmii3 = new JMenuItem("bdxx ", jmi7_icon7);
        jmii3.addActionListener(this);
        jmii3.setFont(FontTools.f2);
        jmii4 = new JMenuItem("wjzb ", jmi7_icon7);
        jmii4.addActionListener(this);
        jmii4.setFont(FontTools.f2);
        jmii5 = new JMenuItem("wjzb2 ", jmi7_icon7);
        jmii5.addActionListener(this);
        jmii5.setFont(FontTools.f2);
        jmii6 = new JMenuItem("zbgc ", jmi7_icon7);
        jmii6.addActionListener(this);
        jmii6.setFont(FontTools.f2);

        jmi7.add(jmii3);
        jmi7.add(jmii4);
        jmi7.add(jmii5);
        jmi7.add(jmii6);

        jm3.add(jmi7);

        jmi10_icon10 = new ImageIcon("src/main/resources/image/toolBar_image/jb9.jpg");
        jmi11_icon11 = new ImageIcon("src/main/resources/image/toolBar_image/jb10.jpg");
        jmi12_icon12 = new ImageIcon("src/main/resources/image/toolBar_image/jb8.jpg");
        jm6 = new JMenu("����");
        jm6.setFont(FontTools.f3);
        jmi10 = new JMenuItem("��������", jmi10_icon10);
        jmi10.setFont(FontTools.f2);
        jmi11 = new JMenuItem("�ı�����", jmi11_icon11);
        jmi11.setFont(FontTools.f2);
        jmi12 = new JMenuItem("��������", jmi12_icon12);
        jmi12.setFont(FontTools.f2);
        jmi10.setFont(FontTools.f2);
        jm6.add(jmi10);
        jm6.add(jmi11);
        jm6.add(jmi12);

        jm6.add(jmi10);


        jmb = new JMenuBar();
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        jmb.add(jm6);
        this.setJMenuBar(jmb);
    }

    //��ʼ��������
    public void initToolBar() {
        jtb = new JToolBar();
        jtb.setFloatable(false);
        jb1 = new JButton(new ImageIcon("src/main/resources/image/jm1_icon1.jpg"));
        jb2 = new JButton(new ImageIcon("src/main/resources/image/jm1_icon2.jpg"));
        jb3 = new JButton(new ImageIcon("src/main/resources/image/jm1_icon3.jpg"));
        jb4 = new JButton(new ImageIcon("src/main/resources/image/jm1_icon4.jpg"));
        jb5 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb5.jpg"));
        jb6 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb6.jpg"));
        jb7 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb7.jpg"));
        jb8 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb8.jpg"));
        jb9 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb9.jpg"));
        jb10 = new JButton(new ImageIcon("src/main/resources/image/toolBar_image/jb10.jpg"));
        jtb.add(jb1);
        jtb.add(jb2);
        jtb.add(jb3);
        jtb.add(jb4);
        jtb.add(jb5);
        jtb.add(jb6);
        jtb.add(jb7);
        jtb.add(jb8);
        jtb.add(jb9);
        jtb.add(jb10);

    }


    //��ʼ���������ģ�����Ŀ¼����ʽ���ұ�չ�ֵ����ݽ��к�Ӧ
    public void initCenter(String flag) {

        //jp1
        jp1 = new JPanel(new BorderLayout());
        try {
            p1_bg = ImageIO.read(new File("src/main/resources/image/center_image/jp1_bg.jpg"));
        } catch (IOException e1) {
            // TODO �Զ����ɵ� catch ��
            e1.printStackTrace();
        }
        Cursor myCursor = new Cursor(HAND_CURSOR);
        p1_bgImage = new ImagePanel(p1_bg);

        p1_bgImage.setLayout(new GridLayout(8, 13));

        //����ߵ����νṹ����������Ϊ�ɹ���
        JScrollPane jp1scrollPane = new JScrollPane(jp1);
        jp1scrollPane.setViewportView(jp1);

        jp1scrollPane.add(p1_bgImage);


        jp3 = new JPanel(new BorderLayout());

        //�ȸ�jp3���������濨Ƭ
        try {
            p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
        } catch (IOException e1) {
            // TODO �Զ����ɵ� catch ��
            e1.printStackTrace();
        }
        jp3Image = new ImagePanel(p3Icon);
        jp3Image.setLayout(new BorderLayout());
        jp3.setPreferredSize(new Dimension(1500, 1000));
        jp11scrollPane = new JScrollPane(jp3);
        jp11scrollPane.setViewportView(jp3);

        jp11scrollPane.add(jp3Image);
        jp11scrollPane.setBounds(10, 10, 1000, 700);
        // jp3.add(jp3Image);

        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1scrollPane, jp11scrollPane);
        jsp.setDividerLocation(300);

        jsp.setDividerSize(0);


    }

    //״̬��
    public void initEnd() {
        jp5 = new JPanel(new BorderLayout());
        t = new Timer(1000, this);//ÿ��һ�봥��ActonEvent
        showTime = new JLabel("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString() + "   ");
        showTime.setFont(FontTools.f1);

        t.start();
        try {
            timeBg = ImageIO.read(new File("src/main/resources/image/time_bg.jpg"));
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        ImagePanel ip1 = new ImagePanel(timeBg);
        ip1.setLayout(new BorderLayout());
        ip1.add(showTime, "East");
        jp5.add(ip1);
    }

    public Windows() {

        try {
            titleIcon = ImageIO.read(new File("src/main/resources/image/title.gif"));
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        cft = new ControllerFactory();

        //���νṹ
        this.initTree(LoadDataThread.jt, LoadDataThread.jt2, LoadDataThread.jt3, LoadDataThread.jt4,
                LoadDataThread.jt11, LoadDataThread.jt22, LoadDataThread.jt33, LoadDataThread.jt44);

        //�˵�
        this.initMenu();

        //������
        this.initToolBar();

        //�м�
        this.initCenter("1");

        //״̬��
        this.initEnd();


        Container ct = this.getContentPane();
        ct.add(jtb, "North");
        ct.add(jp5, "South");
        ct.add(jsp, "Center");


        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width - 400, height - 240);
        this.setIconImage(titleIcon);
        this.setTitle("HJϵͳ");
        this.setVisible(true);
        this.setBounds(150, 150, width - 400, height - 240);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO �Զ����ɵķ������
        this.showTime.setText("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString() + "   ");
        if (e.getActionCommand() == "�˳�") {

            DataMainTainFirstController c = (DataMainTainFirstController) cft.getConTrollers("DataMainTain");
            c.exit(this);

        }

        //bdqk
        if (e.getActionCommand() == "bdqk") {

            DataMainTainFirstController c = (DataMainTainFirstController) cft.getConTrollers("DataMainTain");

            c.armySituation(this);

        }
        //zbgc
        if (e.getActionCommand() == "zbgc") {

            DataMainTainSecondController c = (DataMainTainSecondController) cft.getConTrollers("DataMainTainSecond");

            c.armySituation(this);

        }
        //wjzb
        if (e.getActionCommand() == "wjzb2") {
            DataMainTainThirdController c = (DataMainTainThirdController) cft.getConTrollers("DataMainTainThird");

            System.out.println("sdsdsd");
            c.armySituation(this);


        }
        //zb
        if (e.getActionCommand() == "wjzb") {
            DataMainTainFourthController c = (DataMainTainFourthController) cft.getConTrollers("DataMainTainFourth");
            c.armySituation(this);

        }


        //bdqkά��
        if (e.getActionCommand() == "bdxx ") {

            //java.awt.EventQueue.invokeLater(new Runnable() {

            //    public void run() {

            //�˴�����Ƥ��������
            DictionaryMainTainController c = (DictionaryMainTainController) cft.getConTrollers("DictionaryMainTain");

            c.armySituation(this);

            //   }
            // });


        }
        //zbgcά��
        if (e.getActionCommand() == "zbgc ") {

            DictionaryMainTainFourthController c = (DictionaryMainTainFourthController) cft.getConTrollers("DictionaryMainTainTFourth");

            c.armySituation(this);

        }
        //wjzbά��
        if (e.getActionCommand() == "wjzb ") {

            DictionaryMainTainSecondController c = (DictionaryMainTainSecondController) cft.getConTrollers("DictionaryMainTainSecond");

            c.armySituation(this);

        }
        //wjzb2ά��
        if (e.getActionCommand() == "wjzb2 ") {

            DictionaryMainTainThirdController c = (DictionaryMainTainThirdController) cft.getConTrollers("DictionaryMainTainThird");
            c.armySituation(this);

        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO �Զ����ɵķ������
        if (arg0.getSource() == p1_jl2) {
            this.myCard.show(jp3, "1");
        } else if (arg0.getSource() == p1_jl3) {
            this.myCard.show(jp3, "2");
        } else if (arg0.getSource() == p1_jl4) {
            this.myCard.show(jp3, "3");
        } else if (arg0.getSource() == p1_jl5) {
            this.myCard.show(jp3, "4");
        } else if (arg0.getSource() == p1_jl6) {
            this.myCard.show(jp3, "5");
        } else if (arg0.getSource() == p1_jl7) {
            this.myCard.show(jp3, "6");
        } else if (arg0.getSource() == p1_jl8) {
            //MediaHelp mh=new MediaHelp();
        } else if (arg0.getSource() == p2_jl1) {
            this.jsp.setDividerLocation(0);

        } else if (arg0.getSource() == p2_jl2) {
            this.jsp.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width);
        } else if (arg0.getSource() == jmi5) {

            System.out.println("ssssss");
            this.dispose();
            UserLogin n = new UserLogin();
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO �Զ����ɵķ������
        if (arg0.getSource() == p1_jl2) {
            this.p1_jl2.setEnabled(true);
        } else if (arg0.getSource() == p1_jl3) {
            this.p1_jl3.setEnabled(true);
        } else if (arg0.getSource() == p1_jl4) {
            this.p1_jl4.setEnabled(true);
        } else if (arg0.getSource() == p1_jl5) {
            this.p1_jl5.setEnabled(true);
        } else if (arg0.getSource() == p1_jl6) {
            this.p1_jl6.setEnabled(true);
        } else if (arg0.getSource() == p1_jl7) {
            this.p1_jl7.setEnabled(true);
        } else if (arg0.getSource() == p1_jl8) {
            this.p1_jl8.setEnabled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO �Զ����ɵķ������
        if (arg0.getSource() == p1_jl2) {
            this.p1_jl2.setEnabled(false);
        } else if (arg0.getSource() == p1_jl3) {
            this.p1_jl3.setEnabled(false);
        } else if (arg0.getSource() == p1_jl4) {
            this.p1_jl4.setEnabled(false);
        } else if (arg0.getSource() == p1_jl5) {
            this.p1_jl5.setEnabled(false);
        } else if (arg0.getSource() == p1_jl6) {
            this.p1_jl6.setEnabled(false);
        } else if (arg0.getSource() == p1_jl7) {
            this.p1_jl7.setEnabled(false);
        } else if (arg0.getSource() == p1_jl8) {
            this.p1_jl8.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO �Զ����ɵķ������

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO �Զ����ɵķ������

    }

}
