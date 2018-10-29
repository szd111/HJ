package thread;

import model.entity.TreeNode;
import view.Windows;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @修改人 jhzhu
 * @修改时间 2018/9/26
 * @描述 去掉多线程
 */
public class LoadDataThread{

    public static JTree jt, jt2, jt3, jt4;//字典维护 树形结构
    public static JTree jt11, jt22, jt33, jt44;//数据维护 树形结构


    public LoadDataThread(MyProgressBar next) {
        ArrayList<JTree> jTree = TreeNode.loadTreeNodes("src/main/resources/tree/tree11");
        ArrayList<JTree> jTree1 = TreeNode.loadTreeNodes("src/main/resources/tree/tree22");
        ArrayList<JTree> jTree2 = TreeNode.loadTreeNodes("src/main/resources/tree/tree33");
        ArrayList<JTree> jTree3 = TreeNode.loadTreeNodes("src/main/resources/tree/tree44");

        jt=jTree.get(0); jt2=jTree1.get(0); jt3=jTree2.get(0); jt4=jTree3.get(0);
        jt11=jTree.get(1); jt22=jTree1.get(1); jt33=jTree2.get(1); jt44=jTree3.get(1);

        new Windows();
    }



}
