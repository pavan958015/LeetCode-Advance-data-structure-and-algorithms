class Solution {
    public static int solve(int i, int j, int n, int m, int[][] coins,int[][][] dp, int k) {
        if (i >= n || j >= m)
    return (int)-1e9;
        int res = 0;
        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && k > 0)
                return 0;
            return coins[i][j];
        }

        if(dp[i][j][k]!=Integer.MIN_VALUE) return dp[i][j][k];
        if (coins[i][j] > 0) {
            res = coins[i][j] + Math.max(solve(i + 1, j, n, m, coins,dp, k), 
                                         solve(i, j + 1, n, m, coins,dp, k));
        } else {
            // Option 1: take negative
            int take = coins[i][j] + Math.max(
                    solve(i + 1, j, n, m, coins,dp, k),
                    solve(i, j + 1, n, m, coins,dp, k));

            // Option 2: skip negative
            int skip = (k > 0) ? Math.max(
                    solve(i + 1, j, n, m, coins,dp, k - 1),
                    solve(i, j + 1, n, m, coins,dp, k - 1)) : (int) -1e9;

            res = Math.max(take, skip);
        }
        return dp[i][j][k]=res;
    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int dp[][][]=new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<3;k++)
                    Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(0, 0, n, m, coins,dp, 2);
    }
}