class Solution {

    //using Recrsion and DP

    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return usingRecursion(0,n-1,nums,dp);
    // }
    // public static int usingRecursion(int idx,int n,int [] nums,int[] dp){
    //     if(idx>n) return 0;
    //     if(idx==n) return nums[idx];

    //     if(dp[idx]!=-1) return dp[idx];

    //     int pick=nums[idx]+usingRecursion(idx+2,n,nums,dp);
    //     int Notpick=usingRecursion(idx+1,n,nums,dp);

    //     return dp[idx]=Math.max(pick,Notpick);
    // }

    // public int rob(int[] nums){
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,Integer.MIN_VALUE);
    //     dp[0]=nums[0];
    //     dp[1]=Math.max(nums[0],nums[1];

    //     for(int i=2;i<n;i++){
    //         int pick=nums[i]+dp[i-2];
    //         int notPick=dp[i-1];
    //         dp[i]=Math.max(pick,notPick);
    //     }
    //     return dp[n-1];
    // }

    public int rob(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int pick=nums[i]+prev2;
            int notPick=prev1;

            int cur=Math.max(pick,notPick);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;

    }
}