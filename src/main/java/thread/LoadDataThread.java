package thread;

import model.entity.TreeNode;
import view.Windows;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @�޸��� jhzhu
 * @�޸�ʱ�� 2018/9/26
 * @���� ȥ�����߳�
 */
public class LoadDataThread{

    public static JTree jt, jt2, jt3, jt4;//�ֵ�ά�� ���νṹ
    public static JTree jt11, jt22, jt33, jt44;//����ά�� ���νṹ


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
