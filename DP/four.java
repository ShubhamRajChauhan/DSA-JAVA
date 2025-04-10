//Min Cost Path


//------------Recursion---------------------
/* 
public class four {

    public static int minCost(int[][] cost, int i, int j) {
        int m = cost.length;
        int n = cost[0].length;
        //Special Case
        if(i==m-1 && j==n-1) {
            return cost[i][j];
        }
        //Base Case
        if(i>=m || j>=n) {
            return Integer.MAX_VALUE;
        }

        int ans1 = minCost(cost, i+1, j);
        int ans2 = minCost(cost, i, j+1);
        int ans3 = minCost(cost, i+1, j+1);

        int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        return myAns;
    }
    public static void main(String[] args) {
        int[][] cost = {{1,5,11}, {8,13,12}, {2,3,7}, {15,16,18}};
        int ans = minCost(cost,0,0);
        System.out.println(ans);
    }
}
*/



//----------------------Memoization---------------------------------
public class four {

    public static int minCost(int[][] cost, int i, int j, int[][] dp) {
        int m = cost.length;
        int n = cost[0].length;
        //Special Case
        if(i==m-1 && j==n-1) {
            return cost[i][j];
        }
        //Base Case
        if(i>=m || j>=n) {
            return Integer.MAX_VALUE;
        }

        int ans1, ans2, ans3;
        if(dp[i+1][j] == Integer.MIN_VALUE){
            ans1 = minCost(cost, i+1, j, dp);
            dp[i+1][j] = ans1;
        }else {
            ans1 = dp[i+1][j];
        }

        if(dp[i][j+1] == Integer.MIN_VALUE){
            ans2 = minCost(cost, i, j+1, dp);
            dp[i][j+1] = ans2;
        }else {
            ans2 = dp[i][j+1];
        }

        if(dp[i+1][j+1] == Integer.MIN_VALUE){
            ans3 = minCost(cost, i+1, j+1, dp);
            dp[i+1][j+1] = ans3;
        }else {
            ans3 = dp[i+1][j+1];
        }
        

        int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        return myAns;
    }

    public static void main(String[] args) {
        int[][] cost = {{1,5,11}, {8,13,12}, {2,3,7}, {15,16,18}};
        int[][] dp = new int[cost.length+1][cost[0].length+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int ans = minCost(cost,0,0,dp);
        System.out.println(ans);
    }
}
