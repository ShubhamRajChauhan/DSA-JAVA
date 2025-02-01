import java.util.*;


public class AHashMap {

    public static void main(String[] args) {
         
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        System.out.println(map.get("Karan")); // 99
        System.out.println(map.getOrDefault("Apoorv", 78)); // agar apporv map mai nhi hai to 78 return karega as a default value
        System.out.println(map.containsKey("Karan")); // true


        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);
        set.add(2);

        System.out.println(set); //[2, 56, 9, 43, 12]  --> no duplicate values
       

       
    }
}
