import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        // BI();
        BD();
    }



    // Big Integer
    public static void BI() {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(34675765); // convert int/long to BI
        int c = B.intValue(); // convert BI to int
        BigInteger C = new BigInteger("767676564597647604560457604764");
        BigInteger X = new BigInteger("76745665785855");
        // constants
        BigInteger D = BigInteger.TEN;

        // addition
        BigInteger s = C.add(X);
        // multiplication
        BigInteger m = C.multiply(X);
        // subtraction
        BigInteger sub = C.subtract(X);
        // division
        BigInteger d = C.divide(X);
        // remainder
        BigInteger rem = C.remainder(X);

        System.out.println(rem);

        // comparision
        if (X.compareTo(C) < 0) {
            System.out.println("Yes");
        }

        System.out.println(fact(100));
    }

    // Factorial
    static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");

        for (int i = 2; i <= num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }



    // Big Decimal
    public static void BD() {
        double x = 0.03;
        double y = 0.04;
        // double ans = y - x;
        // System.out.println(ans);// 0.010000000000000002

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans = Y.subtract(X);
        //System.out.println(ans); // 0.01


        BigDecimal a = new BigDecimal("456576345675.4546376");
        BigDecimal b = new BigDecimal("547634565352.986785764");
        // operations
        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));
        System.out.println(b.negate()); //give neg. value of b

        // constants
        BigDecimal con = BigDecimal.ONE;
    }
}
