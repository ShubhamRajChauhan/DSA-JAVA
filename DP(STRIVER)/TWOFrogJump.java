//Frog Jump -> Striver

//------------------------------ RECURSION----------------------------------------
class TWOFrogJump {
    public int f(int idx, int[] heights) {
        if(idx == 0) {
            return 0;
        }
        int left = f(idx -1 , heights) + Math.abs(heights[idx] - heights[idx -1]);
        int right = Integer.MAX_VALUE;
        if(idx > 1) {
            right = f(idx -2 , heights) + Math.abs(heights[idx] - heights[idx -2]);
        }
        return Math.min(left, right);
    }
    public int frogJump(int[] heights) {
        int n = heights.length;
        return f(n-1, heights);
    }
}



//--------------------------------MEMOIZATION-----------------------------------
class TWOFrogJump {
    public int f(int idx, int[] heights, int[] dp) {
        if(idx == 0) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        } else {
            int left = f(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx - 1]);
            int right = Integer.MAX_VALUE;
            if(idx > 1) {
                right = f(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx - 2]);
            }
            dp[idx] = Math.min(left, right);
            return dp[idx];
        }
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return f(n - 1, heights, dp);
    }
}



//------------------------TABULATION--------------------------
class TWOFrogJump {
    public int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1];
    }
}




//------------------------SPACE OPTIMIZATION--------------------------
class TWOFrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curi = Math.min(fs, ss);
            prev2 = prev;
            prev = curi;
        }

        return prev;
    }
}

