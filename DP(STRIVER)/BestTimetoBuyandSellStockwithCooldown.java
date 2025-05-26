//Best Time to Buy and Sell Stock with Cooldown
//Leetcode -> 309

//-------------------------Recursion----------------------------
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return f(0, 1, prices, n);
    }

    int f(int idx, int buy, int[] prices, int n) {
        //base case
        if(idx >= n) return 0;


        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, prices, n),
                                0 + f(idx+1, 1, prices, n));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+2, 1, prices, n),
                                0 + f(idx+1, 0, prices, n));
        }
        return profit;
    }
}
*/






//------------------------Memoization---------------------------
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, 1, prices, n, dp);
    }

    int f(int idx, int buy, int[] prices, int n, int[][] dp) {
        //base case
        if(idx >= n) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, prices, n, dp),
                                0 + f(idx+1, 1, prices, n, dp));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+2, 1, prices, n, dp),
                                0 + f(idx+1, 0, prices, n, dp));
        }
        return dp[idx][buy] = profit;
    }
}
*/





//------------------------Tabulation----------------------------
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+2][2];
        
        
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) { //buy
                    profit = Math.max(-prices[idx] + dp[idx+1][0],
                                        0 + dp[idx+1][1]);
                } 
                else { //sell
                    profit = Math.max(prices[idx] + dp[idx+2][1],
                                        0 + dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
*/





//------------------------Tabulation(2nd way)----------------------------
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+2][2];
        
        
        for(int idx = n-1; idx >= 0; idx--) {
            
            dp[idx][1] = Math.max(-prices[idx] + dp[idx+1][0],
                                        0 + dp[idx+1][1]);
               
               
            dp[idx][0] = Math.max(prices[idx] + dp[idx+2][1],
                                        0 + dp[idx+1][0]);
                 
        }
        return dp[0][1];
    }
}
*/






//----------------------Space Optimization---------------------------

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[]ahead2 = new int[2];
        int[]ahead1 = new int[2];
         
        
       
        for(int idx = n-1; idx >= 0; idx--) {
            int[]cur = new int[2];

            cur[1] = Math.max(-prices[idx] + ahead1[0],
                                         0 + ahead1[1]);
                           
            cur[0] = Math.max(prices[idx] + ahead2[1],
                                         0 + ahead1[0]);
            ahead2 = ahead1;
            ahead1 = cur;
                 
        }
        return ahead1[1];
     }
 }







