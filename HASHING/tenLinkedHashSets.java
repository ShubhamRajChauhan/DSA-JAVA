//-----------Linked HashSets------------------------

import java.util.*;

public class tenLinkedHashSets {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        //add
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println(lhs); //[Delhi, Mumbai, Noida, Bengaluru]   --> in order


        //remove
        lhs.remove("Delhi");
        System.out.println(lhs); //[Mumbai, Noida, Bengaluru]
    }
}
