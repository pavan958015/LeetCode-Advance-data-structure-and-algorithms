class Solution {
    public int minInsertions(String s) {
        // return minInsertions(0,s.length()-1,s);
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return minInsertions(0,s.length()-1,s,dp);

    }
    public static int minInsertions(int start, int end, String s) {
        // base case
        if (s == null || start >= end) {
            return 0;
        }

        // recursive case;
        if (s.charAt(start) == s.charAt(end)) {
            return minInsertions(start + 1, end - 1, s);
        } else {
            return Math.min(1 + minInsertions(start + 1, end, s),
                            1 + minInsertions(start, end - 1, s));
        }
    }
    // using DP;

    public static int minInsertions(int start, int end, String s, int dp[][]) {
        // base case
        if (s == null || start >= end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // recursive case;
        if (s.charAt(start) == s.charAt(end)) {
            return minInsertions(start + 1, end - 1, s, dp);
        }
        return dp[start][end] = Math.min(1 + minInsertions(start + 1, end, s, dp),
                1 + minInsertions(start, end - 1, s, dp));
    }
}