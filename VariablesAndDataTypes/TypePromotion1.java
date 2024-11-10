public class TypePromotion1 {
    public static void main(String args[]) {
        char a = 'a';
        char b = 'b';
        System.out.println((int)(b));
        System.out.println((int)(a));
        System.out.println(a);           //variable ke sath type promotion nahi hota hai    
        System.out.println(b-a);        // type promotion sirf expression (+ , _ , * ) ke sath hota hai
    }
}
