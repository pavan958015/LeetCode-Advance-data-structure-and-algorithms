class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long ans = 0;
        Long dp[][][]=new Long[m+1][n+1][maxMove+1];

        ans += dfs(startRow, startColumn, m, n, maxMove,dp);

        return (int)ans;
    }

    public static long dfs(int i, int j, int m, int n, int maxMove,Long[][][] dp) {
        // base case 
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if(maxMove==0) return 0;

        int mod=1000000007;

        if(dp[i][j][maxMove]!=null) return dp[i][j][maxMove];

        long down = dfs(i + 1, j, m, n, maxMove-1,dp)%mod;
        long up = dfs(i - 1, j, m, n, maxMove-1,dp)%mod;
        long right = dfs(i, j + 1, m, n, maxMove-1,dp)%mod;
        long left = dfs(i, j - 1, m, n, maxMove-1,dp)%mod;

        dp[i][j][maxMove]=down + up + right + left;

        return dp[i][j][maxMove]%1000000007;
    }
}