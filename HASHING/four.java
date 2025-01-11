//------------LinkedHashMap-----------

import java.util.*;

public class four {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        System.out.println(lhm);  //{India=100, China=150, US=50}   //in same order that you inserted
    }
}
 