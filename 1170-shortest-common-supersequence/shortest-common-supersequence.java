class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        // LCS + which character does not match add also
        return LongestCommonSequence(str1, str2);
    }

    public static String LongestCommonSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        lcsSolve(n, m, s1, s2, dp);
        return print(n, m, s1, s2, dp);
    }

    public static void lcsSolve(int n, int m, String s1, String s2, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public static String print(int n, int m, String s1, String s2, int[][] dp) {
        StringBuilder str = new StringBuilder();

        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                str.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(s1.charAt(i - 1));
                i--;
            } else {
                str.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            str.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            str.append(s2.charAt(j - 1));
            j--;
        }
        return str.reverse().toString();
    }

}