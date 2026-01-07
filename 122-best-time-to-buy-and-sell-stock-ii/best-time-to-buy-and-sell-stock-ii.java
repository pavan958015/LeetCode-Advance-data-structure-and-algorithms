class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,1,prices,dp);
    }
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


    public static int solve(int idx,int flag,int arr[],int dp[][]){
        if(idx>=arr.length) return 0;

        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        // can buy
        if(flag==1){ 
            return    dp[idx][flag]= Math.max(-arr[idx]+solve(idx+1,0,arr,dp),
                    // skip
                        solve(idx+1,1,arr,dp));
        }
        //can sell
        else{
        return dp[idx][flag]=Math.max(arr[idx]+solve(idx+1,1,arr,dp),
                        // skip
                        solve(idx+1,0,arr,dp));
        }
    }
}