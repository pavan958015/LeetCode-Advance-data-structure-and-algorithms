class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int ans= solve(coins.length-1,coins,amount);
    //     return ans>=Integer.MAX_VALUE?-1:ans;
    // }
    // public static int solve(int idx,int[] coins,int amount){
    //     // base
    //     if(amount==0) return 0;
    //     if(idx==0){
    //         if(amount%coins[0]==0){
    //             return amount/coins[0];
    //         }
    //         else{
    //             return Integer.MAX_VALUE;
    //         }
    //     }
    //     //not take
    //     int notTake=solve(idx-1,coins,amount);
    //     // take
    //     int take=Integer.MAX_VALUE;
    //     if(coins[idx]<=amount)
    //      take=1+solve(idx,coins,amount-coins[idx]);
    //     return Math.min(take,notTake);

    // }

// using Memo 
static final int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans= solve(coins.length-1,coins,amount,dp);
        return ans>=INF?-1:ans;
    }
    public static int solve(int idx,int[] coins,int amount,int [][] dp){
        // base
        if(amount==0) return 0;
        if(idx==0){
            if(amount%coins[0]==0){
                return dp[idx][amount]=amount/coins[0];
            }
            else{
                return INF;
            }
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        //not take
        int notTake=solve(idx-1,coins,amount,dp);
        // take
        int take=INF;
        if(coins[idx]<=amount)
         take=1+solve(idx,coins,amount-coins[idx],dp);
        return dp[idx][amount]=Math.min(take,notTake);

    }
}