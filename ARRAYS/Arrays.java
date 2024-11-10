import java.util.*;
public class Arrays {
    public static void main(String args[]) {
        int marks[] = new int[100];

        Scanner sc = new Scanner(System.in);

        //System.out.println("length of array = " + marks.length);    this is how we find the length of array

        marks[0] = sc.nextInt(); //phy
        marks[1] = sc.nextInt(); //chem
        marks[2] = sc.nextInt(); //math

        System.out.println("phy : " + marks[0]);
        System.out.println("chem : " + marks[1]);
        System.out.println("math : " + marks[2]);

        marks[2] = 100;     //update
        System.out.println("math : " + marks[2]);

        marks[2] = marks[2] + 1;   //this is marks of 2 + 1  or you can do (*,/,-)
        System.out.println("math : " + marks[2]);

        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("percentage = " + percentage + "%");
    }
}
