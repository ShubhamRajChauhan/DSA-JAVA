import java.util.Scanner;

public class AVL {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Node root;

    
    //height
    public int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }


    //empty
    public boolean isEmpty() {
        return root == null;
    }



    //insert
    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value < node.value) {
            node.left = insert(value, node.left);
        }
        if(value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right) + 1); //height

        return node;
    }



    //populate
    public void populate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }



    //populate sorted
    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }
    private void populatedSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid); //left
        populatedSorted(nums, mid+1, end); //right
    }





    //balanced
    public boolean balanced() {
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if(node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }




    //display
    public void display() {
        display(root, "Root Node: ");
    }
    private void display(Node node, String details) {
        if(node == null) {
            return;
        }
        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums);
        tree.display();
    }
}
