import java.util.Scanner;

public class BinaryTree {
    
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    //IMPROVEMENT ON TREE INPUT 
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if(isRoot) {
            System.out.println("Enter root data");
        } else {
            if(isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }   
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }



    //TAKING INPUT
    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root data");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
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


    //PRINT TREE RECURSIVELY 2 --> detailed
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if(root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }
        if(root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1); //root.data = 1;

        // BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        // root.left = rootLeft;
        // root.right = rootRight;

        
        // BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        // BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
        // rootLeft.right = twoRight;
        // rootRight.left = threeLeft;

        //printTree(root);
        //BinaryTreeNode<Integer> root = takeTreeInput();
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);


        // System.out.println("Tree structure:");
        // System.out.println("      " + root.data);
        // System.out.println("     / \\");
        // System.out.println("   " + rootLeft.data + "   " + rootRight.data);
        // System.out.println("    \\   /");
        // System.out.println("    " + twoRight.data + " " + threeLeft.data);
    }
}


