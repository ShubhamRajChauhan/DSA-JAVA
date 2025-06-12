//Palindrome Partitioning II
//Leetcode -> 132

//------------------------------Recursion-----------------------------------
/*
class Solution {
    public int minCut(String s) {
        int n = s.length();
        return f(0, n, s) - 1;
    }

    int f(int i, int n, String str){
        if(i == n) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int j=i; j<n; j++) {
            if(isPalindrome(i, j, str)) {
                int cost = 1 + f(j+1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
*/




//----------------------------Memoization--------------------------------
/*
class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, n, s, dp) - 1;
    }

    int f(int i, int n, String str, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j=i; j<n; j++) {
            if(isPalindrome(i, j, str)) {
                int cost = 1 + f(j+1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
*/





//--------------------------Tabulation-----------------------------
class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        
        for(int i = n-1; i>=0; i--) {
            int minCost = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                if(isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}