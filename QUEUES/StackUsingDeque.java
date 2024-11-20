import java.util.*;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        //push 0(1)
        public void push(int data) {
            deque.addLast(data);
        }

        //pop 0(1)
        public int pop() {
            return deque.removeLast();
        }

        //peek 0(1)
        public int peek() {
            return deque.getLast();
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek = "+ s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
