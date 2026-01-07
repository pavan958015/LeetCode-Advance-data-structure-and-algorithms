class Solution {
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int lim = 0; lim <= k; lim++) {
                    dp[i][j][lim] = -1;
                }
            }
        }
        return solve(0, 1, prices, dp, k);
    }

    public int solve(int idx, int flag, int[] arr, int[][][] dp, int limit) {

        // base cases
        if (idx == arr.length || limit == 0) return 0;

        if (dp[idx][flag][limit] != -1)
            return dp[idx][flag][limit];

        // can buy
        if (flag == 1) {
            return dp[idx][flag][limit] =
                    Math.max(
                        -arr[idx] + solve(idx + 1, 0, arr, dp, limit),
                        solve(idx + 1, 1, arr, dp, limit)
                    );
        }
        // can sell
        else {
            return dp[idx][flag][limit] =
                    Math.max(
                        arr[idx] + solve(idx + 1, 1, arr, dp, limit - 1),
                        solve(idx + 1, 0, arr, dp, limit)
                    );
        }
    }
}