class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int dp[][] = new int[n][m]; // -1 = not visited

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, s, p, dp);
    }

    public boolean solve(int i, int j, String s, String p, int dp[][]) {
        // base cases
        if (i < 0 && j < 0) return true;

        if (j < 0 && i >= 0) return false;

        if (i < 0 && j >= 0) {
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        // match or '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = solve(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }

        // '*'
        if (p.charAt(j) == '*') {
            boolean res = solve(i - 1, j, s, p, dp) || solve(i, j - 1, s, p, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        dp[i][j] = 0;
        return false;
    }
}