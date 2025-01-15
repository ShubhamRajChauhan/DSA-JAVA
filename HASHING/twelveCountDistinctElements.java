//--------Count Distinct Elements----------------
import java.util.*;

public class twelveCountDistinctElements {
    public static void main(String[] args) {
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        HashSet<Integer> set = new HashSet<>();

        for (int nums : num) {
            set.add(nums);
        }

        System.out.println("ans = " + set.size());  //ans = 7
    }
}
