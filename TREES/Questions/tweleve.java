//230. Kth Smallest Element in a BST

import javax.swing.tree.TreeNode;

public class tweleve {
    int pos = 0;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k).val;
    }
    public TreeNode inorder(TreeNode root, int k) {
        if(root == null) {
            return root;
        }
        TreeNode left = inorder(root.left, k);
        if(left != null) {
            return left;
        }

        pos++;

        if(pos == k) {
            return root;
        }

        return inorder(root.right, k);
    }
}
