class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int arr[] = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(arr);
        return solve(1, m, arr, dp);
    }

    public static int solve(int i, int j, int[] nums, int dp[][]) {
        if (i > j)
            return 0;

        int min = Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int idx = i; idx <= j; idx++) {
            int cost = nums[j + 1]-nums[i - 1]+solve(i, idx - 1, nums, dp)+solve(idx + 1, j, nums, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}