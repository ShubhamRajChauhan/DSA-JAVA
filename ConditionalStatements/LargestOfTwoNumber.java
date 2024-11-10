public class LargestOfTwoNumber {
    public static void main(String args[]) {
        int A = 10;
        int B = 5;
        // if statement is single then no need to use currley braces with if 
        // if(A >= B)
        // System.out.println("A is greater of 2");
        // else{
        //   System.out.println("B is largest of 2");
        // }
             

        if(A >= B) { 
            System.out.println("A is greater of 2");
            System.out.println("A>=B");   // you can write multiple statements   
        } else {
            System.out.println("B is largest of 2");
        }
    }
}
