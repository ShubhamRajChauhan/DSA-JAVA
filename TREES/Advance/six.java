//99. Recover Binary Search Tree  (or) Correct Binary Tree That Has Two Nodes Swapped

public class six {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);

        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        // Detect misplaced nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        inOrderTraversal(node.right);
    }
}
