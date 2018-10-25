package thread;

import model.MyProgressBar;
import model.entity.TreeNode;
import view.Windows;

import javax.swing.*;


public class LoadDataThread extends Thread{

    MyProgressBar progress ;

    int result = 0;

    public LoadDataThread(MyProgressBar next) {
        progress=next;

    }


    public void run(){


        JTree jTree = TreeNode.loadTreeNodes("src/main/resources/tree/tree11");
        JTree jTree1 = TreeNode.loadTreeNodes("src/main/resources/tree/tree22");
        JTree jTree2 = TreeNode.loadTreeNodes("src/main/resources/tree/tree33");
        JTree jTree3 = TreeNode.loadTreeNodes("src/main/resources/tree/tree44");
        result = 1;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (result == 1) {
                    progress.hide();
                    progress.setVisible(false);
                    new Windows(jTree,jTree1,jTree2,jTree3,jTree);
                }else {
                    System.out.println("yichang!!!");
                }

            }
        });
    }
}
