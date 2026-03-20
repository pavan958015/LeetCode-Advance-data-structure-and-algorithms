class Solution {
    // public boolean canJump(int[] nums) {
    //     int max = 0;
    //     for(int i = 0; i<nums.length; i++){
    //          if (i > max) return false;
    //         int maxjump = nums[i] + i;
    //         max = Math.max(max, maxjump);
    //         if(max>=nums.length-1){
    //             return true;
    //         }
    //     }
    //     return false;  
    // }

    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n+1];
        // Arrays.fill(dp,-1);
        return solve(0, n - 1, nums,dp);
    }

    public static boolean solve(int idx, int n, int nums[],boolean dp[]) {
        if (idx == n)
            return true;
        if(idx>n) return false;
        if(dp[idx]) return false;
        int maxJump=nums[idx];

        for(int i=1;i<=maxJump;i++){
            if(solve(idx+i,n,nums,dp)){
                return dp[i]=true;
            }
        }
        dp[idx]=true;
        return false;
    }
}