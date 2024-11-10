public class LargestOfThree {
    public static void main(String args[]) {
        int A = 1, B = 3, C = 6;

        if( (A >= B) && (A >= C)) {
            System.out.println("largest is A");
        }
        else if(B >= C) {
            System.out.print("largest is B");
        }
        else {
            System.out.println("largest is C");
        }
    }
}
