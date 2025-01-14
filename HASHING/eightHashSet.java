// --------HashSet Operations----------
import java.util.*;

public class eightHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();


        //add - 0(1)
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);  //[1, 2, 4]

        //contains - 0(1)
        if(set.contains(2)) {
            System.out.println("set contains 2"); //set contains 2
        }

        //remove - 0(1)
        set.remove(2);
        if(set.contains(2)) {
            System.out.println("set contains 2"); //now nothing will print
        }

        //size
        System.out.println(set); //[1, 4]
        System.out.println(set.size()); //2

        //clear
        set.clear();
        System.out.println(set); //[]
        System.out.println(set.size()); //0

        //isEmpty
        System.out.println(set.isEmpty()); //true
        
    }
}
