class Solution {
    int totalSum;
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        totalSum=0;
        for(int n:nums)
            totalSum+=n;
        
        if(totalSum%2!=0) return false;

        dp=new Boolean[nums.length][totalSum/2+1];
        return solve(0,nums,totalSum/2);
    }
    private boolean solve(int idx,int[] nums,int target){
        if(idx>=nums.length) return false;
        if(idx==nums.length-1){
            if(target-nums[idx]==0) return dp[idx][target]= true;
        }

        if(target==0) return true;

        if(target<0) return false;

        if(dp[idx][target]!=null) return dp[idx][target];


        boolean take=false;
             take= solve(idx+1,nums,target-nums[idx]);
        boolean notTake=solve(idx+1,nums,target);

        return dp[idx][target]=take || notTake;
    }
}