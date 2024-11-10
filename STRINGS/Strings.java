import java.util.*;

public class Strings {
    public static void main(String[] args) {
        //PRINT STRING
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "abcd";
        String str2 = new String("xyz");
        System.out.println(arr);   
        System.out.println(str);   
        System.out.println(str2);   
        
        

        // INPUT/OUTPUT
        System.out.print("Enter a String: ");
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        System.out.println(name);
    }
}
