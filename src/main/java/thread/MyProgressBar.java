package thread;

import javax.swing.*;
import java.awt.*;

public class MyProgressBar extends JProgressBar implements Runnable{

    final JProgressBar aJProgressBar = new JProgressBar();
    final JButton aJButton = new JButton("Start");

    public MyProgressBar(){

    }

    @Override
    public void run() {
        aJProgressBar.setIndeterminate(true); // 不确定的进度条
        aJProgressBar.setStringPainted(true); // 显示提示信息
        aJProgressBar.setString("登录成功，加载数据中...");
        JFrame theFrame = new JFrame("提示");

        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = theFrame.getContentPane();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.add(aJProgressBar);
        theFrame.setSize(300, 60);
        theFrame.setBounds(800,500,300,60);
        theFrame.setVisible(true);
        new LoadDataThread(this);
        theFrame.dispose();
    }
}
