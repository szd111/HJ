package model.entity;

import model.database.DatabaseDaoImp;
import util.CreateTree;
import util.Io;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public String id = "";//���ڵ������
    public String name = "";//���ڵ�ı��

    public ArrayList<TreeNode> childs = new ArrayList<TreeNode>();
    public TreeNode parent = null;

    public TreeNode(String id, String name) {

        this.id = id;
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
     * @���� �ӱ��ض�Ӧ��tree�ļ��м������ڵ�
     * @���� path ·��,  top_first ��ȥ���ڵ�����ĵ�һ��ڵ�ĳ���
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/18
     * @�޸��˺�������Ϣ
     */
    public  static JTree  loadTreeNode(String path) {

        JTree jt=null;
        CreateTree ct = new CreateTree();
        String lines[] = Io.readFromTxt(path).split("\\$");
        // ArrayList<TreeNode> als = TreeNode.createTree1();
        ArrayList<TreeNode> als = new ArrayList<TreeNode>();
        for (int i = 1; i < lines.length; i++) {

            //    System.out.println(i + "===line===" + lines[i]);
            String line = lines[i];
            TreeNode tt = new TreeNode(line.split("\\#")[1].split(" ")[0], line.split("\\#")[1].split(" ")[1]);
            if (!line.split("\\#")[0].split(" ")[0].equals("null")) {
                tt.parent = new TreeNode(line.split("\\#")[0].split(" ")[0], line.split("\\#")[0].split(" ")[1]);

            }
            als.add(tt);
        }
        jt = ct.getJTree(als);

        return  jt;

    }

    /**
     * @���� ͨ�����ݿ�ı����� ������Ӧ�ı� ͨ��ÿ�����ĸ��ڵ� ����ǰ׺����һ����,�������ɵ����Ը��ӽڵ����ʽ���뱾�ض�Ӧ��tree�ļ�
     * @���� tablename ����,  top_first ��ȥ���ڵ�����ĵ�һ��ڵ�ĳ���, ids ��Ӧ�ı�ţ�names ��Ӧ������
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/12
     * @�޸��˺�������Ϣ
     */

    public static ArrayList<TreeNode> createTree1(String tablename, int top_first, String ids, String names,String path) {

        // TreeNode tops = new TreeNode("HsJ");

        DatabaseDaoImp dn = new DatabaseDaoImp();

        ArrayList<String> list = new ArrayList<String>();
        dn.database = "oracle";
        Connection c = dn.getConnection();
        //System.out.println("===sql==="+"select * from "+tablename+"");
        ResultSet rs = dn.executeQuery("select * from "+tablename+"", c);

        try {
            while (rs.next()) {

                String id = rs.getString(ids);
                String name = rs.getString(names);
                list.add(id + "#" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        ArrayList<TreeNode> als = new ArrayList<TreeNode>();
        ArrayList<String> alss = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {


            TreeNode node = new TreeNode(list.get(i).split("\\#")[1], list.get(i).split("\\#")[0]);
            al.add(node);
        }

        for (int i = 0; i < al.size(); i++) {


            TreeNode injectNode = al.get(i);
            if (injectNode.flag != 11) {


                System.out.println(i + "====����===" + injectNode.name + "  " + injectNode.name.getBytes().length);

                for (int j = 0; j < al.size(); j++) {

                    TreeNode treeNode = al.get(j);

                    //�ж��ǲ��Ǹ��ڵ�HJ�µĵ�һ��ڵ�
                    if (treeNode.name.getBytes().length == top_first) {

                        treeNode.parent = null;
                        if (!alss.contains(treeNode.name)) {


                            als.add(treeNode);
                            alss.add(treeNode.name);
                            al.get(j).flag = 1;
                        }

                        //System.out.println("====top===" + " ���ڵ�" + tops.name + "  �ӽڵ㣺 " + treeNode.name);
                    }
                    //�ж��ǲ��Ǹ��ڵ�HJ�µĵ�һ��ڵ�
                    if (injectNode.name.getBytes().length == top_first) {

                        injectNode.parent = null;
                        if (!alss.contains(injectNode.name)) {
                            als.add(injectNode);
                            alss.add(injectNode.name);
                            al.get(j).flag = 1;
                        }

                        //    System.out.println("====top===" + " ���ڵ�" + tops.name + "  �ӽڵ㣺 " + injectNode.name);
                    }

                    //�������Ľڵ�ֵ������ʱ�����ڵ�ֵ���ҳ���ֵ�Ĳ�С��3 ��֤���ô���ڵ�ֵ�Ǹ����ڵ�ĸ��ڵ�
                    if (!injectNode.name.equals(treeNode.name) && injectNode.name.startsWith(treeNode.name) && Math.abs(injectNode.name.getBytes().length - treeNode.name.getBytes().length) < 3) {


                        injectNode.parent = treeNode;

                        if (!alss.contains(injectNode.name)) {
                            als.add(injectNode);
                            alss.add(injectNode.name);
                            al.get(j).flag = 1;
                        }

                        System.out.println("�ӽڵ�" + injectNode.name + "  ���ڵ�: " + treeNode.name);

                    }
                    //�������෴
                    else if (!injectNode.name.equals(treeNode.name) && treeNode.name.startsWith(injectNode.name) && (Math.abs(treeNode.name.getBytes().length - injectNode.name.getBytes().length) < 3)) {


                        treeNode.parent = injectNode;

                        if (!alss.contains(treeNode.name)) {
                            als.add(treeNode);
                            alss.add(treeNode.name);
                            al.get(j).flag = 1;
                        }

                        System.out.println(" �ӽڵ�" + treeNode.name + "  ���ڵ㣺 " + injectNode.name);
                    }

                }
            }
        }

       for(int i=0;i<als.size();i++){

          //  System.out.println(als.get(i).parent.id + " " + als.get(i).parent.name + "#" + als.get(i).id + " " + als.get(i).name);

            if(als.get(i).parent!=null) {
                Io.writeToTxt(path, als.get(i).parent.id + " " + als.get(i).parent.name + "#" + als.get(i).id + " " + als.get(i).name);

              //  if(als.get(i).parent.parent==null)

            }
            else if(als.get(i).parent==null){

                Io.writeToTxt(path, "null"+"#" + als.get(i).id + " " + als.get(i).name);

           }
       }


        return als;

    }

    public static void main(String args[]) {


        //������״�ṹ

        long a=System.currentTimeMillis();
        TreeNode.createTree1("NSDB.�ֵ�_ͨ��_װ��",2,"װ�����","װ������","src/main/resources/tree/test" + "");
      //  TreeNode.createTree1("NSDB.�ֵ�_ͨ��_���װ��",3,"װ�����","װ������","src/main/resources/tree/tree3" + "");
       //  TreeNode.createTree1("NSDB.�ֵ�_ͨ��_ս������",2,"ս���������","ս����������","src/main/resources/tree/tree4" + "");

       // TreeNode.createTree1("NSDB.�ֵ�_ͨ��_���ӷ���",8,"�������",
              //  "���ӷ���","src/main/resources/tree/tree1" + "");

        long b=System.currentTimeMillis();

        //8326 9282 8108
        //
        System.out.println("===ʱ��==="+(b-a));


    }


}
