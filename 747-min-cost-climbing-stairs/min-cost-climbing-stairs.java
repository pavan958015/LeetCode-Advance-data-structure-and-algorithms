class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp=new Integer[cost.length];
        int oneStep = solve(0, cost,dp);
        int twoStep = solve(1, cost,dp);

        // return Math.min(oneStep, twoStep);

        return tabulation(cost);
    }

    private int solve(int idx, int[] nums,Integer[] dp) {
        if (idx >= nums.length)
            return 0;
        if(dp[idx]!=null) return dp[idx];

        int one = nums[idx] + solve(idx + 1, nums,dp);

        int two = nums[idx] + solve(idx + 2, nums,dp);

        return dp[idx]=Math.min(one, two);
    }
    private int tabulation(int[] nums){
        int n=nums.length;
        Integer[] dp=new Integer[n];

        if(n==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=nums[1];

        for(int i=2;i<n;i++){
            dp[i]=Math.min(nums[i]+dp[i-1],nums[i]+dp[i-2]);
        }
        return Math.min(dp[n-2],dp[n-1]);
    }
}