class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,n,1,prices,dp);
    }

    public static int solve(int idx,int n, int canByOrNot, int[] prices,int[][] dp) {
        if (idx == n)
            return 0;

        if(dp[idx][canByOrNot]!=-1) return dp[idx][canByOrNot];

        int profit=0;
        if (canByOrNot == 1) {
            // buy
            profit = Math.max(-prices[idx] + solve(idx+1,n,0,prices,dp), solve(idx + 1,n, 1, prices,dp));
        } else {
             profit = Math.max(prices[idx]+solve(idx + 1,n,1, prices,dp),solve(idx + 1,n, 0, prices,dp));
        }
        return dp[idx][canByOrNot]=profit;
    }
}