class Solution {
    static int n;
    static int m;
    static boolean vis[][];

    public static boolean dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;

        if (vis[i][j])
            return true;
        if (grid[i][j] == 1)
            return true;

        vis[i][j] = true;

        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid);
        boolean up = dfs(i - 1, j, grid);
        boolean down = dfs(i + 1, j, grid);

        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (grid[i][j] == 0) {
                        if (dfs(i, j, grid)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}