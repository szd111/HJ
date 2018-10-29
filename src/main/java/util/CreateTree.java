package util;


import model.entity.TreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.util.ArrayList;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 生成树形目录
 */
public class CreateTree {

    /**
     * @描述 根据根节点创立子节点
     * @参数 top根节点
     * @返回值 null
     * @创建人 szd
     * @创建时间 2018/9/26
     * @修改人和其它信息
     */
    private static void createNodes(DefaultMutableTreeNode top) {

        DefaultMutableTreeNode jingdian = null, jiaotong = null, zhusu = null, binguan = null, luying = null, jiesu = null, factor = null, class1 = null;

        String unicode = null;
        Utf8Gbk utf8Gbk = Utf8Gbk.getInstance();
        try {


            jingdian = new DefaultMutableTreeNode("景点");
            jingdian.add(new DefaultMutableTreeNode("景点1"));
            jingdian.add(new DefaultMutableTreeNode("景点2"));
            jiaotong = new DefaultMutableTreeNode("交通");
            jiaotong.add(new DefaultMutableTreeNode("路线1"));
            jiaotong.add(new DefaultMutableTreeNode("路线2"));
            jiaotong.add(new DefaultMutableTreeNode("路线3"));
            zhusu = new DefaultMutableTreeNode("住宿");
            zhusu.add(new DefaultMutableTreeNode("A住宿"));
            zhusu.add(new DefaultMutableTreeNode("B住宿"));
            zhusu.add(new DefaultMutableTreeNode("C住宿"));
            binguan = new DefaultMutableTreeNode("宾馆");
            binguan.add(new DefaultMutableTreeNode("X宾馆"));
            binguan.add(new DefaultMutableTreeNode("Y宾馆"));
            binguan.add(new DefaultMutableTreeNode("Z宾馆"));
            binguan.add(new DefaultMutableTreeNode("XYZ宾馆"));
            luying = new DefaultMutableTreeNode("露营");
            luying.add(new DefaultMutableTreeNode("方式1"));
            luying.add(new DefaultMutableTreeNode("方式2"));
            jiesu = new DefaultMutableTreeNode("借宿");
            jiesu.add(new DefaultMutableTreeNode("借宿1"));
            jiesu.add(new DefaultMutableTreeNode("借宿2"));
            jiesu.add(new DefaultMutableTreeNode("借宿3"));

            factor = new DefaultMutableTreeNode("班级");
            class1 = new DefaultMutableTreeNode("班级1");
            class1.add(new DefaultMutableTreeNode("班级2"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        factor.add(class1);


        top.add(jingdian);
        top.add(jiaotong);
        top.add(zhusu);
        top.add(binguan);
        top.add(luying);
        top.add(jiesu);
        top.add(factor);


    }


    /**
     * @描述 根据父节点实体 在集合中选出对应的下标
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/12
     * @修改人和其它信息
     */
    public static int getTreeNodeIndex(TreeNode ff, ArrayList<TreeNode> als) {

        int p = 0;
        for (int i = 0; i < als.size(); i++) {


            if (als.get(i).name.toString().trim().equals(ff.name.trim())) {

                p = i;
                break;
            }

        }

        return p;
    }


    /**
     * @描述 根据生成的树状集合 动态生成树状目录图
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/12
     * @修改人和其它信息
     */
    private void createDynamicNode(DefaultMutableTreeNode tops, ArrayList<TreeNode> als) {

        ArrayList<DefaultMutableTreeNode> al = new ArrayList<DefaultMutableTreeNode>();

        for (int k = 0; k < als.size(); k++) {


            DefaultMutableTreeNode dn = new DefaultMutableTreeNode(als.get(k).id);

            al.add(dn);


        }


        for (int k = 0; k < als.size(); k++) {


            //如果是根节点下的第一层节点则直接加入
            if (als.get(k).parent==null) {

                tops.add(al.get(k));

            }
            else if(als.get(k).parent!=null&&!als.get(k).parent.name.equals("null")) {
             if (CreateTree.getTreeNodeIndex(als.get(k).parent, als) != 0) {



                    if(als.get(k).name.equals("RF")){

                        System.out.println(CreateTree.getTreeNodeIndex(als.get(k).parent, als)+"=flag=rf=" + als.get(k).name+" "+als.get(k).parent.name);
                    }
                    al.get(CreateTree.getTreeNodeIndex(als.get(k).parent, als)).add(al.get(k));

                }

            }

        }


    }


    /**
     * @描述 根据创立的节点构建一棵动态树
     * @参数
     * @返回值 JTree
     * @创建人 szd
     * @创建时间 2018/9/26
     * @修改人和其它信息
     */
    public ArrayList<JTree> getJTree(ArrayList<TreeNode> als) {
        ArrayList<JTree> al=new ArrayList<JTree>();
        JTree jTree = null;JTree jTree2 = null;


            DefaultMutableTreeNode top = new DefaultMutableTreeNode("HJ");
            System.out.println("======load=======");

            createDynamicNode(top, als);

            jTree = new JTree(top);
            jTree2=new JTree(top);

            jTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree2.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        al.add(jTree);al.add(jTree2);
        return al;
    }

    /**
     * @描述 根据创立的节点构建一棵静态树
     * @参数
     * @返回值 JTree
     * @创建人 szd
     * @创建时间 2018/10/18
     * @修改人和其它信息
     */
    public static JTree getJTreeStatic() {

        JTree jTree = null;

        if (jTree == null) {

            DefaultMutableTreeNode top = new DefaultMutableTreeNode("HJ");

            System.out.println("======load=======");

            createNodes(top);

            jTree = new JTree(top);
            jTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);

        }
        return jTree;
    }

}
