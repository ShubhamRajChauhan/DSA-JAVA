
import java.util.*;
public class QueueUsingCollections {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(20);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll()); //or remove
        System.out.println(queue.size());
    }
}
