class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int x:nums) if(x>max) max=x;

        int freq[]=new int[max+1];

        for(int x:nums){
            freq[x]++;
        }
        Integer[] dp=new Integer[max+1];
        return solve(0,freq,dp);
    }
    private int solve(int idx,int[] nums,Integer[] dp){
        if(idx==nums.length-1) return nums[idx]*idx;

        if(idx>=nums.length) return 0;

        if(dp[idx]!=null) return dp[idx];

        int pick=nums[idx]*idx+solve(idx+2,nums,dp);
        int notPick=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(pick,notPick);
    }
}