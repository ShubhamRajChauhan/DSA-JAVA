//Leetcode -> 494

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countPartitions(n, target, nums);
    }


    int countPartitions(int n, int target, int[] nums){
        int totSum = 0;
        for(int i=0; i<n; i++) {
            totSum += nums[i];
        }

        if(totSum - target < 0  || (totSum - target) % 2 != 0) return 0;
        return f(nums, (totSum-target)/2 );
    }



    int f(int[] nums, int target) {
        int[] prev = new int[target + 1];
        
        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= target) prev[nums[0]] = 1;

        for(int idx = 1; idx < nums.length; idx++) {
            int[] cur = new int[target + 1];
            for(int sum = 0; sum <= target; sum++) {
                int notTake = prev[sum];
                int take = 0;
                if(nums[idx] <= sum) take = prev[sum-nums[idx]];
                
                cur[sum] = (notTake + take);
            }
            prev = cur;
        }
        return prev[target];
    }  
}