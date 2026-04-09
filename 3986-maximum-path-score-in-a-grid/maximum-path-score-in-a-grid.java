class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Integer dp[][][] = new Integer[n][m][k + 1];

        int ans = solve(0, 0, n, m, grid, k, dp);
        return (ans < 0) ? -1 : ans;
    }

    public static int solve(int i, int j, int n, int m, int[][] grid, int k, Integer dp[][][]) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return -1000000;
        int cost = (grid[i][j] > 0) ? 1 : 0;

        int remainingK = k - cost;

        if (remainingK < 0)
            return -1000000;

        if (i == n - 1 && j == m - 1) {
            return (remainingK >= 0) ? grid[i][j] : -1000000;
        }

        if (dp[i][j][remainingK] != null)
            return dp[i][j][remainingK];

        int score = -1000000;
        if (i + 1 < n)
            score = Math.max(score, solve(i + 1, j, n, m, grid, remainingK, dp));
        if (j + 1 < m)
            score = Math.max(score, solve(i, j + 1, n, m, grid, remainingK, dp));

        // if (score < 0)
        //     return dp[i][j][remainingK] = -1000000;

        return dp[i][j][remainingK] = grid[i][j] + score;
    }
}