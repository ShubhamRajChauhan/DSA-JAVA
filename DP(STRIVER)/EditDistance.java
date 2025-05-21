//Edit Distance
//Leetcode -> 72


//---------------------Recursion---------------------------
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        return f(m-1, n-1, word1, word2);
    }

    int f(int i, int j, String s1, String s2) {
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i) == s2.charAt(j)) {
            return 0 + f(i-1, j-1, s1, s2);
        } else {
            return 1 + Math.min(f(i, j-1, s1, s2) , Math.min(f(i-1, j, s1, s2), f(i-1, j-1, s1, s2)));
        }
    }
}
*/




//---------------------Memoization---------------------------
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(m-1, n-1, word1, word2, dp);
    }

    int f(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 0 + f(i-1, j-1, s1, s2, dp);
        } else {
            return dp[i][j] = 1 + Math.min(f(i, j-1, s1, s2, dp) , Math.min(f(i-1, j, s1, s2, dp), f(i-1, j-1, s1, s2, dp)));
        }
    }
}
*/




//---------------------Tabulation---------------------------
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        
        //base case
        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=0; j<=n; j++) dp[0][j] = j;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 0 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
*/


//--------------------Space Optimization--------------------------
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[]prev = new int[n+1];
        
        //base case
        for(int j=0; j<=n; j++) prev[j] = j;

        for(int i=1; i<=m; i++) {
            int[]cur = new int[n+1];
            cur[0] = i;
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur[j] = 0 + prev[j-1];
                } else {
                    cur[j] = 1 + Math.min(cur[j-1], Math.min(prev[j], prev[j-1]));
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}