//Longest Common Subsequence
//Leetcode -> 1143 

//--------------------------------Recursion--------------------------------------
class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        return f(m-1, n-1, text1, text2); 
    }

    int f(int idx1, int idx2, String text1, String text2) {
        if(idx1 < 0 || idx2 < 0) return 0;

        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + f(idx1-1, idx2-1, text1, text2);
        } else {
            return Math.max(f(idx1-1, idx2, text1, text2), f(idx1, idx2-1, text1, text2));
        }
    }
}




//--------------------------------Memoization--------------------------------------
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(m-1, n-1, text1, text2, dp); 
    }

    int f(int idx1, int idx2, String text1, String text2, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + f(idx1-1, idx2-1, text1, text2, dp);
        } else {
            return dp[idx1][idx2] = Math.max(f(idx1-1, idx2, text1, text2, dp), f(idx1, idx2-1, text1, text2, dp));
        }
    }
}




//--------------------------------Tabulation--------------------------------------
class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = 0;

        for(int idx1=1; idx1<=m; idx1++) {
            for(int idx2=1; idx2<=n; idx2++) {
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
            }
        }
        return dp[m][n];
    }
}




//--------------------------------Space Optimization--------------------------------------
class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n+1];
        
        for(int j=0; j<=n; j++) prev[j] = 0;

        for(int idx1=1; idx1<=m; idx1++) {
            int[] cur = new int[n+1];
            for(int idx2=1; idx2<=n; idx2++) {
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                    cur[idx2] = 1 + prev[idx2-1];
                } else {
                    cur[idx2] = Math.max(prev[idx2], cur[idx2-1]);
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}