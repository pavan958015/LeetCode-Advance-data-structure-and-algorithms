class Solution {
    // Bottom Up Approch
    // public int climbStairs(int n) {
    //     if(n<=1) return 1;
    //     int dp[]=new int[n+1];
    //     dp[0]=0;
    //     dp[1]=1;
    //     dp[2]=2;
    //     for(int i=3;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    
    // Time Limit Exceed
    // Using Recursion
    // public int climbStairs(int n){
    //     if(n<=2)
    //         return n;
    //     return climbStairs(n-1)+climbStairs(n-2);
    // }

    // Top Down + Memorization
    // public int climbStairs(int n){
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(n,dp);
    // }
    // public int helper(int n,int[] dp){
    //     if(n<=1){
    //         return 1;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     return dp[n]=helper(n-1,dp)+helper(n-2,dp);
    // }
    

    // Space Optimization
    // public int climbStairs(int n) {
    //     int zero = 1;
    //     int first = 1;
    //     for (int i = 2; i <= n; i++) {
    //         int c = zero + first;
    //         zero = first;
    //         first = c;
    //     }
    //     return first;
    // }

    public int climbStairs(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs2(n,dp);
    }
    public static int climbStairs2(int n,int[]dp){
        if(n<=1) return 1;

        if(dp[n]!=-1) return dp[n];
        int oneStep=climbStairs2(n-1,dp);
        int twoStep=climbStairs2(n-2,dp);
        return dp[n]= oneStep+twoStep;
    }
}