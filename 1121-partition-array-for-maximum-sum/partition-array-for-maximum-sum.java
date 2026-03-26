class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        // return solve(0,k,arr,dp);
        return tabulation(arr,k);
    }
    public static int solve(int idx,int k,int[] arr,int[] dp){
        if(idx==arr.length) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int len=0,max=0;
        int maxSum=0;
        for(int i=idx;i<Math.min(arr.length,idx+k);i++){
            max=Math.max(max,arr[i]);
            len++;
            int sum=len*max+solve(i+1,k,arr,dp);
            maxSum=Math.max(sum,maxSum);
        }
        return dp[idx]=maxSum;
    }
    public int tabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; // dp[n] = 0 by default

        for (int idx = n - 1; idx >= 0; idx--) {
            int len = 0, max = 0;
            int maxSum = 0;

            for (int i = idx; i < Math.min(n, idx + k); i++) {
                max = Math.max(max, arr[i]);
                len++;

                int sum = len * max + dp[i + 1];
                maxSum = Math.max(maxSum, sum);
            }

            dp[idx] = maxSum;
        }

        return dp[0];
    }
}