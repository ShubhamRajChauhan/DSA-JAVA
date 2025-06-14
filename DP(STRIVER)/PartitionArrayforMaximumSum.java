//Partition Array for Maximum Sum
//Leetcode -> 1043


//------------------------------Recursion----------------------------------------
/*
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
         return f(0, arr, k);
    }

    static int f(int ind, int[] num, int k) {
        int n = num.length;
        // Base case
        if (ind == n) return 0;

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + f(j + 1, num, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
}
*/









//------------------------------Memoization---------------------------------------
/*
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return f(0, arr, k, dp);
    }

    static int f(int ind, int[] num, int k, int[] dp) {
        int n = num.length;
        // Base case
        if (ind == n) return 0;

        if (dp[ind] != -1) return dp[ind];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + f(j + 1, num, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
}
*/





//------------------------------Tabulation---------------------------------------
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for(int ind = n-1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            
            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }

        return dp[0];
    }
}