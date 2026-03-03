class Solution {
    // Time Limit Exceeded;
    // public int tribonacci(int n){
    //     if(n==0) return 0;
    //     if(n==1) return 1;
    //     if(n==2) return 1;

    //     return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    // }

    // using Recursion

    // public int tribonacci(int n){
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(n,dp);
    // }
    // public int helper(int n,int[] dp) {
    //     if(n==0) return 0;
    //     if(n==1) return 1;
    //     if(n==2) return 1;

    //     if(dp[n]!=-1) return dp[n];

    //     return dp[n]=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
    // }

    // using Bottom Up
    public int tribonacci(int n){
        int dp[]=new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}