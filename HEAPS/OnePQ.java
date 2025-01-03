import java.util.Comparator;
import java.util.PriorityQueue;

public class OnePQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //it will give the values in ascending order , means it prioritize the smallest value        
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // now it will give the values in descending order , means now it prioritize the larger value        

        pq.add(3); //0(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()) {
            System.out.println(pq.peek()); //0(1)
            pq.remove(); //0(logn)
        }
    }
}
