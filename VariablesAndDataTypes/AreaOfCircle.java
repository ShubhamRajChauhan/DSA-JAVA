import java.util.*;

public class AreaOfCircle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float radius = sc.nextFloat();
        float area = 3.14f * radius * radius;      //java automatic decimal value ko double consider 
        System.out.println(area);                  //kar leta hai ,ishliye hame [f] lagana hai jo 
                                                   //batayega ye float hai  ~ 3.14f

    }
    
}
