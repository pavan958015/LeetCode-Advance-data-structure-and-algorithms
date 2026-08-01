class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        Integer[][] dp=new Integer[nums.length][nums.length];
        return solve(0,nums.length-1,nums,dp)>=0;
    }
    private int solve(int i,int j,int[] nums,Integer[][] dp){
        if(i==j) return nums[i];

        if(dp[i][j]!=null) return dp[i][j];

        int pickLeft=nums[i]-solve(i+1,j,nums,dp);
        int pickRight=nums[j]-solve(i,j-1,nums,dp);

        return dp[i][j]= Math.max(pickLeft,pickRight);
    }
}