//Burst Balloons
//Leetcode -> 312


//--------------------------Recursion--------------------------------------
/*
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        
        arr.add(1);  //Add 1 at the end
        arr.add(0, 1);  //Add 1 at the beginning
        return f(1, n, arr);
    }

    static int f(int i, int j, ArrayList<Integer> a) {
        if (i > j) return 0;
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                       + f(i, ind - 1, a) + f(ind + 1, j, a);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }
}
*/




//--------------------------Memoization--------------------------------------
/*
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        
        arr.add(1);  //Add 1 at the end
        arr.add(0, 1);  //Add 1 at the beginning

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return f(1, n, arr, dp);
    }

    static int f(int i, int j, ArrayList<Integer> a, int[][] dp) {
        if (i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                       + f(i, ind - 1, a, dp) + f(ind + 1, j, a, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
}
*/






//-----------------------------Tabulation------------------------------------
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        
        arr.add(1);  //Add 1 at the end
        arr.add(0, 1);  //Add 1 at the beginning

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                
                // Iterate through possible indices to split the array
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr.get(i - 1) * arr.get(ind) * arr.get(j + 1) +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];

    }

}