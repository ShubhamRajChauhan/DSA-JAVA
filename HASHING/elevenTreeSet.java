//-----------------TreeSet------------------

import java.util.*;

public class elevenTreeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        //add
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");

        System.out.println(ts);  //[Bengaluru, Delhi, Mumbai, Noida]  --> sorted in ascending alphabetically order
    }
}
