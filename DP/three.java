//Minimum Squares Needed to Represent N


//--------------USING RECURSION------------------
/* 
public class three {

    public static int minSquares(int n) {
        if(n==0) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++) {
            int currAns = minSquares(n-(i*i));
            if(minAns > currAns) {
                minAns = currAns;
            }
        }
        int myAns = 1 + minAns;
        return myAns;
    }
    public static void main(String[] args) {
        int n = 41;
        int ans = minSquares(n);
        System.out.println(ans);
    }
}
*/


//-------------------USING RECURSIVE DP--------------------------
public class three {

    public static int minSquares(int n, int[] dp) {
        if(n==0) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++) {
            int currAns;
            if(dp[n-(i*i)] == -1) {
                currAns = minSquares(n-(i*i), dp);
                dp[n-(i*i)] = currAns;
            }else {
                currAns = dp[n-(i*i)];
            }
            if(minAns > currAns) {
                minAns = currAns;
            }
        }
        int myAns = 1 + minAns;
        return myAns;
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        for(int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }

        int ans = minSquares(n, dp);
        System.out.println(ans);
    }
}
