public class JConcept {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        //fun(n--);  //give stack overflow error
        fun(--n); //5 4 3 2 1
    }
}

/* 
# n-- vs --n

A. n-- first pass the value of n then subtract , so in our function it passing 5 again and again
B. --n first subtract then pass the value of n


 */
