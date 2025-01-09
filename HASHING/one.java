//----------Hashmap Operations---------

import java.util.*;

public class one {
    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - 0(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm); //{China=150, US=50, India=100}

        //Get - 0(1)
        int population = hm.get("India");
        System.out.println(population); //100

        System.out.println(hm.get("Russia")); //null


        //ContainsKey - 0(1)
        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("Russia")); //false

        //Remove - 0(1)
        System.out.println(hm.remove("China")); //150
        System.out.println(hm); //{US=50, India=100}
        System.out.println(hm.remove("Russia")); //null

        //Size
        System.out.println(hm.size()); //2

        //IsEmpty
        System.out.println(hm.isEmpty()); //false

        //clear
        hm.clear(); //clear all the data in the hashmap
        System.out.println(hm.isEmpty()); //true

    }
}
