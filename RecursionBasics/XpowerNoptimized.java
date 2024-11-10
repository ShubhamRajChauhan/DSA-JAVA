//Print x to the power n (Optimized)
public class XpowerNoptimized {
   public static long pow(int x, int y) {
    if(y == 0) {
        return 1;
    }
    
    if(y % 2 == 0) {
        long result = pow(x,y/2);
        return result * result ;    
    }else {
        return pow(x,y-1) * x;
    }
    
   } 

   public static void main(String[] args) {
    System.out.println(pow(5, 8));
   }
}
