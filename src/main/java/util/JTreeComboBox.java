package util;


import com.sun.java.swing.plaf.motif.MotifComboBoxUI;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.tree.TreePath;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/30
 * @描述 树形下拉列表框的定义
 */

public class  JTreeComboBox extends JComboBox {

    /**
     * 显示用的树
     */
    private JTree tree;

    public JTreeComboBox() {
        this(new JTree());
    }

    public JTreeComboBox(JTree tree) {
        this.setTree(tree);
    }

    /**
     * 设置树
     *
     * @param tree JTree
     */
    public void setTree(JTree tree) {
        this.tree = tree;
        if (tree != null) {
            this.setSelectedItem(tree.getSelectionPath());
            this.setRenderer(new JTreeComboBoxRenderer());
        }
        this.updateUI();
    }

    /**
     * 取得树
     *
     * @return JTree
     */
    public JTree getTree() {
        return tree;
    }

    /**
     * 设置当前选择的树路径
     *
     * @param o Object
     */
    public void setSelectedItem(Object o) {
        //System.out.println(o.toString()+"====");
        if (o != null) {

            if (o.toString().contains("[")) {

                tree.setSelectionPath((TreePath) o);

                String path = o.toString().trim().split("\\,")[2].replace("]", "");
                System.out.println(o.toString() + "===path=" + path);
                getModel().setSelectedItem(path);

            }
        }
    }

    public void updateUI() {
        ComboBoxUI cui = (ComboBoxUI) UIManager.getUI(this);
        if (cui instanceof MetalComboBoxUI) {
            cui = new MetalJTreeComboBoxUI();
        } else if (cui instanceof MotifComboBoxUI) {
            cui = new MotifJTreeComboBoxUI();
        } else {
            cui = new WindowsJTreeComboBoxUI();
        }
        setUI(cui);
    }

    // UI Inner classes -- one for each supported Look and Feel
    class MetalJTreeComboBoxUI extends MetalComboBoxUI {
        protected ComboPopup createPopup() {
            return new TreePopup(comboBox);
        }
    }

    class WindowsJTreeComboBoxUI extends WindowsComboBoxUI {
        protected ComboPopup createPopup() {
            return new TreePopup(comboBox);
        }
    }

    class MotifJTreeComboBoxUI extends MotifComboBoxUI {
        protected ComboPopup createPopup() {
            return new TreePopup(comboBox);
        }
    }
}