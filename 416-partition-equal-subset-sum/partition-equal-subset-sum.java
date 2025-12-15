class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if (sum % 2 != 0) return false;
        return subsetProblem(nums,nums.length,sum/2); 
    }

// gfg question     
    public static boolean subsetProblem(int arr[], int n, int target) {
        int dp[][] = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, n, target, dp);

    }

    public static boolean solve(int arr[], int n, int target, int dp[][]) {
        if (target == 0)
            return true;
        if (n <= 0)
            return false;
        if (target < 0)
            return false;
        if (dp[n][target] != -1) {
            return dp[n - 1][target] == 1;
        } else {
            dp[n][target] = solve(arr, n - 1, target, dp) || solve(arr, n - 1, target -
                    arr[n - 1], dp) ? 1 : 0;
            return dp[n][target] == 1;
        }
    }

}