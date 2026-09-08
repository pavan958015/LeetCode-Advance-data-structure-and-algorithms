class Solution {
    public int climbStairs(int n){
        Integer[] dp=new Integer[n+1];

        // return solve(n,dp);
        return tabulation(n);
    }
    public int solve(int idx,Integer[] dp) {
        if(idx<=2) return idx;

        if(dp[idx]!=null) return dp[idx];

        return dp[idx]=solve(idx-1,dp)+solve(idx-2,dp);
    }
    private int tabulation(int n){
        Integer[] dp=new Integer[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}