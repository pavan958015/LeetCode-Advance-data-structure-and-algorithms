class Solution {
    public  int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0, -1, nums,dp);
    }

    // public static int solve(int idx, int past, int[] nums) {
    //     // base;
    //     if (idx == nums.length)
    //         return 0;

    //     // take
    //     int take = 0;
    //     if (nums[idx]>past) {

    //         take = 1 + solve(idx + 1, nums[idx], nums);
    //     }
    //     // not take;
    //     int notTake = solve(idx + 1, past, nums);

    //     return Math.max(take, notTake);
    // }

    // dp 
    public static int solve(int idx, int past, int[] nums,int dp[][]) {
        // base;
        if (idx == nums.length)
            return 0;
        if(dp[idx][past+1]!=-1){
            return dp[idx][past+1];
        }
        // take;
        int take = 0;
            if (past == -1 || nums[idx] > nums[past]){
            take = 1 + solve(idx + 1, idx, nums,dp);
        }
        // not take;
        int notTake = solve(idx + 1, past, nums,dp);

        return dp[idx][past+1]=Math.max(take, notTake);
    }

}