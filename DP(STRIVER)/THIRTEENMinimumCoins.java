//Leetcode -> 322

//----------------------Recursion-----------------------
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = f(n - 1, amount, coins);
        return ans == (int)1e9 ? -1 : ans;
    }

    int f(int idx,int T, int[] coins) {
        if(idx == 0) {
            if(T % coins[idx] == 0) return T/coins[idx];
            else return (int)1e9; 
        }

        int notTake = 0 + f(idx-1, T, coins);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= T) take = 1 + f(idx, T-coins[idx], coins);
        return Math.min(take, notTake);
    }
}
*/




//-----------------------Memoization----------------------------
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = f(n - 1, amount, coins, dp);
        return ans == (int)1e9 ? -1 : ans;
    }

    int f(int idx,int T, int[] coins, int[][] dp) {
        if(idx == 0) {
            if(T % coins[idx] == 0) return T/coins[idx];
            else return (int)1e9; 
        }

        if(dp[idx][T] != -1) return dp[idx][T];
        int notTake = 0 + f(idx-1, T, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= T) take = 1 + f(idx, T-coins[idx], coins, dp);

        return dp[idx][T] = Math.min(take, notTake);
    }
}
*/





//----------------------Tabulation----------------------------
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        //base case
        for(int T=0; T<=amount; T++) {
            if(T % coins[0] == 0) dp[0][T] = T/coins[0];
            else dp[0][T] = (int)1e9; 
        }

        
        for(int idx = 1; idx < n; idx++) {
            for(int T = 0; T <= amount; T++) {
                int notTake = 0 + dp[idx-1][T];
                int take = Integer.MAX_VALUE;
                if(coins[idx] <= T) take = 1 + dp[idx][T-coins[idx]];

                dp[idx][T] = Math.min(take, notTake);
            }
        }


        int ans = dp[n - 1][amount];
        return ans == (int)1e9 ? -1 : ans;
    }   
}
*/
   





//----------------------Space Optimization----------------------------
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount + 1];
        
        //base case
        for(int T=0; T<=amount; T++) {
            if(T % coins[0] == 0) prev[T] = T/coins[0];
            else prev[T] = (int)1e9; 
        }

        
        for(int idx = 1; idx < n; idx++) {
            int[] cur = new int[amount + 1];
            for(int T = 0; T <= amount; T++) {
                int notTake = 0 + prev[T];
                int take = Integer.MAX_VALUE;
                if(coins[idx] <= T) take = 1 + cur[T-coins[idx]];

                cur[T] = Math.min(take, notTake);
            }
            prev = cur;
        }


        int ans = prev[amount];
        return ans == (int)1e9 ? -1 : ans;
    }   
}
