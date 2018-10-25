package thread;

import model.MyProgressBar;
import model.entity.TreeNode;
import view.Windows;

import javax.swing.*;

/**
 * @修改人 jhzhu
 * @修改时间 2018/9/26
 * @描述 去掉多线程
 */
public class LoadDataThread{

    public LoadDataThread(MyProgressBar next) {
        JTree jTree = TreeNode.loadTreeNodes("src/main/resources/tree/tree11");
        JTree jTree1 = TreeNode.loadTreeNodes("src/main/resources/tree/tree22");
        JTree jTree2 = TreeNode.loadTreeNodes("src/main/resources/tree/tree33");
        JTree jTree3 = TreeNode.loadTreeNodes("src/main/resources/tree/tree44");
        new Windows(jTree,jTree1,jTree2,jTree3,jTree);
    }



}
