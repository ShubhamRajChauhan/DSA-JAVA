//Minimum Path Sum, Leetcode -> 64


//----------------------Memoization-------------------------------------
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return min(m-1, n-1, grid, dp);
    }

    public int min(int i, int j, int[][]grid, int[][] dp) {
        if(i == 0 && j == 0) {
            return grid[i][j];
        }
        if(i<0 || j<0) {
            return (int) 1e9;
        }


        if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int up = grid[i][j] + min(i-1, j, grid, dp);
            int left = grid[i][j] + min(i, j-1, grid, dp);

            int ans = Math.min(up, left);
            dp[i][j] = ans;
            return ans;

        }      
    }
}
*/


//----------------------Tabulation-------------------------------------
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = grid[0][0];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = grid[i][j] + dp[i-1][j];
                    if(j>0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
*/


//----------------------Space Optimization-------------------------------------
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[m];

        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = grid[i][j] + prev[j];
                    if(j>0) left = grid[i][j] + temp[j-1];
                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
