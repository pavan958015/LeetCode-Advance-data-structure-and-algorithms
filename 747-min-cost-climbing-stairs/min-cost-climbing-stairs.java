class Solution {
    // public int minCostClimbingStairs(int[] cost) {
    //     int dp[]=new int[cost.length+1];
    //     for(int i=2;i<dp.length;i++){
    //         dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
    //     }
    //     return dp[dp.length-1];
    // }

    public int minCostClimbingStairs(int[] cost){
        int dp[]=new int[cost.length+1];
        Arrays.fill(dp,-1);
        int one=helper(0,cost,cost.length,dp);
        int two=helper(1,cost,cost.length,dp);
        return Math.min(one,two);
    }
    public static int helper(int step,int[]cost,int n,int[] dp){
        if(step>=n){
            return 0;
        }
        if(dp[step]!=-1) return dp[step];
        int one=helper(step+1,cost,n,dp);
        int two=helper(step+2,cost,n,dp);
        return dp[step]=cost[step]+Math.min(one,two);
    }
}