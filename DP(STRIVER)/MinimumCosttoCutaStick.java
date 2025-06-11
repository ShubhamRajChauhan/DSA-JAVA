//Minimum Cost to Cut a Stick
//Leetcode -> 1547


//------------------------Recursion---------------------------------
/*
class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> cutsArr = new ArrayList<>();
        for (int cut : cuts) {
            cutsArr.add(cut);
        }
        
        cutsArr.add(0);
        cutsArr.add(n);
        Collections.sort(cutsArr);
        return f(1, c, cutsArr);
    }

    static int f(int i, int j, ArrayList<Integer> cutsArr) {
        if (i > j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cutsArr.get(j + 1) - cutsArr.get(i - 1) +
                      f(i, ind - 1, cutsArr) +
                      f(ind + 1, j, cutsArr);

            mini = Math.min(mini, ans);
        }

        return mini;
    }
}
*/





//------------------------Memoization---------------------------------
/*
class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> cutsArr = new ArrayList<>();
        for (int cut : cuts) {
            cutsArr.add(cut);
        }
        
        cutsArr.add(0);
        cutsArr.add(n);
        Collections.sort(cutsArr);


        int[][] dp = new int[c + 1][c + 1];
        for(int i = 0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return f(1, c, cutsArr, dp);
    }

    static int f(int i, int j, ArrayList<Integer> cutsArr, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cutsArr.get(j + 1) - cutsArr.get(i - 1) +
                      f(i, ind - 1, cutsArr, dp) +
                      f(ind + 1, j, cutsArr, dp);

            mini = Math.min(mini, ans);
        }

        return dp[i][j] = mini;
    }
}
*/







//------------------------Tabulation---------------------------------
class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> cutsArr = new ArrayList<>();
        for (int cut : cuts) {
            cutsArr.add(cut);
        }
        
        cutsArr.add(0);
        cutsArr.add(n);
        Collections.sort(cutsArr);


        int[][] dp = new int[c + 2][c + 2];
        
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = cutsArr.get(j + 1) - cutsArr.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];

    }
}