class Solution {
    public int rob(int[] nums) {
        Integer[] dp=new Integer[nums.length+1];
        // return solve(0,nums,dp);
        return tabulation(nums);
    }
    private int solve(int idx,int[] nums,Integer[] dp){
        if(idx>=nums.length) return 0;
        if(idx==nums.length-1) return nums[idx];

        if(dp[idx]!=null) return dp[idx];

        int pick=nums[idx]+solve(idx+2,nums,dp);
        int notPick=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(pick,notPick);
    }

    private int tabulation(int[] nums){
        Integer[] dp=new Integer[nums.length];

        if(nums.length==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+dp[i-2];
            int notPick=dp[i-1];

            dp[i]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }
}