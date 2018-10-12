package model.entity;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/29
 * @���� ͨ�����ڵ� �������Ķ���
 */
public class TreeNode {

    public int flag = 0;
    public String name = "";

    public ArrayList<TreeNode> childs = new ArrayList<TreeNode>();
    public TreeNode parent = null;

    public TreeNode(String name) {

        this.name = name;
    }


    /**
     * @���� ������ڵ�
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/9/29
     * @�޸��˺�������Ϣ
     */
    public void addTreeNode(TreeNode t, TreeNode p) {


        if (p != null) {


            p.childs.add(t);
            t.parent = p;
        }

    }


    /**
     * @���� �������ڵ� �������б���
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/9/29
     * @�޸��˺�������Ϣ
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

    /**
     * @���� ͨ��ÿ�����ĸ��ڵ� ����ǰ׺����һ����
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/12
     * @�޸��˺�������Ϣ
     */
    public static ArrayList<TreeNode> createTree1() {

       // TreeNode tops = new TreeNode("HsJ");
        String[] list = {"0", "1", "2", "3", "001", "002", "003", "00101", "00102", "100", "101", "10001", "10002"};

        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        ArrayList<TreeNode> als = new ArrayList<TreeNode>();
        ArrayList<String> alss = new ArrayList<String>();

        for (int i = 0; i < list.length; i++) {


            TreeNode node = new TreeNode(list[i] + "");
            al.add(node);
        }

        for (int i = 0; i < al.size(); i++) {


            TreeNode injectNode = al.get(i);
            System.out.println(i + "====����===" + injectNode.name + "  " + injectNode.name.getBytes().length);

            for (int j = 0; j < al.size(); j++) {

                TreeNode treeNode = al.get(j);

                if (treeNode.name.getBytes().length == 1) {

                   // treeNode.parent = (TreeNode) tops;
                    if (!alss.contains(treeNode.name)) {


                        als.add(treeNode);
                        alss.add(treeNode.name);
                        treeNode.flag = 1;
                    }

                    //System.out.println("====top===" + " ���ڵ�" + tops.name + "  �ӽڵ㣺 " + treeNode.name);
                }
                if (injectNode.name.getBytes().length == 1) {

                   // injectNode.parent = (TreeNode) tops;
                    if (!alss.contains(injectNode.name)) {
                        als.add(injectNode);
                        alss.add(injectNode.name);
                        injectNode.flag = 1;
                    }

                //    System.out.println("====top===" + " ���ڵ�" + tops.name + "  �ӽڵ㣺 " + injectNode.name);
                }

                //�������Ľڵ�ֵ������ʱ�����ڵ�ֵ���ҳ���ֵ�Ĳ�С��3 ��֤���ô���ڵ�ֵ�Ǹ����ڵ�ĸ��ڵ�
                if (!injectNode.name.equals(treeNode.name) && injectNode.name.startsWith(treeNode.name) && (injectNode.name.getBytes().length - treeNode.name.getBytes().length < 3)) {


                    injectNode.parent = treeNode;

                    if (!alss.contains(injectNode.name)) {
                        als.add(injectNode);
                        alss.add(injectNode.name);
                        //treeNode.add(injectNode);
                    }

                    System.out.println("�ӽڵ�" + injectNode.name + "  ���ڵ�: " + treeNode.name);

                }
                //�������෴
                else if (!injectNode.name.equals(treeNode.name) && treeNode.name.startsWith(injectNode.name) && (treeNode.name.getBytes().length - injectNode.name.getBytes().length < 3)) {


                    treeNode.parent = injectNode;

                    if (!alss.contains(treeNode.name)) {
                        als.add(treeNode);
                        alss.add(treeNode.name);
                        // injectNode.add(treeNode);
                    }

                    System.out.println(" �ӽڵ�" + treeNode.name + "  ���ڵ㣺 " + injectNode.name);
                }

            }
        }

        return als;

    }

    public static void main(String args[]) {


        // TreeNode.createTree1();


//        TreeNode top = new TreeNode("human");
//
//        TreeNode t1 = new TreeNode("man");
//        TreeNode t2 = new TreeNode("woman");
//        TreeNode t3 = new TreeNode("boy");
//
//        top.addTreeNode(t1, top);
//        top.addTreeNode(t2, top);
//        top.addTreeNode(t3, top);
//
//        TreeNode t11 = new TreeNode("man1");
//        TreeNode t22 = new TreeNode("woman1");
//        TreeNode t23 = new TreeNode("woman2");
//        TreeNode t24 = new TreeNode("woman3");
//        top.addTreeNode(t11, t1);
//        top.addTreeNode(t22, t2);
//        top.addTreeNode(t23, t2);
//        top.addTreeNode(t24, t2);
//
//        top.print(top);
    }


}
