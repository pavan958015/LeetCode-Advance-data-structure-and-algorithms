class Solution {
    // public int rob(int[] nums) {
    //     int dp[]=new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     return helper(nums.length-1,nums,dp);
    // }
    // public int helper(int n,int[] nums,int[] dp){
    //     if(n<0) return 0;
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int accept=nums[n]+helper(n-2,nums,dp);
    //     int skip=helper(n-1,nums,dp);
    //     dp[n]=Math.max(accept,skip);
    //     return dp[n];
    // }

    // public int rob(int[] nums){
    //     int n=nums.length;
    //     int dp[]=new int[nums.length+1];
    //     if(n==0) return 0;
    //     if(n==1) return nums[0];
    //     dp[0]=0;
    //     dp[1]=nums[0];
    //     for(int i=2;i<=n;i++){
    //         int accept=nums[i-1]+dp[i-2];
    //         int skip=dp[i-1];
    //         dp[i]=Math.max(accept,skip);
    //     }
    //     return dp[n];
    // }


    public int rob(int[] nums){
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int accept=nums[i];
            if(i>1)
                accept+=prev2;
            int skip=prev;
            int cur=Math.max(accept,skip);

            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}