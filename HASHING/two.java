//Iteration in HashMap

import java.util.*;

public class two {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        //Iterate 
        Set<String> keys = hm.keySet();  
        System.out.println(keys);  //[China, US, Nepal, India, Indonesia]

        for (String k : keys) {
            System.out.println("key="+k+ ",value="+hm.get(k));
        }
        

        //Iterate using hm.entrySet() //this gives the key value pair 
        Set<Map.Entry<String, Integer>> pair = hm.entrySet();  
        System.out.println(pair);  //[China=150, US=50, Nepal=5, India=100, Indonesia=6]

        for (Map.Entry<String, Integer> k : pair) {
            System.out.println(k);
        }
    }
}
