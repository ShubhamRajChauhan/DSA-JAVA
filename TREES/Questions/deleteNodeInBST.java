//Delete a Node in BST

import javax.swing.tree.TreeNode;

public class deleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) { //  null check for root.
            return null;
        }

        if(root.val < key ) {
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else { //voila case - (root.val == key)
            //case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2 - single child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //case 3 - both children
            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }

        return root;
    }

    public TreeNode findInorderSuccessor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
