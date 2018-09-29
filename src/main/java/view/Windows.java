package view;

import controller.DataMainTainController;
import controller.factory.ControllerFactory;
import util.CreateTree;
import util.FontTools;
import util.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
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
    public JMenuItem jmii1, jmii2, jmii3, jmii4, jmii5, jmii6, jmii7;//��Ӧ�Ĳ˵�������
    public ImageIcon jmi1_icon1, jmi2_icon2, jmi3_icon3, jmi4_icon4, jmi5_icon5, jmi6_icon6, jmi7_icon7, jmi8_icon8, jmi9_icon9, jmi10_icon10, jmi11_icon11, jmi12_icon12;//ͼ�����
    public JToolBar jtb; //������
    public static JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;//��������Ӧ�İ�ť;
    public JButton jb11, jb22, jb33, jb44;//����ά������ ��Ӧ����ɾ�Ĳ�;
    public JPanel jp1, jp2, jp3, jp4, jp5, jp6,jp7;
    public JLabel showTime;//��ʾʱ��
    public JLabel p2_jl1, p2_jl2;
    public JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8;
    public JTable jTable;//��
    public DefaultTableModel tableModel;//
    CardLayout myCard; //��Ƭģʽ
    static String flag = "";
    Timer t;//�ɶ�ʱ����Action�¼�
    ControllerFactory cft;//����������

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

                Windows w = new Windows();

            }
        });


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
        jmi2 = new JMenuItem("�л����տ����", jmi2_icon2);
        jmi2.setFont(FontTools.f2);
        jmi3 = new JMenuItem("��½����", jmi3_icon3);
        jmi3.setFont(FontTools.f2);
        jmi4 = new JMenuItem("������", jmi4_icon4);
        jmi4.setFont(FontTools.f2);
        jmi5 = new JMenuItem("�˳�", jmi5_icon5);
        jmi5.setFont(FontTools.f2);
        jmi5.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm1.add(jmi4);
        jm1.add(jmi5);

        jmi6_icon6 = new ImageIcon("src/main/resources/image/toolBar_image/jb4.jpg");

        jm2 = new JMenu("����ά��");
        jm2.setFont(FontTools.f3);
        jmi6 = new JMenu("�� ս");
        jmi6.setFont(FontTools.f2);
        jmii1 = new JMenuItem("�������", jmi6_icon6);
        jmii1.setFont(FontTools.f2);
        jmii1.addActionListener(this);
        jmii2 = new JMenuItem("ս������", jmi6_icon6);
        jmii2.setFont(FontTools.f2);
        jmii2.addActionListener(this);
        jmi6.add(jmii1);
        jmi6.add(jmii2);

        jmi7 = new JMenu("װ ��");
        jmi7.setFont(FontTools.f2);
        jmii7 = new JMenuItem("���װ��", jmi6_icon6);
        jmii7.setFont(FontTools.f2);
        jmi7.add(jmii7);

        jm2.add(jmi6);
        jm2.add(jmi7);

        jmi7_icon7 = new ImageIcon("src/main/resources/image/toolBar_image/jb6.jpg");
        jm3 = new JMenu("�ֵ�ά��");
        jm3.setFont(FontTools.f3);
        jmi7 = new JMenu("�����ֵ�ά��");
        jmi7.setFont(FontTools.f2);
        jmii3 = new JMenuItem("��������", jmi7_icon7);
        jmii3.addActionListener(this);
        jmii3.setFont(FontTools.f2);
        jmii4 = new JMenuItem("�Ҿ�װ��", jmi7_icon7);
        jmii4.addActionListener(this);
        jmii4.setFont(FontTools.f2);
        jmii5 = new JMenuItem("���װ��", jmi7_icon7);
        jmii5.addActionListener(this);
        jmii5.setFont(FontTools.f2);
        jmii6 = new JMenuItem("ս������", jmi7_icon7);
        jmii6.addActionListener(this);
        jmii6.setFont(FontTools.f2);

        jmi7.add(jmii3);
        jmi7.add(jmii4);
        jmi7.add(jmii5);
        jmi7.add(jmii6);

        jm3.add(jmi7);

        jmi8_icon8 = new ImageIcon("src/main/resources/image/toolBar_image/jb5.jpg");
        jm4 = new JMenu("����ͳ��");
        jm4.setFont(FontTools.f3);
        jmi8 = new JMenuItem("���񱨱�", jmi8_icon8);
        jmi8.setFont(FontTools.f2);
        jm4.add(jmi8);


        jmi9_icon9 = new ImageIcon("src/main/resources/image/toolBar_image/jb7.jpg");
        jm5 = new JMenu("�ɱ����ⷿ");
        jm5.setFont(FontTools.f3);
        jmi9 = new JMenuItem("�ɱ�����", jmi9_icon9);
        jmi9.setFont(FontTools.f2);
        jm5.add(jmi9);

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
        jmb.add(jm4);
        jmb.add(jm5);
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
        p1_bgImage.setLayout(new GridLayout(8, 1));
        jp1.add(p1_bgImage);

        //jp4,jp2,jp3,jp6
        myCard = new CardLayout();
        jp4 = new JPanel(new BorderLayout());
        jp2 = new JPanel(new CardLayout());
        p2_jl1 = new JLabel(new ImageIcon("src/main/resources/image/center_image/jp2_left.jpg"));
        p2_jl1.addMouseListener(this);
        //ͼ���л�
        p2_jl1.addMouseListener(this);
        p2_jl2 = new JLabel(new ImageIcon("src/main/resources/image/center_image/jp2_right.jpg"));
        p2_jl2.addMouseListener(this);
        jp2.add(p2_jl1, "0");
        jp2.add(p2_jl2, "1");

        jp3 = new JPanel(myCard);

        //�ȸ�jp3���������濨Ƭ
        try {
            p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
        } catch (IOException e1) {
            // TODO �Զ����ɵ� catch ��
            e1.printStackTrace();
        }
        jp3Image = new ImagePanel(p3Icon);
        jp3Image.setLayout(new BorderLayout());


        jp3.add(jp3Image);


        jp4.add(jp2, "West");
        jp4.add(jp3, "Center");
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1, jp4);
        jsp.setDividerLocation(150);
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
        cft=new ControllerFactory();

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO �Զ����ɵķ������
        this.showTime.setText("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString() + "   ");


        if (e.getActionCommand() == "�˳�") {


            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.exit(this);

        }

        //�������
        if (e.getActionCommand() == "�������") {

           DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
           c.armySituation(this);
        }
        if(e.getActionCommand()=="���"){

            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.addDeleteTable(0,this);

            System.out.println("====add--===");
        }
        if(e.getActionCommand()=="ɾ��"){


            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.addDeleteTable(1,this);

            System.out.println("====delete--===");
        }
        if(e.getActionCommand()=="�ύ"){

//            int selectedRow = jTable.getSelectedRow();//���ѡ���е�����??
//
//            for(int n= 0; n < 4; n ++){
//               //object.add(jTable.getVauleAt(index,n));
//                System.out.println(selectedRow +"====ok--==="+jTable.getValueAt(selectedRow ,n));
//            }
//
//            System.out.println("====ok--===");
        }

        //�������
        if (e.getActionCommand() == "��������") {


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
