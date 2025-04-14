//Maximum Sum of Non-Adjacent Elements | House Robber  --> Leetcode = 198


//--------------Memoization---------------------- 
//TC: 0(n) , SC:0(n) + 0(n)
public class FOURHouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        return f(n-1, nums);
    }

    public static int f(int idx, int[] nums) {
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        int dp[] = new int[nums.length];
        for(int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        } else {
            int pick = nums[idx] + f(idx-2, nums);
            int notpick = 0 + f(idx - 1, nums);
            dp[idx] = Math.max(pick, notpick);
            return dp[idx];
        }
    }
}


//-------------------Tabulation---------------------------
//TC: 0(n) , SC:0(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1; i<n; i++) {
            int pick = nums[i];
            if(i > 1) {
                pick += dp[i-2];
            }

            int nonpick = 0 + dp[i-1];

            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n-1];
    }
}


//-------------------Space Optimization---------------------------
//TC: 0(n) , SC:0(1)
class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++) {
            int pick = nums[i];
            if(i > 1) {
                pick += prev2;
            }

            int nonpick = 0 + prev;

            int curi = Math.max(pick, nonpick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
