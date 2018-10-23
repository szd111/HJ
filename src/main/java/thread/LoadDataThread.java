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

        JTree jTree = TreeNode.loadTreeNode("src/main/resources/tree/tree1");
        JTree jTree1 = TreeNode.loadTreeNode("src/main/resources/tree/test");
        JTree jTree2 = TreeNode.loadTreeNode("src/main/resources/tree/tree3");
        JTree jTree3 = TreeNode.loadTreeNode("src/main/resources/tree/tree4");
        result = 1;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (result == 1) {
                    progress.setVisible(false);
                    new Windows(jTree,jTree1,jTree2,jTree3,jTree);
                }else {
                    System.out.println("yichang!!!");
                }

            }
        });
    }
}
