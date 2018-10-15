package util;


import model.entity.TreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.util.ArrayList;

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
     * @���� ���ݸ��ڵ�ʵ�� �ڼ�����ѡ����Ӧ���±�
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/12
     * @�޸��˺�������Ϣ
     */
    public static int getTreeNodeIndex(TreeNode ff, ArrayList<TreeNode> als) {

        int p = 0;
        for (int i = 0; i < als.size(); i++) {

            if (als.get(i).name.equals(ff.name)) {
                p = i;
                break;
            }

        }

        return p;
    }


    /**
     * @���� �������ɵ���״���� ��̬������״Ŀ¼ͼ
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/12
     * @�޸��˺�������Ϣ
     */
    private void createDynamicNode(DefaultMutableTreeNode tops, ArrayList<TreeNode> als) {

        ArrayList<DefaultMutableTreeNode> al = new ArrayList<DefaultMutableTreeNode>();

        for (int k = 0; k < als.size(); k++) {


            DefaultMutableTreeNode dn = new DefaultMutableTreeNode(als.get(k).name);

            al.add(dn);
        }



        for (int k = 0; k < al.size(); k++) {


            //����Ǹ��ڵ��µĵ�һ��ڵ���ֱ�Ӽ���
            if (als.get(k).name.getBytes().length == 1) {

                tops.add(al.get(k));

            } else {

                System.out.printf("=flag==" + CreateTree.getTreeNodeIndex(als.get(k).parent, als));

                al.get(CreateTree.getTreeNodeIndex(als.get(k).parent, als)).add(al.get(k));

            }

        }


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

        JTree jTree = null;

        if (jTree == null) {

            DefaultMutableTreeNode top = new DefaultMutableTreeNode("HJ");

            createDynamicNode(top, TreeNode.createTree1());

            jTree = new JTree(top);
            jTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);

        }
        return jTree;
    }


}
