public class TypePromotion3 {
    public static void main(String args[]) {
        int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
       // int ans = a + b + c + d;  if int then we get lossy conversion
        double ans = a + b + c + d;  // to yahan pehle sab double mai convert honge fir sabka sum calculate hoga
        System.out.println(ans);
    }
}
