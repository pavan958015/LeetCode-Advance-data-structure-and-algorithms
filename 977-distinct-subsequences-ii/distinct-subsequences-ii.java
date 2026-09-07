class Solution {
    static final int MOD = 1000000007;
    long[] dp;

    public int distinctSubseqII(String s) {
        int n = s.length();

        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return (int)((solve(n, s) - 1 + MOD) % MOD);
    }

    long solve(int n, String s) {

        // Empty subsequence
        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        // Current character ko lene / na lene ke 2 choices
        long ans = (2 * solve(n - 1, s)) % MOD;

        char ch = s.charAt(n - 1);

        // Previous same character dhundo
        int prev = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == ch) {
                prev = i;
                break;
            }
        }

        // Duplicate subsequences remove
        if (prev != -1) {
            ans = (ans - solve(prev, s) + MOD) % MOD;
        }

        return dp[n] = ans;
    }
}