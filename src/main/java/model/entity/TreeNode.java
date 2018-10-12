package model.entity;

import java.util.ArrayList;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/29
 * @描述 通过树节点 进行树的定义
 */
public class TreeNode {

    String name = "";

    ArrayList<TreeNode> childs = new ArrayList<TreeNode>();
    TreeNode parent = null;

    public TreeNode(String name) {

        this.name = name;
    }


    /**
     * @描述 添加树节点
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/29
     * @修改人和其它信息
     */
    public void addTreeNode(TreeNode t, TreeNode p) {


        if (p != null) {


            p.childs.add(t);
            t.parent = p;
        }

    }


    /**
     * @描述 根据树节点 对树进行遍历
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/29
     * @修改人和其它信息
     */
    public void print(TreeNode t) {


        if (t != null) {


            if (t.childs != null) {

                // System.out.println(t.parent.name);
                for (int i = 0; i < t.childs.size(); i++) {
                    System.out.print(t.childs.get(i).name + " ");
                    print(t.childs.get(i));

                }
                System.out.println();
            } else {

                System.out.print(t.name);
//                for(int i=0;i<t.childs.size();i++) {
//                    System.out.print(t.childs.get(i).name+" ");
//
//                }


            }

        }


    }

    public static void main(String args[]) {


        TreeNode top = new TreeNode("human");

        TreeNode t1 = new TreeNode("man");
        TreeNode t2 = new TreeNode("woman");
        TreeNode t3 = new TreeNode("boy");

        top.addTreeNode(t1, top);
        top.addTreeNode(t2, top);
        top.addTreeNode(t3, top);

        TreeNode t11 = new TreeNode("man1");
        TreeNode t22 = new TreeNode("woman1");
        TreeNode t23 = new TreeNode("woman2");
        TreeNode t24 = new TreeNode("woman3");
        top.addTreeNode(t11, t1);
        top.addTreeNode(t22, t2);
        top.addTreeNode(t23, t2);
        top.addTreeNode(t24, t2);

        top.print(top);
    }


}
