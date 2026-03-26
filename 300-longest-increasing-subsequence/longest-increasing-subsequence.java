class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // return solve(0, -1, nums, dp);
        return tabulation(nums);
    }

    public static int solve(int idx, int prev, int[] nums, int dp[][]) {
        if (idx >= nums.length)
            return 0;

        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + solve(idx + 1, idx, nums, dp);
        }
        int notTake = solve(idx + 1, prev, nums, dp);
        return dp[idx][prev + 1] = Math.max(take, notTake);
    }

    public static int tabulation(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    take = 1 + dp[idx + 1][idx+1];
                }
                int notTake = dp[idx + 1][prev+1];
                dp[idx][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}