package model;

import thread.LoadDataThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgressBar extends JProgressBar {

    final JProgressBar aJProgressBar = new JProgressBar();
    final JButton aJButton = new JButton("Start");

    public MyProgressBar(){

        //aJProgressBar.setStringPainted(true); // ��ʾ�ٷֱ��ַ�
        aJProgressBar.setIndeterminate(true); // ��ȷ���Ľ�����
       /* ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aJButton.setEnabled(false);
                Thread stepper = new ProgressSample.BarThread(aJProgressBar);
                stepper.start();
            }
        };*/
       /* aJButton.addActionListener(actionListener);*/
        aJProgressBar.setStringPainted(true); // ��ʾ��ʾ��Ϣ
        aJProgressBar.setString("��¼�ɹ�������������...");
        JFrame theFrame = new JFrame("��ʾ");

        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = theFrame.getContentPane();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.add(aJProgressBar);
    /*    contentPane.add(aJButton);*/
        theFrame.setSize(300, 60);
        theFrame.setBounds(800,500,300,60);
        theFrame.setVisible(true);

        LoadDataThread thread = new LoadDataThread(this);
        thread.start();
    }

    public static void main(String args[]){
        MyProgressBar bar = new MyProgressBar();
    }
}
