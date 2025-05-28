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
/*
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
*/




//----------------------------Tabulation---------------------------
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][n+1];
        
        for(int idx = n-1; idx>=0; idx--) {
            for(int prev_idx = idx-1; prev_idx>=-1; prev_idx--) {
                //notTake
                int len = 0 + dp[idx+1][prev_idx + 1];
                //Take
                if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
                    len = Math.max(len, 1 + dp[idx+1][idx+1]);
                }
                dp[idx][prev_idx+1] = len;
            }
        }

        return dp[0][-1+1];
    }
}
*/







//----------------------------Space Optimization---------------------------
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] next = new int[n+1];
        int[] cur = new int[n+1];
        
        for(int idx = n-1; idx>=0; idx--) {
            for(int prev_idx = idx-1; prev_idx>=-1; prev_idx--) {
                //notTake
                int len = 0 + next[prev_idx + 1];
                //Take
                if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
                    len = Math.max(len, 1 + next[idx+1]);
                }
                cur[prev_idx+1] = len;
            }
            next = cur;
        }

        return next[-1+1];
    }
}
*/










//----------------------------Tabulation(another way)---------------------------
/* 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = 1;

        int maxi =1;
        for(int i=0; i<n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;   
    }
}
*/




//----------------------------Using Binary Search---------------------------

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                
                int low = 0, high = temp.size() - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (temp.get(mid) < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                temp.set(low, nums[i]); // Replace the element at the correct position
            }
        }

        return temp.size();
    }
}

