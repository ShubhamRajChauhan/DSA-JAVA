//Keep entering number till the user enters a muliple of 10.

import java.util.*;

public class CheckMultipleByBreak {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);

       do{
        System.out.println("enetr your number : ");
        int n = sc.nextInt();

        if(n % 10 == 0) {
            break;
        }
        System.out.println(n);
       }while(true);
    }
}
