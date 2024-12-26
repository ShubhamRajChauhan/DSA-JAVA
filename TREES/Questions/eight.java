//226. Invert Binary Tree

import javax.swing.tree.TreeNode;

public class eight {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left =  invertTree(root.left);
        TreeNode right =  invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
