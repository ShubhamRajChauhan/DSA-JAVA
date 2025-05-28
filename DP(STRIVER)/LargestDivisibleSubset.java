//Largest Divisible Subset
//Leetcode -> 368

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];  for(int i=0; i<dp.length; i++) dp[i] = 1;
        int[] hash = new int[n];
        int maxi = 1;
        int lastIndex = 0;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            hash[i] = i;

            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];       // Update max length
                lastIndex = i;      // Update index
            }
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis.add(nums[lastIndex]);
        }

        return lis;
    }
}