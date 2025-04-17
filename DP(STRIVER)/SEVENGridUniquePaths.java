//Grid Unique Paths, Leetcode -> 62


//------------------------Memoization-----------------------
//TC: 0(nxm)
//SC: 0((n-1)+(m-1)) + 0(nxm)
public class SEVENGridUniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return grid(m-1, n-1, dp);
    }

    public int grid(int i, int j, int[][] dp) {
        
        if(i==0 && j==0) {    //reached destination
            return 1;
        }
        if(i < 0 || j < 0) {  //boundary cross
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int up = grid(i-1, j, dp);
            int left = grid(i, j-1, dp);
            int ans = up + left;
            dp[i][j] = ans;
            return ans;
        }
    }
}




//----------------------Tabulation------------------
//TC : 0(nxm)
//SC : 0(nxm)
class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
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

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}


//-----------------------Space Optimization------------------
class Solution1 {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
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