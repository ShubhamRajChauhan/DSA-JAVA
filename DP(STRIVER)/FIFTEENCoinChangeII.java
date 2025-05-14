//Leetcode -> 518



//----------------------Recursion-----------------------

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int ans = f(n - 1, amount, coins);
        return ans; 
        
    }

    int f(int idx,int T, int[] coins) {
        if(idx == 0) {
            if(T % coins[idx] == 0) return 1;
            else return 0; 
        }

        int notTake = f(idx-1, T, coins);
        int take = 0;
        if(coins[idx] <= T) take = f(idx, T-coins[idx], coins);
        return take + notTake;
    }
}





//-----------------------Memoization----------------------------

class Solution1 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = f(n - 1, amount, coins, dp);
        return ans;
    }

    int f(int idx,int T, int[] coins, int[][] dp) {
        if(idx == 0) {
            if(T % coins[idx] == 0) return 1;
            else return 0; 
        }

        if(dp[idx][T] != -1) return dp[idx][T];
        int notTake = f(idx-1, T, coins, dp);
        int take = 0;
        if(coins[idx] <= T) take = f(idx, T-coins[idx], coins, dp);

        return dp[idx][T] = take + notTake;
    }
}






//----------------------Tabulation----------------------------

class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        //base case
        for(int T=0; T<=amount; T++) {
            if(T % coins[0] == 0) dp[0][T] = 1;
            else dp[0][T] = 0; 
        }

        
        for(int idx = 1; idx < n; idx++) {
            for(int T = 0; T <= amount; T++) {
                int notTake = dp[idx-1][T];
                int take = 0;
                if(coins[idx] <= T) take = dp[idx][T-coins[idx]];

                dp[idx][T] = take + notTake;
            }
        }

        int ans = dp[n - 1][amount];
        return ans;
    }   
}

   





//----------------------Space Optimization----------------------------

class Solution3 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];
        
        //base case
        for(int T=0; T<=amount; T++) {
            if(T % coins[0] == 0) prev[T] = 1;
            else prev[T] = 0; 
        }

        
        for(int idx = 1; idx < n; idx++) {
            int[] cur = new int[amount + 1];
            for(int T = 0; T <= amount; T++) {
                int notTake = prev[T];
                int take = 0;
                if(coins[idx] <= T) take = cur[T-coins[idx]];

                cur[T] = take + notTake;
            }
            prev = cur;
        }


        int ans = prev[amount];
        return ans;
    }   
}

