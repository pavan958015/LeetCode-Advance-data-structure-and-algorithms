class Solution {
    // public int change(int amount, int[] coins) {
    //     return solve(coins.length-1,amount,coins);
    // }
    // public static int solve(int idx,int amount,int [] coins){
    //     // base;
    //     if(idx==0){
    //         if(amount % coins[0]==0){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }

    //     // take
    //     int take=0;
    //     if(coins[idx]<=amount){
    //         take=solve(idx,amount-coins[idx],coins);
    //     }
    //     // not take
    //     int notTake=solve(idx-1,amount,coins);

    //     return take+notTake;
    // }


    // using DP
    // public int change(int amount, int[] coins) {
    //     int dp[][]=new int[coins.length][amount+1];
    //     for(int i=0;i<coins.length;i++){
    //         for(int j=0;j<dp[0].length;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return solve(coins.length-1,amount,coins,dp);
    // }
    // public static int solve(int idx,int amount,int [] coins,int[][] dp){
    //     // base;
    //     if(idx==0){
    //         if(amount % coins[0]==0){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
    //     if(dp[idx][amount]!=-1)
    //         return dp[idx][amount];
    //     // take
    //     int take=0;
    //     if(coins[idx]<=amount){
    //         take=solve(idx,amount-coins[idx],coins,dp);
    //     }
    //     // not take
    //     int notTake=solve(idx-1,amount,coins,dp);

    //     return dp[idx][amount]=take+notTake;
    // }

    // tabulation 
    public int change(int amount, int[] coins){
        int n=coins.length;
        int tab[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            tab[i][0]=1;
        }
        for(int j=1;j<=amount;j++){
            if(j%coins[0]==0)
                tab[0][j]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                // take
                int take=0;
                if(coins[i]<=j){
                    take=tab[i][j-coins[i]];
                }
                // not take
                int notTake=tab[i-1][j];

                tab[i][j]=take+notTake;
            }
        }
        return tab[n-1][amount];

    }
}