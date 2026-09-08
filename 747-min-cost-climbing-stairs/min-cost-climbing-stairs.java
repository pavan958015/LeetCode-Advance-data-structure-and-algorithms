class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp=new Integer[cost.length];
        int oneStep = solve(0, cost,dp);
        int twoStep = solve(1, cost,dp);

        return Math.min(oneStep, twoStep);
    }

    private int solve(int idx, int[] nums,Integer[] dp) {
        if (idx >= nums.length)
            return 0;
        if(dp[idx]!=null) return dp[idx];

        int one = nums[idx] + solve(idx + 1, nums,dp);

        int two = nums[idx] + solve(idx + 2, nums,dp);

        return dp[idx]=Math.min(one, two);

    }
}