class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] vis = new boolean[n][m];
        Boolean[][][] dp = new Boolean[n][m][health + 1];
        return solve(0, 0, n, m, grid, vis, health, dp);
    }

    private boolean solve(int i, int j, int n, int m, List<List<Integer>> grid, boolean[][] vis, int health,
            Boolean[][][] dp) {
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j]) {
            return false;
        }

        if (grid.get(i).get(j) == 1) {
            health--;
        }

        if (health <= 0) {
            return false;
        }

        if (i == n - 1 && j == m - 1) {
            return true;
        }
        if (dp[i][j][health] != null)
            return dp[i][j][health];
        vis[i][j] = true;

        boolean ans = solve(i + 1, j, n, m, grid, vis, health, dp) ||
                solve(i - 1, j, n, m, grid, vis, health, dp) ||
                solve(i, j + 1, n, m, grid, vis, health, dp) ||
                solve(i, j - 1, n, m, grid, vis, health, dp);

        vis[i][j] = false;

        return dp[i][j][health] = ans;
    }
}