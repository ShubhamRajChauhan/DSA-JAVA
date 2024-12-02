

public class BinaryTree {
    
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    //PRINT TREE RECURSIVELY 1
    public static void printTree(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
        // if(root.left != null) {
        //     printTree(root.left);
        // }
        // if(root.right != null) {
        //     printTree(root.right);
        // }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1); //root.data = 1;

        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        root.left = rootLeft;
        root.right = rootRight;

        printTree(root);

        // BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        // BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);

        // rootLeft.right = twoRight;
        // rootRight.left = threeLeft;


        // System.out.println("Tree structure:");
        // System.out.println("      " + root.data);
        // System.out.println("     / \\");
        // System.out.println("   " + rootLeft.data + "   " + rootRight.data);
        // System.out.println("    \\   /");
        // System.out.println("    " + twoRight.data + " " + threeLeft.data);
    }
}
