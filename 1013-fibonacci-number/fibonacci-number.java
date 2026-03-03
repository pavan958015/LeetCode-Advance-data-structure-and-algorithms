class Solution {
    // public int fib(int n) {
    //     int[] dp=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(n,dp);
    // }
    // public static int helper(int n,int[] dp){
    //     if(n<=1){
    //         return n;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     return dp[n]=helper(n-1,dp)+helper(n-2,dp);
    // }

    public int fib(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        if(n==0) return 0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}