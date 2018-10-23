package util;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/30
 * @���� Swing JList��Ⱦ���Զ��� ��Ϊ�������������Ⱦ
 */
public class JTreeComboBoxRenderer extends DefaultListCellRenderer {


    /**
     * @���� ��ȡ��ȾԪ��
     * @���� list����Ҫ���ϵ�ͼ���JComboBox����� valueJComboBox��Ŀֵ����JComboBox.getModel().getElementAt(index)�����ص�ֵ��
     * index JComboBox��Ŀ������ֵ����0��ʼ��
     * isSelected �Ƿ�ѡ�У� cellhasFoucus �Ƿ�۽�
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/9/30
     * @�޸��˺�������Ϣ
     */
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            if (value.toString().contains("[")) {//��·�����й淶���ж� ������[A,A1,A2]����ʽ
                TreePath path = (TreePath) value;
                TreeNode node = (TreeNode) path.getLastPathComponent();
                value = node;

                JTree tree = new JTree();

                TreeCellRenderer r = tree.getCellRenderer();
                JLabel lb = (JLabel) r.getTreeCellRendererComponent(tree,
                        value, isSelected, false, node.isLeaf(), index,
                        cellHasFocus);
                return lb;
            }
        }
        return super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
    }

    /**
     * ����
     */
    public static void main(String args[]) {

//        JFrame frame = new JFrame("JTreeComboBox ����");
//        frame.setSize(400, 320);
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation((d.width - frame.getSize().width) / 2,
//                (d.height - frame.getSize().height) / 2);
//        frame.getContentPane().setLayout(new FlowLayout());
//
//        CreateTree ct = new CreateTree();
//
//        final JTreeComboBox box = new JTreeComboBox(ct.getJTree());
//        box.setPreferredSize(new Dimension(300, 21));
//        frame.getContentPane().add(box);
//        final JButton btt = new JButton("����");
//        btt.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                box.setTree(new JTree());
//                btt.setEnabled(false);
//
//            }
//        });
//        frame.getContentPane().add(btt);
//        frame.setVisible(true);

    }

}
