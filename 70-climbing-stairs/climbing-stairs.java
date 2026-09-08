class Solution {
    public int climbStairs(int n){
        Integer[] dp=new Integer[n+1];

        return solve(n,dp);
    }
    public int solve(int idx,Integer[] dp) {
        if(idx<=2) return idx;

        if(dp[idx]!=null) return dp[idx];

        return dp[idx]=solve(idx-1,dp)+solve(idx-2,dp);
    }
}