
public class Odd_Even {
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            //even number
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }

    public static void main(String[] args) {
        oddOrEven(3);
        oddOrEven(11);
        oddOrEven(14);
    }
}
