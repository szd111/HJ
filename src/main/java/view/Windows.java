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
    public JMenuItem jmii1, jmii2, jmii3, jmii4, jmii5, jmii6, jmii7;//对应的菜单栏三级
    public ImageIcon jmi1_icon1, jmi2_icon2, jmi3_icon3, jmi4_icon4, jmi5_icon5, jmi6_icon6, jmi7_icon7, jmi8_icon8, jmi9_icon9, jmi10_icon10, jmi11_icon11, jmi12_icon12;//图标对象
    public JToolBar jtb; //工具栏
    public static JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;//工具栏对应的按钮;
    public JButton jb11, jb22, jb33, jb44;//数据维护界面 对应的增删改查;
    public JPanel jp1, jp2, jp3, jp4, jp5, jp6,jp7;
    public JLabel showTime;//显示时间
    public JLabel p2_jl1, p2_jl2;
    public JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8;
    public JTable jTable;//表单
    public DefaultTableModel tableModel;//
    CardLayout myCard; //卡片模式
    static String flag = "";
    Timer t;//可定时触发Action事件
    ControllerFactory cft;//工厂控制器

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

                Windows w = new Windows();

            }
        });


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
        jmi2 = new JMenuItem("切换到收款界面", jmi2_icon2);
        jmi2.setFont(FontTools.f2);
        jmi3 = new JMenuItem("登陆管理", jmi3_icon3);
        jmi3.setFont(FontTools.f2);
        jmi4 = new JMenuItem("万年历", jmi4_icon4);
        jmi4.setFont(FontTools.f2);
        jmi5 = new JMenuItem("退出", jmi5_icon5);
        jmi5.setFont(FontTools.f2);
        jmi5.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm1.add(jmi4);
        jm1.add(jmi5);

        jmi6_icon6 = new ImageIcon("src/main/resources/image/toolBar_image/jb4.jpg");

        jm2 = new JMenu("数据维护");
        jm2.setFont(FontTools.f3);
        jmi6 = new JMenu("作 战");
        jmi6.setFont(FontTools.f2);
        jmii1 = new JMenuItem("部队情况", jmi6_icon6);
        jmii1.setFont(FontTools.f2);
        jmii1.addActionListener(this);
        jmii2 = new JMenuItem("战备工程", jmi6_icon6);
        jmii2.setFont(FontTools.f2);
        jmii2.addActionListener(this);
        jmi6.add(jmii1);
        jmi6.add(jmii2);

        jmi7 = new JMenu("装 备");
        jmi7.setFont(FontTools.f2);
        jmii7 = new JMenuItem("外军装备", jmi6_icon6);
        jmii7.setFont(FontTools.f2);
        jmi7.add(jmii7);

        jm2.add(jmi6);
        jm2.add(jmi7);

        jmi7_icon7 = new ImageIcon("src/main/resources/image/toolBar_image/jb6.jpg");
        jm3 = new JMenu("字典维护");
        jm3.setFont(FontTools.f3);
        jmi7 = new JMenu("树形字典维护");
        jmi7.setFont(FontTools.f2);
        jmii3 = new JMenuItem("部队序型", jmi7_icon7);
        jmii3.addActionListener(this);
        jmii3.setFont(FontTools.f2);
        jmii4 = new JMenuItem("我军装备", jmi7_icon7);
        jmii4.addActionListener(this);
        jmii4.setFont(FontTools.f2);
        jmii5 = new JMenuItem("外军装备", jmi7_icon7);
        jmii5.addActionListener(this);
        jmii5.setFont(FontTools.f2);
        jmii6 = new JMenuItem("战备工程", jmi7_icon7);
        jmii6.addActionListener(this);
        jmii6.setFont(FontTools.f2);

        jmi7.add(jmii3);
        jmi7.add(jmii4);
        jmi7.add(jmii5);
        jmi7.add(jmii6);

        jm3.add(jmi7);

        jmi8_icon8 = new ImageIcon("src/main/resources/image/toolBar_image/jb5.jpg");
        jm4 = new JMenu("报表统计");
        jm4.setFont(FontTools.f3);
        jmi8 = new JMenuItem("财务报表", jmi8_icon8);
        jmi8.setFont(FontTools.f2);
        jm4.add(jmi8);


        jmi9_icon9 = new ImageIcon("src/main/resources/image/toolBar_image/jb7.jpg");
        jm5 = new JMenu("成本及库房");
        jm5.setFont(FontTools.f3);
        jmi9 = new JMenuItem("成本控制", jmi9_icon9);
        jmi9.setFont(FontTools.f2);
        jm5.add(jmi9);

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
        jmb.add(jm4);
        jmb.add(jm5);
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
        p1_bgImage.setLayout(new GridLayout(8, 1));
        jp1.add(p1_bgImage);

        //jp4,jp2,jp3,jp6
        myCard = new CardLayout();
        jp4 = new JPanel(new BorderLayout());
        jp2 = new JPanel(new CardLayout());
        p2_jl1 = new JLabel(new ImageIcon("src/main/resources/image/center_image/jp2_left.jpg"));
        p2_jl1.addMouseListener(this);
        //图标切换
        p2_jl1.addMouseListener(this);
        p2_jl2 = new JLabel(new ImageIcon("src/main/resources/image/center_image/jp2_right.jpg"));
        p2_jl2.addMouseListener(this);
        jp2.add(p2_jl1, "0");
        jp2.add(p2_jl2, "1");

        jp3 = new JPanel(myCard);

        //先给jp3加入主界面卡片
        try {
            p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
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
        cft=new ControllerFactory();

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.showTime.setText("当前时间：" + Calendar.getInstance().getTime().toLocaleString() + "   ");


        if (e.getActionCommand() == "退出") {


            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.exit(this);

        }

        //部队情况
        if (e.getActionCommand() == "部队情况") {

           DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
           c.armySituation(this);
        }
        if(e.getActionCommand()=="添加"){

            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.addDeleteTable(0,this);

            System.out.println("====add--===");
        }
        if(e.getActionCommand()=="删除"){


            DataMainTainController c= (DataMainTainController) cft.getConTrollers("DataMainTain");
            c.addDeleteTable(1,this);

            System.out.println("====delete--===");
        }
        if(e.getActionCommand()=="提交"){

//            int selectedRow = jTable.getSelectedRow();//获得选中行的索引??
//
//            for(int n= 0; n < 4; n ++){
//               //object.add(jTable.getVauleAt(index,n));
//                System.out.println(selectedRow +"====ok--==="+jTable.getValueAt(selectedRow ,n));
//            }
//
//            System.out.println("====ok--===");
        }

        //部队情况
        if (e.getActionCommand() == "部队序型") {


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
