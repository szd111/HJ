package util;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @���� ��������Ŀ¼
 */
public class CreateTree {

    /**
     * @���� ���ݸ��ڵ㴴���ӽڵ�
     * @���� top���ڵ�
     * @����ֵ null
     * @������ szd
     * @����ʱ�� 2018/9/26
     * @�޸��˺�������Ϣ
     */
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode jingdian = null, jiaotong = null, zhusu = null, binguan = null, luying = null, jiesu = null, factor = null, class1 = null;

        String unicode = null;
        Utf8Gbk utf8Gbk = Utf8Gbk.getInstance();
        try {


            jingdian = new DefaultMutableTreeNode("����");
            jingdian.add(new DefaultMutableTreeNode("����1"));
            jingdian.add(new DefaultMutableTreeNode("����2"));
            jiaotong = new DefaultMutableTreeNode("��ͨ");
            jiaotong.add(new DefaultMutableTreeNode("·��1"));
            jiaotong.add(new DefaultMutableTreeNode("·��2"));
            jiaotong.add(new DefaultMutableTreeNode("·��3"));
            zhusu = new DefaultMutableTreeNode("ס��");
            zhusu.add(new DefaultMutableTreeNode("Aס��"));
            zhusu.add(new DefaultMutableTreeNode("Bס��"));
            zhusu.add(new DefaultMutableTreeNode("Cס��"));
            binguan = new DefaultMutableTreeNode("����");
            binguan.add(new DefaultMutableTreeNode("X����"));
            binguan.add(new DefaultMutableTreeNode("Y����"));
            binguan.add(new DefaultMutableTreeNode("Z����"));
            binguan.add(new DefaultMutableTreeNode("XYZ����"));
            luying = new DefaultMutableTreeNode("¶Ӫ");
            luying.add(new DefaultMutableTreeNode("��ʽ1"));
            luying.add(new DefaultMutableTreeNode("��ʽ2"));
            jiesu = new DefaultMutableTreeNode("����");
            jiesu.add(new DefaultMutableTreeNode("����1"));
            jiesu.add(new DefaultMutableTreeNode("����2"));
            jiesu.add(new DefaultMutableTreeNode("����3"));

            factor = new DefaultMutableTreeNode("�༶");
            class1 = new DefaultMutableTreeNode("�༶1");
            class1.add(new DefaultMutableTreeNode("�༶2"));

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
     * @���� ���ݴ����Ľڵ㹹��һ����
     * @����
     * @����ֵ JTree
     * @������ szd
     * @����ʱ�� 2018/9/26
     * @�޸��˺�������Ϣ
     */
    public JTree getJTree() {

        JTree jTree=null;

        if (jTree == null) {
            DefaultMutableTreeNode  top = new DefaultMutableTreeNode("��ɽ");
            createNodes(top);
            jTree = new JTree(top);
            jTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);
            //jTree.addTreeSelectionListener(this);
        }
        return jTree;
    }


}
