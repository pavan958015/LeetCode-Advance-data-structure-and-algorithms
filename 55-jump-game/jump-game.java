class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length+1];
        return solve(0,nums.length-1,dp,nums);
    }
    private boolean solve(int idx,int n,Boolean[] dp,int[]nums){
        if(idx>=n) return true;

        if(dp[idx]!=null) return dp[idx]; 

        int jump=nums[idx];

        for(int i=1;i<=jump;i++){
            if(solve(idx+i,n,dp,nums)) return dp[idx+i]=true;
        }

        return dp[idx]=false;
    }
}