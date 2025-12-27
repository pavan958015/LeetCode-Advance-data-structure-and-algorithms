class Solution {
    public int minInsertions(String s) {
        // return minInsertions(0,s.length()-1,s);
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        //return minInsertions(0,s.length()-1,s,dp);
        // str.length()-lonegestCommonPalindromicSubSequence(str);
        return s.length()-longestPalindromeSubseq(s);

    }
    // using Recursion

    // public static int minInsertions(int start, int end, String s) {
    //     // base case
    //     if (s == null || start >= end) {
    //         return 0;
    //     }

    //     // recursive case;
    //     if (s.charAt(start) == s.charAt(end)) {
    //         return minInsertions(start + 1, end - 1, s);
    //     } else {
    //         return Math.min(1 + minInsertions(start + 1, end, s),
    //                         1 + minInsertions(start, end - 1, s));
    //     }
    // }

    // using DP;

    // public static int minInsertions(int start, int end, String s, int dp[][]) {
    //     // base case
    //     if (s == null || start >= end) {
    //         return 0;
    //     }
    //     if (dp[start][end] != -1) {
    //         return dp[start][end];
    //     }

    //     // recursive case;
    //     if (s.charAt(start) == s.charAt(end)) {
    //         return minInsertions(start + 1, end - 1, s, dp);
    //     }
    //     return dp[start][end] = Math.min(1 + minInsertions(start + 1, end, s, dp),
    //             1 + minInsertions(start, end - 1, s, dp));
    // }

    // tablulation




    // using Longest common Palindromic subsequence 
    // str.length()-lonegestCommonPalindromicSubSequence(str);

    // using DP

    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }   
        return solve(s,0,s.length()-1,dp);
    }
     public static int solve(String s, int i, int j, int dp[][]) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // match
        int match = 0;
        int noMatch = 0;
        if (s.charAt(i) == s.charAt(j)) {
            match = 2 + solve(s, i + 1, j - 1, dp);
        } else {
            noMatch = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
        }
        return dp[i][j] = match + noMatch;
    }
}