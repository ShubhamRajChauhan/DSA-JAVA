//Convert Binary Tree to Doubly Linked List - FAANG Interview Question


class LLNode {
    int val;
    LLNode prev;
    LLNode next;

    public LLNode(int val) {
        this.val = val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class DoubleLinkedList {
    LLNode head;
    LLNode tail;

    public LLNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root);

        return head; // Returning head of the doubly linked list
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        //Inorder traversal 
        //left
        helper(node.left);

        //current 
        LLNode newNode = new LLNode(node.val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        //right
        helper(node.right);
    }
}

