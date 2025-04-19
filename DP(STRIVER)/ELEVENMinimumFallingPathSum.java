//Minimum Falling Path Sum, Leetcode -> 931


//-------------------------Recursion-------------------------
/*
//TC:0(3^n), SC:0(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) {
            ans =  Math.min(ans, f(n-1, j, n, m, matrix)); // trying all columns in the last row
        }
        return ans;
    }

    private int f(int i, int j, int n, int m, int[][] matrix) {
        if(j < 0 || j >= m) return (int) 1e9; // out of bounds
        if(i == 0) return matrix[0][j]; // base case, top row

        int s = matrix[i][j] + f(i-1, j, n, m, matrix);   // straight up
        int ld = matrix[i][j] + f(i-1, j-1, n, m, matrix); // left diagonal
        int rd = matrix[i][j] + f(i-1, j+1, n, m, matrix); // right diagonal

        return Math.min(s, Math.min(ld, rd)); // take the min path
    }
}
*/




//-------------------------Memoization-------------------------
//TC:0(nxm), SC:0(nxm)+0(n)
/*
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[n][m];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        for(int j=0; j<m; j++) {
            ans =  Math.min(ans, f(n-1, j, n, m, matrix, dp)); // trying all columns in the last row
        }
        return ans;
    }

    private int f(int i, int j, int n, int m, int[][] matrix, int[][] dp) {
        if(j < 0 || j >= m) return (int) 1e9; // out of bounds
        if(i == 0) return matrix[0][j]; // base case, top row

        if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int s = matrix[i][j] + f(i-1, j, n, m, matrix, dp);   // straight up
            int ld = matrix[i][j] + f(i-1, j-1, n, m, matrix, dp); // left diagonal
            int rd = matrix[i][j] + f(i-1, j+1, n, m, matrix, dp); // right diagonal

            return dp[i][j] = Math.min(s, Math.min(ld, rd)); // take the min path
        }

    }
}
*/





//-------------------------Tabulation-------------------------
//TC:0(nxm)+0(m), SC:0(nxm)
/*
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int j=0; j<m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int s = (int) 1e9;
                int ld = (int) 1e9;
                int rd = (int) 1e9;
                s = matrix[i][j] + dp[i-1][j];
                if(j-1 >= 0)  ld = matrix[i][j] + dp[i-1][j-1];
                if(j+1 < m)  rd = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min(s, Math.min(ld, rd));
            }
        }

        int mini = dp[n-1][0];
        for(int j=0; j<m; j++) {
            mini = Math.min(mini, dp[n-1][j]);
        }
        

        return mini;
    }
    
}
*/




   
//-------------------------Space Optimization-------------------------
//TC:0(nxm)+0(m), SC:0(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[n];
        for(int j=0; j<m; j++) {
            prev[j] = matrix[0][j];
        }

        for(int i=1; i<n; i++) {
            int[] temp = new int[m];
            for(int j=0; j<m; j++) {
                int s = (int) 1e9;
                int ld = (int) 1e9;
                int rd = (int) 1e9;
                s = matrix[i][j] + prev[j];
                if(j-1 >= 0)  ld = matrix[i][j] + prev[j-1];
                if(j+1 < m)  rd = matrix[i][j] + prev[j+1];

                temp[j] = Math.min(s, Math.min(ld, rd));
            }
            prev = temp;
        }

        int mini = prev[0];
        for(int j=0; j<m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        

        return mini;
    }
    
}





