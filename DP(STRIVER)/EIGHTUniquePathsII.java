//Unique Paths II, Leetcode -> 63



//-----------------Tabulation-------------------------
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int mod = (int)(1e9 + 7);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else if(i==0 && j==0) {
                    dp[0][0] = 1;
                }else{
                    int up=0;
                    int left = 0;
                    if(i > 0) {
                        up = dp[i-1][j];
                    }

                    if(j > 0) {
                        left = dp[i][j-1];
                    }

                    dp[i][j] = (up + left)%mod;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
*/


//----------------------Space Optimization------------------
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];

        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                }else if(i==0 && j==0) {
                    temp[0] = 1;
                }else{
                    int up=0;
                    int left = 0;
                    if(i > 0) {
                        up = prev[j];
                    }

                    if(j > 0) {
                        left = temp[j-1];
                    }

                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}