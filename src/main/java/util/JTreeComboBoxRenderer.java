package util;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/30
 * @描述 Swing JList渲染器自定义 作为树形下拉框的渲染
 */
public class JTreeComboBoxRenderer extends DefaultListCellRenderer {


    /**
     * @描述 获取渲染元素
     * @参数 list即所要画上的图像的JComboBox组件， valueJComboBox项目值，如JComboBox.getModel().getElementAt(index)所返回的值，
     * index JComboBox项目的索引值，由0开始，
     * isSelected 是否被选中， cellhasFoucus 是否聚焦
     * @返回值
     * @创建人 szd
     * @创建时间 2018/9/30
     * @修改人和其它信息
     */
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            if (value.toString().contains("[")) {//对路径进行规范化判断 必须是[A,A1,A2]的样式
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
     * 测试
     */
    public static void main(String args[]) {

//        JFrame frame = new JFrame("JTreeComboBox 例子");
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
//        final JButton btt = new JButton("保存");
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
