//Minimum Insertion Steps to Make a String Palindrome
//Leetcode -> 1312


class Solution {
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder();
        rev.append(s);
        rev.reverse();
        String s2 = rev.toString();

        int m = s.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = 0;

        for(int idx1=1; idx1<=m; idx1++) {
            for(int idx2=1; idx2<=n; idx2++) {
                if(s.charAt(idx1-1) == s2.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
            }
        }
        return m - dp[m][n];
    }
}
