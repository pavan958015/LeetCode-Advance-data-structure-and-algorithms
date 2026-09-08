class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int skipFirst[]=new int[n-1];
        int skipLast[]=new int[n-1];

        for(int i=0;i<n-1;i++){
            skipFirst[i]=nums[i+1];
            skipLast[i]=nums[i];
        }
        Integer[] dp1=new Integer[n-1];
        Integer[] dp2=new Integer[n-1];


        return Math.max(solve(0,skipFirst,dp1),solve(0,skipLast,dp2));
    }
    private int solve(int idx,int[]nums,Integer[] dp){
        if(idx>=nums.length) return 0;

        if(dp[idx]!=null) return dp[idx];

        int pick=nums[idx]+solve(idx+2,nums,dp);
        int notPick=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(pick,notPick);
    }
}