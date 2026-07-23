class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int nums[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = scores[i];
            nums[i][1] = ages[i];
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        Integer[][] dp=new Integer[n][n+1];

        return solve(0, -1, n, nums,dp);
    }

    private int solve(int idx, int prev, int n, int[][] nums,Integer[][] dp) {
        if (idx >= n)
            return 0;

        if(dp[idx][prev+1]!=null) return dp[idx][prev+1];

        int choose = 0;
        if (prev == -1 || nums[prev][0] <= nums[idx][0]) {
            choose = nums[idx][0] + solve(idx + 1, idx, n, nums,dp);
        }
        int not = solve(idx + 1, prev, n, nums,dp);

        return dp[idx][prev+1]=Math.max(choose, not);
    }
}