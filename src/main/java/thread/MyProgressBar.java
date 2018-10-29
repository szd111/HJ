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
        aJProgressBar.setIndeterminate(true); // ��ȷ���Ľ�����
        aJProgressBar.setStringPainted(true); // ��ʾ��ʾ��Ϣ
        aJProgressBar.setString("��¼�ɹ�������������...");
        JFrame theFrame = new JFrame("��ʾ");

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
