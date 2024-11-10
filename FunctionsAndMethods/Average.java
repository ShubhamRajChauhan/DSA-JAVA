
import java.util.*;

public class Average {
    public static double average(double a , double b, double c){
        return ((a+b+c)/3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        System.out.println(average(a,b,c));
    }
}
