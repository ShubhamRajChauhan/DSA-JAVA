//Longest Increasing Subsequence
//Leetcode -> 300


//------------------------------Recursion-----------------------------
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return f(0, -1, nums, n);
    }

    int f(int idx, int prev_idx, int[] nums, int n) {
        if(idx == n) return 0;

        //notTake
        int len = 0 + f(idx+1, prev_idx, nums, n);
        //Take
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
            len = Math.max(len, 1 + f(idx+1, idx, nums, n));
        }

        return len;
    }
}
*/




//-----------------------------Memoization----------------------------
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(0, -1, nums, n, dp);
    }

    int f(int idx, int prev_idx, int[] nums, int n, int[][] dp) {
        if(idx == n) return 0;

        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];
        //notTake
        int len = 0 + f(idx+1, prev_idx, nums, n, dp);
        //Take
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
            len = Math.max(len, 1 + f(idx+1, idx, nums, n, dp));
        }

        return dp[idx][prev_idx+1] = len;
    }
}