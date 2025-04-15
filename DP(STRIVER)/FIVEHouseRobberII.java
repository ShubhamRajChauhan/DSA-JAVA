//House Robber II --> Leetcode = 213

public class FIVEHouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] temp1 = new int[n - 1]; // Exclude last house
        int[] temp2 = new int[n - 1]; // Exclude first house

        for (int i = 0; i < n - 1; i++) {
            temp1[i] = nums[i];       // 0 to n-2
            temp2[i] = nums[i + 1];   // 1 to n-1
        }

        return Math.max(robLinear(temp1), robLinear(temp2));
    }

    // Classic House Robber (Linear)
    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0], prev2 = 0;

        for (int i = 1; i < n; i++) {
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
