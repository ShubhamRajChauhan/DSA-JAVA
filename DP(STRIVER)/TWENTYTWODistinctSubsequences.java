//Distinct Subsequences
//Leetcode -> 115

//---------------------------Recursion---------------------------------
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        return f(m-1, n-1, s, t);
    }
    int f(int i, int j, String s, String t) {
        if(j<0) return 1;
        if(i<0) return 0;

        if(s.charAt(i) == t.charAt(j)) {
            return f(i-1, j-1, s, t) + f(i-1, j, s, t);
        } else {
            return f(i-1, j, s, t);
        }
    }
}
*/





//---------------------------Memoization---------------------------------
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(m-1, n-1, s, t, dp);
    }
    int f(int i, int j, String s, String t, int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = f(i-1, j-1, s, t, dp) + f(i-1, j, s, t, dp);
        } else {
            return dp[i][j] = f(i-1, j, s, t, dp);
        }
    }
}
*/




//--------------------------Tabulation--------------------------------
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];
        
        //base case
        for(int i=0; i<=m; i++) dp[i][0] = 1;
        for(int j=1; j<=n; j++) dp[0][j] = 0; // j starts from 1 because if it starts from 0, then it will rewrite the (0,0)

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
*/





//-------------------------Space Optimization------------------------------
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] prev = new int[n+1];
        prev[0] = 1;

        for(int i=1; i<=m; i++) {
            int[] cur = new int[n+1];
            cur[0] = 1;
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    cur[j] = prev[j-1] + prev[j];
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}
*/




//-----------------------Single Array Optimization------------------------------

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] prev = new int[n+1];
        prev[0] = 1;

        for(int i=1; i<=m; i++) {
            for(int j=n; j>=1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    prev[j] = prev[j-1] + prev[j];
                } 
            }
        }
        return prev[n];
    }
}