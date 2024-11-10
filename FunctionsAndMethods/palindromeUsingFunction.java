import java.util.*;
public class palindromeUsingFunction {
    public static void main(String args[]) {
        System.out.println("Enter any number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isPalindrome(n)){
            System.out.println("Number : " + n + " is a palindrome");
        } else{
            System.out.println("Number : " + n + " is not a palindrome");
        }
    }
    public static boolean isPalindrome(int n) {
        int c = n;
        int s = 0;
        while(n>0){
            int r = n % 10;
            s = (s*10) + r;
            n = n/10;
        } 
        //if (c==s){
        //    return true;
        //} else {
        //    return false;
        //}
        return c == s;
    }

    
}
