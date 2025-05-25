//Best Time to Buy and Sell Stock IV
//Leetcode -> 188

//-----------------------------Recursion--------------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return f(0, 1, k, prices, n);
    }

    int f(int idx, int buy, int k, int[] prices, int n) {
        //base case
        if(idx == n || k == 0) return 0;
    
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, k, prices, n),
                                0 + f(idx+1, 1, k, prices, n));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, k-1, prices, n),
                                0 + f(idx+1, 0, k, prices, n));
        }
        return profit;
    }
}
*/




//----------------------------Memoization-------------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int K = 0; K < k+1; K++) {
                    dp[i][j][K] = -1;
                }
            }
        }

        return f(0, 1, k, prices, n, dp);
    }

    int f(int idx, int buy, int k, int[] prices, int n, int[][][] dp) {
        //base case
        if(idx == n || k == 0) return 0;

        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, k, prices, n, dp),
                                0 + f(idx+1, 1, k, prices, n, dp));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, k-1, prices, n, dp),
                                0 + f(idx+1, 0, k, prices, n, dp));
        }
        return dp[idx][buy][k] = profit;
    }
}
*/




//------------------------Tabulation------------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];
        
        //the base cases will return 0, as you see in recursion and memoization code , so no need to write the base cases, as dp already initialized with 0

        for(int idx=n-1; idx>=0; idx--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=k; cap++) { //we start from 1 because at k=0 , the values is 0 , that already stored in the dp
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

        return dp[0][1][k];
    }
}
*/




//------------------------Space Optimization------------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][k+1]; 
        int[][] cur = new int[2][k+1];   
 
        
        //the base cases will return 0, as you see in recursion and memoization code , so no need to write the base cases, as dp already initialized with 0

        for(int idx=n-1; idx>=0; idx--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=k; cap++) { //we start from 1 because at cap=0 , the values is 0 , that already stored in the dp
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

        return ahead[1][k];
    }
}
*/



//--------------------------------ANOTHER WAY---------------------------------------

//----------------------Recursion----------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return f(0, 0, prices, n, k);
    }

    int f(int idx, int tranNo, int[] prices, int n, int k) {
        if(idx == n || tranNo == 2*k) return 0;

        //instead of doing like previously means taking profit then return , we can also return directly
        if(tranNo % 2 == 0) { //buy
            return Math.max(-prices[idx] + f(idx+1, tranNo + 1, prices, n, k),
                                       0 + f(idx+1, tranNo, prices, n, k));
        } 
        else { //sell
            return Math.max(prices[idx] + f(idx+1, tranNo + 1, prices, n, k),
                                       0 + f(idx+1, tranNo, prices, n, k));
        }
    }
}
*/




//----------------------Memoization------------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2*k];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(0, 0, prices, n, k, dp);
    }

    int f(int idx, int tranNo, int[] prices, int n, int k, int[][] dp) {
        if(idx == n || tranNo == 2*k) return 0;

        if(dp[idx][tranNo] != -1) return dp[idx][tranNo];
        if(tranNo % 2 == 0) { //buy
            return dp[idx][tranNo] = Math.max(-prices[idx] + f(idx+1, tranNo + 1, prices, n, k, dp),
                                       0 + f(idx+1, tranNo, prices, n, k, dp));
        } 
        else { //sell
            return dp[idx][tranNo] = Math.max(prices[idx] + f(idx+1, tranNo + 1, prices, n, k, dp),
                                       0 + f(idx+1, tranNo, prices, n, k, dp));
        }
    }
}
*/






//---------------------Tabulation-----------------------
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2*k + 1];
        
        //no need to write base case , because it returns 0, and dp is already initialized with 0

        for(int idx = n-1; idx>=0; idx--) {
            for(int tranNo = 2*k -1; tranNo>=0; tranNo--) { //starts from 2*k-1 because at 2*k the value is 0
                if(tranNo % 2 == 0) { //buy
                    dp[idx][tranNo] = Math.max(-prices[idx] + dp[idx+1][tranNo + 1],
                                                          0 + dp[idx+1][tranNo]);
                } 
                else { //sell
                    dp[idx][tranNo] = Math.max(prices[idx] + dp[idx+1][tranNo + 1],
                                                         0 + dp[idx+1][tranNo]);
                }
            }
        }

        return dp[0][0];
    }
}
*/





//--------------------Space Optimization----------------------
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] ahead = new int[2*k + 1];
        int[] cur = new int[2*k + 1];
        
        //no need to write base case , because it returns 0, and dp is already initialized with 0

        for(int idx = n-1; idx>=0; idx--) {
            for(int tranNo = 2*k -1; tranNo>=0; tranNo--) { //starts from 2*k-1 because at 2*k the value is 0
                if(tranNo % 2 == 0) { //buy
                    cur[tranNo] = Math.max(-prices[idx] + ahead[tranNo + 1],
                                                          0 + ahead[tranNo]);
                } 
                else { //sell
                    cur[tranNo] = Math.max(prices[idx] + ahead[tranNo + 1],
                                                         0 + ahead[tranNo]);
                }
            }
            ahead = cur;
        }

        return ahead[0];
    }
}