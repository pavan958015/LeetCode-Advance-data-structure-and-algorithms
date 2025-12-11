class Solution {
   public int minPathSum(int grid[][]) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, grid.length - 1, grid[0].length - 1, grid, dp);
    }

    public static int helper(int sr, int sc, int m, int n, int grid[][], int dp[][]) {
        if (sr == m && sc == n) {
            return grid[sr][sc];
        }
        if (sr > m || sc > n) {
            return Integer.MAX_VALUE;
        }
        if (dp[sr][sc] != -1) {
            return dp[sr][sc];
        }
        int down = helper(sr + 1, sc, m, n, grid, dp);
        int right = helper(sr, sc + 1, m, n, grid, dp);
        dp[sr][sc] = grid[sr][sc] + Math.min(down, right);
        return dp[sr][sc];
    }
}