class Solution {
    // public int maxProfit(int[] prices) {
    //     int dp[][]=new int[prices.length+1][2];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<dp[0].length;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return solve(0,1,prices,dp);
    // }


    // public static int solve(int idx,int flag,int arr[]){
    //     if(idx>=arr.length) return 0;

    //     // can buy
    //     if(flag==1){ 
    //         return     Math.max(-arr[idx]+solve(idx+1,0,arr),
    //                 // skip
    //                     solve(idx+1,1,arr));
    //     }
    //     //can sell
    //     else{
    //     return Math.max(arr[idx]+solve(idx+1,1,arr),
    //                     // skip
    //                     solve(idx+1,0,arr));
    //     }
    // }


    // public static int solve(int idx,int flag,int arr[],int dp[][]){
    //     if(idx>=arr.length) return 0;

    //     if(dp[idx][flag]!=-1){
    //         return dp[idx][flag];
    //     }
    //     // can buy
    //     if(flag==1){ 
    //         return dp[idx][flag]= Math.max(-arr[idx]+solve(idx+1,0,arr,dp),
    //                 // skip
    //                     solve(idx+1,1,arr,dp));
    //     }
    //     //can sell
    //     else{
    //         return dp[idx][flag]=Math.max(arr[idx]+solve(idx+1,1,arr,dp),
    //                     // skip
    //                     solve(idx+1,0,arr,dp));
    //     }
    // }


    // tabulation 
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int dp[][]=new int[n+1][2];

    //     for(int i=n-1;i>=0;i--){
    //         for(int j=0;j<2;j++){
    //             // buy
    //             dp[i][1]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
    //             // cell
    //             dp[i][0]=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
    //         }
    //     }
    //     return dp[0][1];
    // }

    // Space Optimization

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int cur[]=new int[2];
        int next[]=new int[2];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                // buy
                cur[1]=Math.max(-prices[i]+next[0],next[1]);
                // cell
                cur[0]=Math.max(prices[i]+next[1],next[0]);
            }
            next[0]=cur[0];
            next[1]=cur[1];

        }
        return next[1];
    }


}