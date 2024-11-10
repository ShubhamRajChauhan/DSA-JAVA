import java.util.Scanner;

public class integerSum {
    public static int sum(int n){
        int sum = 0;
        while(n>0){
            int lastDigit = n % 10;
            sum = sum + lastDigit;
            n = n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int integer = sc.nextInt();
        System.out.println(sum(integer));
    }
}
