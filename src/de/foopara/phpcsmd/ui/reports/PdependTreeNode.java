package de.foopara.phpcsmd.ui.reports;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class PdependTreeNode extends DefaultMutableTreeNode {

    public PdependTreeNode(Object o) {
        super(o);
    }

    protected static class NodeComparator implements Comparator<TreeNode>, Serializable {

        public static final long serialVersionUID = 1L;

        @Override
        public int compare(TreeNode o1, TreeNode o2) {
            if (o1 == null || o1.toString() == null) {
                return -1;
            }
            if (o2 == null || o2.toString() == null) {
                return 1;
            }
            return o1.toString().compareToIgnoreCase(o2.toString());
        }

    }

    protected NodeComparator nodeComparator = new NodeComparator();

    @Override
    public void insert(MutableTreeNode newChild, int childIndex) {
        super.insert(newChild, childIndex);
        Collections.<TreeNode>sort(this.children, this.nodeComparator);
    }
}
