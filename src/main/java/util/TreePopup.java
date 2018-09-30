package util;

import javax.swing.*;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/30
 * @描述
 */
public class TreePopup extends JPopupMenu implements ComboPopup {

    protected JTreeComboBox comboBox;
    protected JScrollPane scrollPane;

    protected MouseMotionListener mouseMotionListener;
    protected MouseListener mouseListener;
    private MouseListener treeSelectListener = new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
            JTree tree = (JTree) e.getSource();
            TreePath tp = tree.getPathForLocation(e.getPoint().x,
                    e.getPoint().y);
            if (tp == null) {
                return;
            }

            System.out.println("===="+tp.toString());//展示树路径

            // Object[] t=tp.getPath();

            comboBox.setSelectedItem(tp);
            togglePopup();
            MenuSelectionManager.defaultManager().clearSelectedPath();
        }
    };

    public TreePopup(JComboBox comboBox) {
        this.comboBox = (JTreeComboBox) comboBox;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        setLightWeightPopupEnabled(comboBox.isLightWeightPopupEnabled());
        JTree tree = this.comboBox.getTree();
        if (tree != null) {
            scrollPane = new JScrollPane(tree);
            scrollPane.setBorder(null);
            add(scrollPane, BorderLayout.CENTER);
            tree.addMouseListener(treeSelectListener);
        }
    }

    public void show() {
        updatePopup();
        try {
            show(comboBox, 0, comboBox.getHeight());
            comboBox.getTree().requestFocus();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void hide() {
        setVisible(false);
        comboBox.firePropertyChange("popupVisible", true, false);
    }

    protected JList list = new JList();

    public JList getList() {
        return list;
    }

    public MouseMotionListener getMouseMotionListener() {
        if (mouseMotionListener == null) {
            mouseMotionListener = new MouseMotionAdapter() {
            };
        }
        return mouseMotionListener;
    }

    public KeyListener getKeyListener() {
        return null;
    }

    public void uninstallingUI() {
    }

    /**
     * Implementation of ComboPopup.getMouseListener().
     *
     * @return a <code>MouseListener</code> or null
     * @see ComboPopup#getMouseListener
     */
    public MouseListener getMouseListener() {
        if (mouseListener == null) {
            mouseListener = new InvocationMouseHandler();
        }
        return mouseListener;
    }

    protected void togglePopup() {
        if (isVisible()) {
            hide();
        } else {
            show();
        }
    }

    protected void updatePopup() {
        setPreferredSize(new Dimension(comboBox.getSize().width, 200));
        Object selectedObj = comboBox.getSelectedItem();
        if (selectedObj != null) {

            if(selectedObj.toString().contains("[")) {
                TreePath tp = (TreePath) selectedObj;
                ((JTreeComboBox) comboBox).getTree().setSelectionPath(tp);
            }
        }
    }

    protected class InvocationMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (!SwingUtilities.isLeftMouseButton(e) || !comboBox.isEnabled()) {
                return;
            }
            if (comboBox.isEditable()) {
                Component comp = comboBox.getEditor().getEditorComponent();
                if ((!(comp instanceof JComponent))
                        || ((JComponent) comp).isRequestFocusEnabled()) {
                    comp.requestFocus();
                }
            } else if (comboBox.isRequestFocusEnabled()) {
                comboBox.requestFocus();
            }
            togglePopup();
        }
    }
}
