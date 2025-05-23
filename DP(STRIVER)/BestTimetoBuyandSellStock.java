//Best Time to Buy and Sell Stock
//Leetcode -> 121



//TC:0(n)
//SC:0(1)
class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        
        for(int i=1; i<prices.length; i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}