/* Write a program to get a number from the user and prints 
   whether it is positive or negative. */

import java.util.*;

public class AConditionalStatement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        int number = sc.nextInt();
        if(number > 0) {
            System.out.println("number is greater than 0");
        } else {
            System.out.println("number is less than or equal 0");
        }
    }
}
