class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;

        Long[]dp=new Long[n];
        return solve(0,questions,dp);
    }
    private long solve(int idx,int[][] nums,Long[] dp){
        if(idx>=nums.length) return 0;

        if(dp[idx]!=null) return dp[idx];

        
        long pick=nums[idx][0]+solve(idx+1+nums[idx][1],nums,dp);
        long not=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(pick,not);
    }
}