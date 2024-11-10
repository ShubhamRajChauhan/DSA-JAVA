import java.util.ArrayList;

public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        
        //add element - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Or we can add like 
        //list.add(1,9); //O(n)

        System.out.println(list);


        //Get Element - O(1)
        // int element = list.get(2);
        // System.out.println(element);


        //Delete Element - O(n)
        // list.remove(2);
        // System.out.println(list);


        //Set Element at Index - O(n)
        // list.set(2, 10);
        // System.out.println(list);


        //contains - O(n)
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

    }
}
