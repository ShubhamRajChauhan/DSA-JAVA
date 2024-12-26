//543. Diameter of Binary Tree

import javax.swing.tree.TreeNode;



public class seven {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }
    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}


//----------------------OR-----------------------------------------
public class seven {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { 
            return 0;
        }
        return diameter(root); 
    }
    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
     public static int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDiam = diameter(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt ; //int selfDiam = leftHt + rightHt + 1 ;  remove +1 because we have to calculate edge 

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
     }
}