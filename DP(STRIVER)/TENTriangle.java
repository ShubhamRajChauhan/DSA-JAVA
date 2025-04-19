//Triangle, Leetcode -> 120

//--------------------------------Recursion------------------------------
//TC: 0(2^n) , SC:0(n)
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                a[i][j] = row.get(j);
            }
        }

        return g(0, 0, a, n);
    }

    private int g(int i, int j, int[][] a, int n) {
        // Base case
        if (i == n - 1) {
            return a[n - 1][j];
        }

        // Recursively calculate the two choices
        int d = a[i][j] + g(i + 1, j, a, n);
        int dg = a[i][j] + g(i + 1, j + 1, a, n);

        // Return the minimum of the two
        return Math.min(d, dg);
    }
}
*/





//--------------------------------Memoization------------------------------
//TC: 0(nxn) , SC:0(nxn)+0(n)
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                a[i][j] = row.get(j);
            }
        }

        int[][] dp = new int[n][n];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return g(0, 0, a, n, dp);
    }

    private int g(int i, int j, int[][] a, int n, int[][] dp) {
        // Base case
        if (i == n - 1) {
            return a[n - 1][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            // Recursively calculate the two choices
            int d = a[i][j] + g(i + 1, j, a, n, dp);
            int dg = a[i][j] + g(i + 1, j + 1, a, n, dp);

            return dp[i][j] = Math.min(d, dg);
        }        
    }
}
*/





//--------------------------------Tabulation------------------------------
//TC: 0(nxn) , SC:0(nxn)
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                a[i][j] = row.get(j);
            }
        }

        int[][] dp = new int[n][n];
        for(int j=0; j<n; j++) {
            dp[n-1][j] = a[n-1][j]; // base case -> this is the last row , we fill these
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int d = a[i][j] + dp[i+1][j];
                int dg = a[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(d, dg);
            }
        }
        return dp[0][0];
    }
}
*/




//--------------------------------Space Optimization------------------------------
//TC: 0(nxn) , SC:0(n)
/* 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                a[i][j] = row.get(j);
            }
        }

        int[] front = new int[n];
        for(int j=0; j<n; j++) {
            front[j] = a[n-1][j]; // base case -> this is the last row , we fill these
        }

        for(int i=n-2; i>=0; i--) {
            int[] temp = new int[n];
            for(int j=i; j>=0; j--) {
                int d = a[i][j] + front[j];
                int dg = a[i][j] + front[j+1];

                temp[j] = Math.min(d, dg);
            }
            front = temp;
        }
        return front[0];
    }
}
*/
