import java.util.*;
public class palindrome {
    public static void main(String args[]){
        int n, s=0, c, r;
        System.out.print("Enter any number: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = n;
        while(n>0)
        {
            r = n % 10;
            s = (s*10) + r;
            n = n/10;
        } 
        if (c == s){ 
            System.out.print("Palindrome Number");
        } else{
            System.out.print("Not Palindrome Number");
        }
    }
}
