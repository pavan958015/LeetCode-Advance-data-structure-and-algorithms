class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
    public int helper(int n,int[] nums,int[] dp){
        if(n<0) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int accept=nums[n]+helper(n-2,nums,dp);
        int skip=helper(n-1,nums,dp);
        dp[n]=Math.max(accept,skip);
        return dp[n];
    }
}