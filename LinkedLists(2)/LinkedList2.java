          //MERGE SORT

public class LinkedList2 {
    // Node class representing each element of the linked list
    public static class Node {
        int data;
        Node next;

        // Constructor to initialize the node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked list properties: head, tail, and size
    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node at the start of the linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Method to print the linked list
    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to find the middle node of the linked list
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; // fast starts from head.next to find mid correctly

        // Fast pointer moves two steps while slow pointer moves one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow pointer will now be at the mid node
    }

    // Method to merge two sorted linked lists into one sorted list
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Temporary dummy node to form merged list
        Node temp = mergedLL;

        // Merging two lists by comparing their data
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next; // Move temp pointer forward
        }

        // Add remaining nodes of head1 (if any)
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // Add remaining nodes of head2 (if any)
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // Return the merged list, skipping the dummy node
    }

    // Method to sort the linked list using merge sort algorithm
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: If the list is empty or has one element, it's already sorted
        }

        // Find the middle node
        Node mid = getMid(head);

        // Divide the list into two halves
        Node rightHead = mid.next; // Start of the second half
        mid.next = null; // Break the list into two halves

        // Recursively sort both halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the two sorted halves
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();

        // Add elements to the linked list
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // List: 5 -> 4 -> 3 -> 2 -> 1

        // Print the original linked list
        ll.print();

        // Sort the linked list using merge sort
        ll.head = ll.mergeSort(ll.head);

        // Print the sorted linked list
        ll.print();
    }
}
