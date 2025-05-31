//Longest String Chain
//Leetcode -> 1048


class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, Comparator.comparingInt(String::length)); //sorting based on length

        int[] dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = 1;

        int maxi =1;
        for(int i=0; i<n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(checkPossible(words[i], words[prev])) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }


    boolean checkPossible(String s1, String s2) {
        if(s1.length() != s2.length() + 1) return false;
        int first = 0;
        int second = 0;
        while(first < s1.length()) {
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
}