package thread;

import model.entity.TreeNode;

import javax.swing.*;

/**
 * @创建人 shizhendong
 * @创建时间 2018/10/25
 * @描述 根据JTree 进行现程化加载
 */
public class JTreeThread extends JTree implements Runnable{

    public int flag=0;
    JTree jTree=null;
    public String path="";

    public JTreeThread(String path){
        this.path=path;

    }

    @Override
    public void run() {
        System.out.println("====start==="+flag);
        jTree = TreeNode.loadTreeNodes(path);
        flag=1;
        System.out.println("====over==="+flag);
    }
}
