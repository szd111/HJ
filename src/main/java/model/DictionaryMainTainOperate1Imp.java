package model;


import model.database.DatabaseDaoImp;
import model.entity.TreeNode;
import util.Io;
import view.Windows;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ����
 * ʱ�� 2018/10/18$
 * ���� szd
 */
public class DictionaryMainTainOperate1Imp implements DictionaryMainTainOperate {

    DatabaseDaoImp dm = new DatabaseDaoImp();

    @Override
    public void updateTreeNode(String id, String tt) {

        String sql = "update NSDB.�ֵ�_ͨ��_���ӷ��� set ���Ӽ��='" + tt + "' where ��������='" + id + "'";
        Connection c = dm.getConnection();
        dm.executeUpdate(sql, c);


        dm.destroy(c);

    }

    @Override
    public void updateTreeStructure(Windows w, String name) {

        String lines[] = Io.readFromTxt("src/main/resources/tree/tree1").split("\\$");
        String newlines[] = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {


        }

        //�������
        w.jp1.removeAll();
        w.jp1.add(w.jt);
        w.jp1.updateUI();
        w.jp1.repaint();
        w.jp1.revalidate();

    }
}
