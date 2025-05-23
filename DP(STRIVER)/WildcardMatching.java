//WildCard Matching
//Leetcode -> 44


//------------------------Recursion-----------------------------

class Solution1 {
    public boolean isMatch(String s, String p) {
        //s1 = p and s2 = s
        int m = p.length();
        int n = s.length();

        return f(m-1, n-1, p, s);
    }

    boolean f(int i, int j, String s1, String s2) {
        //base case
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0) {
            for(int ii=0; ii <= i; ii++) {
                if(s1.charAt(ii) != '*') return false;
            }
            return true;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return f(i-1, j-1, s1, s2);
        } 
        if(s1.charAt(i) == '*') {
            return f(i-1, j, s1, s2) || f(i, j-1, s1, s2);
        } 

        return false;
    }
}






//-----------------------Memoization-----------------------------

class Solution2 {
    public boolean isMatch(String s, String p) {
        //s1 = p and s2 = s
        int m = p.length();
        int n = s.length();

        Boolean[][] dp = new Boolean[m][n];

        return f(m-1, n-1, p, s, dp);
    }

    boolean f(int i, int j, String s1, String s2, Boolean[][] dp) {
        //base case
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0) {
            for(int ii=0; ii <= i; ii++) {
                if(s1.charAt(ii) != '*') return false;
            }
            return true;
        }


        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = f(i-1, j-1, s1, s2, dp);
        } 
        if(s1.charAt(i) == '*') {
            return dp[i][j] = f(i-1, j, s1, s2, dp) || f(i, j-1, s1, s2, dp);
        } 

        return dp[i][j] = false;
    }
}







//----------------------Tabulation----------------------------

class Solution3 {
    public boolean isMatch(String s, String p) {
        //s1 = p and s2 = s
        int m = p.length();
        int n = s.length();

        Boolean[][] dp = new Boolean[m+1][n+1];

        //base case
        dp[0][0] = true;

        for(int j = 1; j <= n; j++) {
            dp[0][j] = false;
        }

        for(int i = 1; i <= m; i++) {
            boolean flag = true;
            for(int ii=1; ii <= i; ii++) {
                if(p.charAt(ii-1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }


        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } 
                else if(p.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } 
                else dp[i][j] = false;
            }
        }

        return dp[m][n];
    }
}




//---------------------Space Optimization---------------------------

class Solution4 {
    public boolean isMatch(String s, String p) {
        //s1 = p and s2 = s
        int m = p.length();
        int n = s.length();

        Boolean[] prev = new Boolean[n+1];
        

        
        prev[0] = true;

        for(int j = 1; j <= n; j++) {
            prev[j] = false;
        }



        for(int i=1; i<=m; i++) {

            Boolean[] cur = new Boolean[n+1];
            boolean flag = true;
            for(int ii=1; ii <= i; ii++) {
                if(p.charAt(ii-1) != '*') {
                    flag = false;
                    break;
                }
            }
            //for every row, you are assigning the 0th column's value
            cur[0] = flag;

            for(int j=1; j<=n; j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    cur[j] = prev[j-1];
                } 
                else if(p.charAt(i-1) == '*') {
                    cur[j] = prev[j] || cur[j-1];
                } 
                else cur[j] = false;
            }
            prev = cur;
        }

        return prev[n];
    }
}

