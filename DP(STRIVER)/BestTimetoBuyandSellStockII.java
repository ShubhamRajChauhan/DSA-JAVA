//Best Time to Buy and Sell Stock II
//Leetcode -> 122


//-------------------------Recursion----------------------------

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return f(0, 1, prices, n);
    }

    int f(int idx, int buy, int[] prices, int n) {
        //base case
        if(idx == n) return 0;


        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, prices, n),
                                0 + f(idx+1, 1, prices, n));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, prices, n),
                                0 + f(idx+1, 0, prices, n));
        }
        return profit;
    }
}






//------------------------Memoization---------------------------

class Solution1 {
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
        if(idx == n) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 1) { //buy
            profit = Math.max(-prices[idx] + f(idx+1, 0, prices, n, dp),
                                0 + f(idx+1, 1, prices, n, dp));
        } 
        else { //sell
            profit = Math.max(prices[idx] + f(idx+1, 1, prices, n, dp),
                                0 + f(idx+1, 0, prices, n, dp));
        }
        return dp[idx][buy] = profit;
    }
}







//------------------------Tabulation----------------------------

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        
        dp[n][0] = dp[n][1] = 0;
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) { //buy
                    profit = Math.max(-prices[idx] + dp[idx+1][0],
                                        0 + dp[idx+1][1]);
                } 
                else { //sell
                    profit = Math.max(prices[idx] + dp[idx+1][1],
                                        0 + dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}








//----------------------Space Optimization---------------------------

class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[]ahead = new int[2];
        int[]cur = new int[2];
        
        ahead[0] = ahead[1] = 0;
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) { //buy
                    profit = Math.max(-prices[idx] + ahead[0],
                                        0 + ahead[1]);
                } 
                else { //sell
                    profit = Math.max(prices[idx] + ahead[1],
                                        0 + ahead[0]);
                }
                cur[buy] = profit;
            }

            ahead = cur;
        }
        return ahead[1];
    }
}





//----------------------Space Optimization (way 2)---------------------------

class Solution4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int aheadNotBuy, aheadBuy, curNotBuy, curBuy;
        aheadNotBuy = aheadBuy = 0;
        for(int idx = n-1; idx >= 0; idx--) {
            //buy
            curBuy = Math.max(-prices[idx] + aheadNotBuy,
                                        0 + aheadBuy);
              
            //sell
            curNotBuy = Math.max(prices[idx] + aheadBuy,
                                        0 + aheadNotBuy);
            
        

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }
        return aheadBuy;
    }
}
