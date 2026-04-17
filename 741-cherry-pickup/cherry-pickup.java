class Solution {
    public int cherryPickup(int[][] grid) {
        // ( 0 , 0 ) to ( n - 1 ) ( n - 1 )
        //then
        // ( n - 1 ) ( n - 1 ) to ( 0 , 0 );

        // will lose


        // OR

        // traverse both 

        // (0,0)  to (n-1)(n-1)

        int n = grid.length;
        int dp[][][][]=new int[n][n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        int ans = dfs(0, 0, 0, 0, n, grid,dp);
        return Math.max(0, ans);
    }

    public static int dfs(int r1, int r2, int c1, int c2, int n, int[][] grid,int[][][][]dp) {
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // if (r1 + c1 != r2 + c2)
        //     return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1 && r2 == n - 1 && c2 == n - 1)
            return grid[r1][c1];

        if(dp[r1][c1][r2][c2]!=-1) return dp[r1][c1][r2][c2];

        int charry = 0;
        // take once if r1 c1 and r2 and c2 in same cell
        if (r1 == r2 && c1 == c2) {
            charry += grid[r1][c1];
        } else {
            charry += grid[r1][c1] + grid[r2][c2];
        }

        int a = dfs(r1 + 1, r2 + 1, c1, c2, n, grid,dp);
        int b = dfs(r1 + 1, r2, c1, c2 + 1, n, grid,dp);
        int c = dfs(r1, r2 + 1, c1 + 1, c2, n, grid,dp);
        int d = dfs(r1, r2, c1 + 1, c2 + 1, n, grid,dp);


        int total = Math.max(Math.max(a, b), Math.max(c, d));
        charry += total;

        return dp[r1][c1][r2][c2]=charry;
    }
}