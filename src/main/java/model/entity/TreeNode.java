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
 * @创建人 shizhendong
 * @创建时间 2018/9/29
 * @描述 通过树节点 进行树的定义
 */
public class TreeNode {

    public int flag = 0;
    public String id = "";//树节点的名称
    public String name = "";//树节点的编号

    public ArrayList<TreeNode> childs = new ArrayList<TreeNode>();
    public TreeNode parent = null;

    public TreeNode(String id, String name) {

        this.id = id;
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

    /**
     * @描述 从本地对应的tree文件中加载树节点
     * @参数 path 路劲,  top_first 除去根节点以外的第一层节点的长度
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/18
     * @修改人和其它信息
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
     * @描述 通过数据库的表名称 基于相应的表 通过每棵树的父节点 根据前缀生成一颗树,并把生成的树以父子节点的形式存入本地对应的tree文件
     * @参数 tablename 表名,  top_first 除去根节点以外的第一层节点的长度, ids 对应的编号，names 对应的名称
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/12
     * @修改人和其它信息
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


                System.out.println(i + "====遍历===" + injectNode.name + "  " + injectNode.name.getBytes().length);

                for (int j = 0; j < al.size(); j++) {

                    TreeNode treeNode = al.get(j);

                    //判断是不是根节点HJ下的第一层节点
                    if (treeNode.name.getBytes().length == top_first) {

                        treeNode.parent = null;
                        if (!alss.contains(treeNode.name)) {


                            als.add(treeNode);
                            alss.add(treeNode.name);
                            al.get(j).flag = 1;
                        }

                        //System.out.println("====top===" + " 父节点" + tops.name + "  子节点： " + treeNode.name);
                    }
                    //判断是不是根节点HJ下的第一层节点
                    if (injectNode.name.getBytes().length == top_first) {

                        injectNode.parent = null;
                        if (!alss.contains(injectNode.name)) {
                            als.add(injectNode);
                            alss.add(injectNode.name);
                            al.get(j).flag = 1;
                        }

                        //    System.out.println("====top===" + " 父节点" + tops.name + "  子节点： " + injectNode.name);
                    }

                    //如果传入的节点值包含此时的树节点值，且长度值的差小于3 则证明该传入节点值是该树节点的父节点
                    if (!injectNode.name.equals(treeNode.name) && injectNode.name.startsWith(treeNode.name) && Math.abs(injectNode.name.getBytes().length - treeNode.name.getBytes().length) < 3) {


                        injectNode.parent = treeNode;

                        if (!alss.contains(injectNode.name)) {
                            als.add(injectNode);
                            alss.add(injectNode.name);
                            al.get(j).flag = 1;
                        }

                        System.out.println("子节点" + injectNode.name + "  父节点: " + treeNode.name);

                    }
                    //与上面相反
                    else if (!injectNode.name.equals(treeNode.name) && treeNode.name.startsWith(injectNode.name) && (Math.abs(treeNode.name.getBytes().length - injectNode.name.getBytes().length) < 3)) {


                        treeNode.parent = injectNode;

                        if (!alss.contains(treeNode.name)) {
                            als.add(treeNode);
                            alss.add(treeNode.name);
                            al.get(j).flag = 1;
                        }

                        System.out.println(" 子节点" + treeNode.name + "  父节点： " + injectNode.name);
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


        //生成树状结构

        long a=System.currentTimeMillis();
        TreeNode.createTree1("NSDB.字典_通用_装备",2,"装备序号","装备名称","src/main/resources/tree/test" + "");
      //  TreeNode.createTree1("NSDB.字典_通用_外军装备",3,"装备序号","装备名称","src/main/resources/tree/tree3" + "");
       //  TreeNode.createTree1("NSDB.字典_通用_战备工程",2,"战备工程序号","战备工程名称","src/main/resources/tree/tree4" + "");

       // TreeNode.createTree1("NSDB.字典_通用_部队番号",8,"部队序号",
              //  "部队番号","src/main/resources/tree/tree1" + "");

        long b=System.currentTimeMillis();

        //8326 9282 8108
        //
        System.out.println("===时间==="+(b-a));


    }


}
