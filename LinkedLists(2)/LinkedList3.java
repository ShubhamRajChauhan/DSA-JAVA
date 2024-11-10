     //ZIG-ZAG or Reorder List
public class LinkedList3 {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail; 
    public static int size;

    //add First
    public void addFirst(int data) {
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        //step2 - newNode next = head
        newNode.next = head; //link

        //step3 - head = newNode
        head = newNode;
    }

    //add Last
    public void addLast(int data) {
        //step1 - create new node
        Node newNode = new Node(data);
        size++; 
        if(head == null) {
            head = tail = newNode;
            return;
        }

        //step2 - tail.next = newNode
        tail.next = newNode;
        //step3 - tail = newNode
        tail = newNode;
    }

    //Print LinkedList - O(n)
    public void print() {
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;

        //alternate merge or zig-zag merge
        Node nextL, nextR;
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedList3 ll = new LinkedList3();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        //ll.addLast(6);
        //1->2->3->4->5

        ll.print();
        ll.zigZag();
        ll.print();
    }
}
