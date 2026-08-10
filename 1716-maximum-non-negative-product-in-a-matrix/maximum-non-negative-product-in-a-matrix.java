class Solution {
    int MOD = 1_000_000_007;

    static class Pair {
        long max;
        long min;

        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Pair[][] dp = new Pair[n][m];

        Pair ans = solve(0, 0, n, m, grid, dp);

        if (ans.max < 0) return -1;

        return (int)(ans.max % MOD);
    }

    private Pair solve(int i, int j, int n, int m,
                       int[][] grid, Pair[][] dp) {

        if (i >= n || j >= m) {
            return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
        }

        if (i == n - 1 && j == m - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        Pair right = solve(i, j + 1, n, m, grid, dp);

        Pair down = solve(i + 1, j, n, m, grid, dp);

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        if (right.max != Long.MIN_VALUE) {
            max = Math.max(max, grid[i][j] * right.max);
            max = Math.max(max, grid[i][j] * right.min);

            min = Math.min(min, grid[i][j] * right.max);
            min = Math.min(min, grid[i][j] * right.min);
        }

        if (down.max != Long.MIN_VALUE) {
            max = Math.max(max, grid[i][j] * down.max);
            max = Math.max(max, grid[i][j] * down.min);

            min = Math.min(min, grid[i][j] * down.max);
            min = Math.min(min, grid[i][j] * down.min);
        }

        dp[i][j] = new Pair(max, min);

        return dp[i][j];
    }
}