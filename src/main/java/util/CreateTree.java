package util;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

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
    private void createNodes(DefaultMutableTreeNode top) {
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
     * @描述 根据创立的节点构建一棵树
     * @参数
     * @返回值 JTree
     * @创建人 szd
     * @创建时间 2018/9/26
     * @修改人和其它信息
     */
    public JTree getJTree() {

        JTree jTree=null;

        if (jTree == null) {
            DefaultMutableTreeNode  top = new DefaultMutableTreeNode("黄山");
            createNodes(top);
            jTree = new JTree(top);
            jTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);
            //jTree.addTreeSelectionListener(this);
        }
        return jTree;
    }


}
