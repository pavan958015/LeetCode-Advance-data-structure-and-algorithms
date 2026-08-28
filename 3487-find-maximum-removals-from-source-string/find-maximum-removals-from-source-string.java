class Solution {
    int n;
    int m;

    private int solve(int i, int j, String s, String t,
                      Integer[][] dp, Set<Integer> set) {

      if (j == m) {
            int remainingTargetCount = 0;
            for (int k = i; k < n; k++) {
                if (set.contains(k)) remainingTargetCount++;
            }
            return remainingTargetCount;
        }

        if (i == n)
            return -1000000;

        if (dp[i][j] != null)
            return dp[i][j];

        // Option 1: remove source[i]
        int ans = -1000000;

        if (set.contains(i)) {
            ans = 1 + solve(i + 1, j, s, t, dp, set);
        }

        // Option 2: keep source[i]
        if (s.charAt(i) == t.charAt(j)) {
            ans = Math.max(
                ans,
                solve(i + 1, j + 1, s, t, dp, set)
            );
        }

        // Skip source[i] without removing it
        ans = Math.max(
            ans,
            solve(i + 1, j, s, t, dp, set)
        );

        return dp[i][j] = ans;
    }

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        n = source.length();
        m = pattern.length();

        Set<Integer> set = new HashSet<>();

        for (int x : targetIndices) {
            set.add(x);
        }

        Integer[][] dp = new Integer[n + 1][m + 1];

        return solve(0, 0, source, pattern, dp, set);
    }
}