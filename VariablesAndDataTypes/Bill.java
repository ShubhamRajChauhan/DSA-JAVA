import java.util.*;

public class Bill {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        float total = pencil + pen + eraser;
       // System.out.println(total);
        System.out.println("Bill is : " + total );

        //Add on - with 18% tax
        float newTotal = total + (0.18f * total);
       // System.out.print(newTotal);
       System.out.print("Bill with 18% tax : " +newTotal);
    }
    
}
