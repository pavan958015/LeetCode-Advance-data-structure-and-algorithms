class Solution {
    public static int dfs(int i, int j, int[][] grid, boolean vis[][], int n, int m) {
        if (i < 0 || j < 0 || i>= n || j >= m)
            return 1;

        if(grid[i][j]==0) return 1;
        if(vis[i][j]==true) return 0;
        vis[i][j] = true;
        int down = dfs(i + 1, j, grid,vis, n, m);
        int up = dfs(i - 1, j, grid, vis, n, m);
        int right = dfs(i, j + 1, grid, vis, n, m);
        int left = dfs(i, j - 1, grid, vis, n, m);

        return down + up + right + left;

    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1)
                    ans += dfs(i, j, grid, vis, n, m);
            }
        }
        return ans;
    }
}