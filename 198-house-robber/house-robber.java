class Solution {
    public int rob(int[] nums) {
        Integer[] dp=new Integer[nums.length+1];
        return solve(0,nums,dp);
    }
    private int solve(int idx,int[] nums,Integer[] dp){
        if(idx>=nums.length) return 0;
        if(idx==nums.length-1) return nums[idx];

        if(dp[idx]!=null) return dp[idx];

        int pick=nums[idx]+solve(idx+2,nums,dp);
        int notPick=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(pick,notPick);
    }
}