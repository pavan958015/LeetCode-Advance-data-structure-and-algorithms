class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newArr[] = new int[n + 2];
        newArr[0] = 1;
        newArr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            newArr[i + 1] = nums[i];
        }
        // return solve(1,n,newArr,dp);
        return tabulation(newArr, n);
    }

    private int solve(int i, int j, int[] nums, Integer dp[][]) {
        if (i > j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1] +
                    solve(i, k - 1, nums, dp) +
                    solve(k + 1, j, nums, dp);

            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    private int tabulation(int nums[],int n){
        int dp[][]=new int[n+2][n+2];

        for(int i=n;i>=1;i--){
            for(int j=0;j<=n;j++){
                if(i>j) continue;
                int max=0;

                for(int k=i;k<=j;k++){
                    int cost=nums[i-1]*nums[k]*nums[j+1]+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(cost,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
}