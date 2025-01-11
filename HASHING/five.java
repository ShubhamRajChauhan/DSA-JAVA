//---------------TreeMap------------------
import java.util.*;

public class five {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);

        System.out.println(tm);  //{China=150, India=100, US=50}  -->alphabetically order 
    }
}
