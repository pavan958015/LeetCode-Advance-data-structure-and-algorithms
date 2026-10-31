
class Solution {
    private static final int MOD = 1_000_000_007;

    private int[][] grid;
    private int[][][] memo;
    private int m, n;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(memo[i][j], -1);
            }
        }

        return solve(0, 0, 2);
    }

    private int solve(int i, int j, int prev) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (memo[i][j][prev] != -1) {
            return memo[i][j][prev];
        }

        long ans = 0;

        if (grid[i][j] == 1) {
            if (prev == 0) {
                // Entered from the left: reflect down
                ans = solve(i + 1, j, 1);
            } else if (prev == 1) {
                // Entered from above: reflect right
                ans = solve(i, j + 1, 0);
            }
        } else {
            // Move right
            ans += solve(i, j + 1, 0);

            // Move down
            ans += solve(i + 1, j, 1);
        }

        return memo[i][j][prev] = (int) (ans % MOD);
    }
}
