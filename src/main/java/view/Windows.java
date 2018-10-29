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
 * @创建人 shizhendong
 * @创建时间 2018.9.25
 * @描述 主窗体界面包括数据维护和字典维护
 */


public class Windows extends JFrame implements ActionListener, MouseListener {

    //定义需要的组件
    public Image titleIcon, timeBg, p1_bg, p3Icon, chart;  //图片对象
    public ImagePanel p1_bgImage, jp3Image, ct;          //图片面板
    public JMenuBar jmb;                              //菜单栏
    public JSplitPane jsp;                           //回滚
    public JMenu jm1, jm2, jm3, jm4, jm5, jm6, jmi6, jm7, jmi7;           //菜单一级
    public JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi8, jmi9, jmi10, jmi11, jmi12;//对应的菜单栏二级

    public JMenuItem jmii1, jmii2, jmii3, jmii4, jmii5, jmii6, jmii7, jmii8;//对应的菜单栏三级

    public ImageIcon jmi1_icon1, jmi2_icon2, jmi3_icon3, jmi4_icon4, jmi5_icon5, jmi6_icon6, jmi7_icon7, jmi8_icon8, jmi9_icon9, jmi10_icon10, jmi11_icon11, jmi12_icon12;//图标对象
    public JToolBar jtb; //工具栏
    public static JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;//工具栏对应的按钮;
    public JButton jb11, jb22, jb33, jb44;//数据维护界面 对应的增删改查;
    public JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
    public JLabel showTime;//显示时间
    public JLabel p2_jl1, p2_jl2;
    public JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8;

    public JTable jTable;//表单
    public DefaultTableModel tableModel;//
    public JScrollPane jp11scrollPane;
    CardLayout myCard; //卡片模式
    public static String flagObject = "";//指定数据库的操作对象
    Timer t;//可定时触发Action事件
    ControllerFactory cft;//工厂控制器
    public static boolean ok = false;//单元格是否可编辑
    public JTree jt, jt2, jt3, jt4;//字典维护 树形结构
    public JTree jt11, jt22, jt33, jt44;//数据维护 树形结构

    public static void main(String[] args) {
        // TODO 自动生成的方法存根


        System.out.println("yark man");

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                //此处设置皮肤和主题

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

                // 另外如果想让整体界面变得协调，最好设置容器窗体的DefaultLookAndFeelDecorated属性为true。

                JFrame.setDefaultLookAndFeelDecorated(true);

                JDialog.setDefaultLookAndFeelDecorated(true);


            }
        });


    }


    //加载属性结构从本地文件tree
    public void initTree(JTree jt, JTree jt2, JTree jt3, JTree jt4, JTree jt11, JTree jt22, JTree jt33, JTree jt44) {

        //加载表格及相关类
        final CreateTable cb = new CreateTable();
        DatabaseDaoImp d = new DatabaseDaoImp();
        SelectTableImp sp = new SelectTableImp();

        //第一次加载树节点tree1 从本地文件夹tree中
        this.jt = jt;
        this.jt2 = jt2;
        this.jt3 = jt3;
        this.jt4 = jt4;
        this.jt11 = jt11;
        this.jt22 = jt22;
        this.jt33 = jt33;
        this.jt44 = jt44;

    }

    //初始化菜单
    public void initMenu() {
        //一级菜单

        jmi1_icon1 = new ImageIcon("src/main/resources/image/jm1_icon1.jpg");
        jmi2_icon2 = new ImageIcon("src/main/resources/image/jm1_icon2.jpg");
        jmi3_icon3 = new ImageIcon("src/main/resources/image/jm1_icon3.jpg");
        jmi4_icon4 = new ImageIcon("src/main/resources/image/jm1_icon4.jpg");
        jmi5_icon5 = new ImageIcon("src/main/resources/image/jm1_icon5.jpg");
        jm1 = new JMenu("系统管理");
        jm1.setFont(FontTools.f3);
        //创建其二级菜单
        jmi1 = new JMenuItem("切换用户", jmi1_icon1);
        jmi1.setFont(FontTools.f2);
        jmi5 = new JMenuItem("退出", jmi5_icon5);
        jmi5.setFont(FontTools.f2);
        jmi5.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi5);

        jmi6_icon6 = new ImageIcon("src/main/resources/image/toolBar_image/jb4.jpg");

        jm2 = new JMenu("数据维护");
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
        jm3 = new JMenu("字典维护");
        jm3.setFont(FontTools.f3);
        jmi7 = new JMenu("树形字典维护");
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
        jm6 = new JMenu("帮助");
        jm6.setFont(FontTools.f3);
        jmi10 = new JMenuItem("动画帮助", jmi10_icon10);
        jmi10.setFont(FontTools.f2);
        jmi11 = new JMenuItem("文本帮助", jmi11_icon11);
        jmi11.setFont(FontTools.f2);
        jmi12 = new JMenuItem("关于我们", jmi12_icon12);
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

    //初始化工具栏
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


    //初始化左栏中心，以树目录的形式与右边展现的内容进行呼应
    public void initCenter(String flag) {

        //jp1
        jp1 = new JPanel(new BorderLayout());
        try {
            p1_bg = ImageIO.read(new File("src/main/resources/image/center_image/jp1_bg.jpg"));
        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        Cursor myCursor = new Cursor(HAND_CURSOR);
        p1_bgImage = new ImagePanel(p1_bg);

        p1_bgImage.setLayout(new GridLayout(8, 13));

        //将左边的树形结构面板截屏设置为可滚动
        JScrollPane jp1scrollPane = new JScrollPane(jp1);
        jp1scrollPane.setViewportView(jp1);

        jp1scrollPane.add(p1_bgImage);


        jp3 = new JPanel(new BorderLayout());

        //先给jp3加入主界面卡片
        try {
            p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
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

    //状态栏
    public void initEnd() {
        jp5 = new JPanel(new BorderLayout());
        t = new Timer(1000, this);//每隔一秒触发ActonEvent
        showTime = new JLabel("当前时间：" + Calendar.getInstance().getTime().toLocaleString() + "   ");
        showTime.setFont(FontTools.f1);

        t.start();
        try {
            timeBg = ImageIO.read(new File("src/main/resources/image/time_bg.jpg"));
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
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
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        cft = new ControllerFactory();

        //树形结构
        this.initTree(LoadDataThread.jt, LoadDataThread.jt2, LoadDataThread.jt3, LoadDataThread.jt4,
                LoadDataThread.jt11, LoadDataThread.jt22, LoadDataThread.jt33, LoadDataThread.jt44);

        //菜单
        this.initMenu();

        //工具栏
        this.initToolBar();

        //中间
        this.initCenter("1");

        //状态栏
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
        this.setTitle("HJ系统");
        this.setVisible(true);
        this.setBounds(150, 150, width - 400, height - 240);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.showTime.setText("当前时间：" + Calendar.getInstance().getTime().toLocaleString() + "   ");
        if (e.getActionCommand() == "退出") {

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


        //bdqk维护
        if (e.getActionCommand() == "bdxx ") {

            //java.awt.EventQueue.invokeLater(new Runnable() {

            //    public void run() {

            //此处设置皮肤和主题
            DictionaryMainTainController c = (DictionaryMainTainController) cft.getConTrollers("DictionaryMainTain");

            c.armySituation(this);

            //   }
            // });


        }
        //zbgc维护
        if (e.getActionCommand() == "zbgc ") {

            DictionaryMainTainFourthController c = (DictionaryMainTainFourthController) cft.getConTrollers("DictionaryMainTainTFourth");

            c.armySituation(this);

        }
        //wjzb维护
        if (e.getActionCommand() == "wjzb ") {

            DictionaryMainTainSecondController c = (DictionaryMainTainSecondController) cft.getConTrollers("DictionaryMainTainSecond");

            c.armySituation(this);

        }
        //wjzb2维护
        if (e.getActionCommand() == "wjzb2 ") {

            DictionaryMainTainThirdController c = (DictionaryMainTainThirdController) cft.getConTrollers("DictionaryMainTainThird");
            c.armySituation(this);

        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO 自动生成的方法存根
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
        // TODO 自动生成的方法存根
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
        // TODO 自动生成的方法存根
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
        // TODO 自动生成的方法存根

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO 自动生成的方法存根

    }

}
