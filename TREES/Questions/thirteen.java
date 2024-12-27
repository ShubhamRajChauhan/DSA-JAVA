//105. Construct Binary Tree from Preorder and Inorder Traversal

import javax.swing.tree.TreeNode;

public class thirteen {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }

        int r = preorder[0];
        int index = 0;

        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == r) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(r);

        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }
}
