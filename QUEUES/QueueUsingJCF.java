import java.util.*;

public class QueueUsingJCF {
    public static void main(String[] args) {
        //Queue q = new Queue();
        Queue<Integer> q = new LinkedList<>(); // (or) we can use ArrayDeque
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
