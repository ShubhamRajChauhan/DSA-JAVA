//131. Implementing Binary Tree Node Class

public class BinaryTree {
    
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1); //root.data = 1;

        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);

        rootLeft.right = twoRight;
        rootRight.left = threeLeft;


        System.out.println("Tree structure:");
        System.out.println("      " + root.data);
        System.out.println("     / \\");
        System.out.println("   " + rootLeft.data + "   " + rootRight.data);
        System.out.println("    \\   /");
        System.out.println("    " + twoRight.data + " " + threeLeft.data);
    }
}
