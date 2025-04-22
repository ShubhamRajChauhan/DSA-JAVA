//Partition Equal Subset Sum, Leetcode -> 416


//DP -> Space Optimization
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }

        int target = totalSum / 2;   
        
        if(totalSum % 2 != 0) return false; //odd sum

        return f(nums, target);
    }

    boolean f(int[]nums, int k) {
        int n = nums.length;
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(nums[0] <= k) prev[nums[0]] = true;
        for(int idx=1; idx<n; idx++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(nums[idx] <= target) take = prev[target-nums[idx]];
                curr[target] = take || notTake;
            }
            prev = curr;
        }
        return prev[k];
    }
}
