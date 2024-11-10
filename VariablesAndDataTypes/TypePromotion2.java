public class TypePromotion2 {
   public static void main(String args[]) {
    short a = 5;
    byte b = 25;
    char c = 'c';
    //byte bt = a+b+c;   //yahan pr apne aap sabko int mai convert kar diya #rule 1
    byte bt =(byte)(a+b+c);   //if you want to print then use this
    System.out.println(bt);
   } 
}
