class Solution {
    // public int change(int amount, int[] coins) {
    //     int dp[][]=new int[coins.length][amount+1];
    //     for(int i=0;i<coins.length;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return solve(0,coins.length,amount,coins,dp);
    // }
    // public static int solve(int idx,int n,int amount,int[] coins,int[][] dp){
    //     // base case
    //     if(idx==n) return 0;
    //     if(idx==n-1){
    //         if(amount%coins[idx]==0) return amount/coins[idx];
    //     }
    //     if(amount==0) return 1;

    //     if(dp[idx][amount]!=-1) return dp[idx][amount];

    //     int notPick=solve(idx+1,n,amount,coins,dp);
    //     int pick=0;
    //     if(coins[idx]<=amount){
    //         pick=solve(idx,n,amount-coins[idx],coins,dp);
    //     }
    //     return dp[idx][amount]=pick+notPick;
    // }


    public int change(int amount,int[] coins){
        int n=coins.length;
        int dp[][]=new int[n][amount+1];

        for(int i=0;i<n;i++)
            dp[i][0]=1;
        for(int a=0;a<=amount;a++){
            if(a%coins[0]==0) 
                dp[0][a]=1;
        }
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notPick=dp[i-1][a];
                int pick=0;
                if(coins[i]<=a){
                    pick=dp[i][a-coins[i]];
                }
                dp[i][a]=pick+notPick;
            }
        }
        return dp[n-1][amount];
    }
}