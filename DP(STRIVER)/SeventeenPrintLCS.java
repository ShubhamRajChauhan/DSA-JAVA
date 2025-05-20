//Print LCS

public class SeventeenPrintLCS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "bdgek";
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = 0;

        for(int idx1=1; idx1<=m; idx1++) {
            for(int idx2=1; idx2<=n; idx2++) {
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
            }
        }
        int len = dp[m][n];
        char[] ans = new char[len];
        int index = len - 1;

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans[index--] = text1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(String.valueOf(ans));
    }
}


