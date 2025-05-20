//Delete Operation for Two Strings
//Leetcode -> 583

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = 0;

        for(int idx1=1; idx1<=m; idx1++) {
            for(int idx2=1; idx2<=n; idx2++) {
                if(word1.charAt(idx1-1) == word2.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
            }
        }
        return m + n - 2*dp[m][n];
    }
}
