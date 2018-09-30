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

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 针对windows界面中的数据维护中的actionformed进行事件的控制
 */
public class DataMainTainController {


    /**
     * @描述 退出界面操作 通过鼠标点击退出键进行退出
     * @参数 JFrame窗体
     * @返回值 null
     * @创建人 shizhengdong
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public void exit(JFrame j) {

        j.dispose();
        UserLogin n = new UserLogin();

    }


    /**
     * @描述 对部队情况的actionformed作出监听
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public void armySituation(final Windows w) {


        final CreateTable cb=new CreateTable();

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
                    JScrollPane jb=cb.createTable(object.toString());

                    w.jp3.removeAll();
                    w.jp3.repaint();
                    try {
                        w.p3Icon = ImageIO.read(new File("src/main/resources/image/bg.jpg"));
                    } catch (IOException e1) {
                        // TODO 自动生成的 catch 块
                        e1.printStackTrace();
                    }
                    w.jp3Image = new ImagePanel(w.p3Icon);
                    w.jp3Image.setLayout(new BorderLayout());
                    w.jb11 = new JButton("添加");
                    w.jb11.addActionListener(w);
                    w.jb22 = new JButton("删除");

                    w.jp6 = new JPanel();
                    w.jp6.add(w.jb11);
                    w.jp6.add(w.jb22);
                    w.jp3Image.add(w.jp6, BorderLayout.NORTH);
                    // w.jp3Image.add(w.p2_jl1, BorderLayout.CENTER);
                    w.jp3Image.add(jb, BorderLayout.CENTER);
                    w.jp3.add(w.jp3Image);
                    w.jp3.revalidate();


                }
            }
        });
    }


}
