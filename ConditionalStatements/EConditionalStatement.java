/* Write a java program that takes a year from the user and print whether that
   year is a leap year or not. */

/*     for leap year
       condition 1 : year % 100 == 0 && year % 400 == 0
       condition 2 : year % 100 != 0 && year % 4 == 0 
 
 */




import java.util.*;

public class EConditionalStatement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the year : ");
        int year = sc.nextInt();
        
        // boolean x = ((year % 100 == 0) && (year % 400 == 0));
        //   boolean y = ((year % 100 != 0) && (year % 4 == 0));
        //   if(x || y) {
        //       System.out.println("Leap Year");
        //   } else {
        //       System.out.println("Not Leap Year");
        //  } 

        if(year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not Leap Year");
        } 
    }
    
}
