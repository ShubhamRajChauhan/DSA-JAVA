//Best Time to Buy and Sell Stock III
//Leetcode -> 123



//-----------------------------Recursion--------------------------

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return f(0, 1, 2, prices, n);
    }

    int f(int idx, int buy, int cap, int[] prices, int n) {
        //base case
        if(idx == n || cap == 0) return 0;
    
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, cap, prices, n),
                                0 + f(idx+1, 1, cap, prices, n));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, cap-1, prices, n),
                                0 + f(idx+1, 0, cap, prices, n));
        }
        return profit;
    }
}






//----------------------------Memoization-------------------------

class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return f(0, 1, 2, prices, n, dp);
    }

    int f(int idx, int buy, int cap, int[] prices, int n, int[][][] dp) {
        //base case
        if(idx == n || cap == 0) return 0;

        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, cap, prices, n, dp),
                                0 + f(idx+1, 1, cap, prices, n, dp));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, cap-1, prices, n, dp),
                                0 + f(idx+1, 0, cap, prices, n, dp));
        }
        return dp[idx][buy][cap] = profit;
    }
}






//------------------------Tabulation------------------------

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];
        
        //the base cases will return 0, as you see in recursion and memoization code , so no need to write the base cases, as dp already initialized with 0

        for(int idx=n-1; idx>=0; idx--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=2; cap++) { //we start from 1 because at cap=0 , the values is 0 , that already stored in the dp
                    int profit = 0;
                    if(buy == 1) { //buy
                        profit = Math.max(-prices[idx] + dp[idx+1][0][cap],
                                                     0 + dp[idx+1][1][cap]);
                    } 
                    else { //sell
                        profit = Math.max(prices[idx] + dp[idx+1][1][cap-1],
                                                    0 + dp[idx+1][0][cap]);
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}






//------------------------Space Optimization------------------------
class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][3]; 
        int[][] cur = new int[2][3];   
 
        
        //the base cases will return 0, as you see in recursion and memoization code , so no need to write the base cases, as dp already initialized with 0

        for(int idx=n-1; idx>=0; idx--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=2; cap++) { //we start from 1 because at cap=0 , the values is 0 , that already stored in the dp
                    int profit = 0;
                    if(buy == 1) { //buy
                        profit = Math.max(-prices[idx] + ahead[0][cap],
                                                     0 + ahead[1][cap]);
                    } 
                    else { //sell
                        profit = Math.max(prices[idx] + ahead[1][cap-1],
                                                    0 + ahead[0][cap]);
                    }
                    cur[buy][cap] = profit;
                }
            }
            ahead = cur;
        }

        return ahead[1][2];
    }
}