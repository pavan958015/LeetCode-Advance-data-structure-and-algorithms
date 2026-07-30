class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);

        return solve(0,arr,k,dp);       
    }
    private int solve(int idx,int[] arr,int k,int[] dp){
        if(idx==arr.length) return 0;

        if(dp[idx]!=-1) return dp[idx];
        int len=0;
        int max=0;
        int maxSum=0;
        for(int i=idx;i<Math.min(arr.length,idx+k);i++){
            max=Math.max(max,arr[i]);
            len++;
            int sum=len*max+solve(i+1,arr,k,dp);
            maxSum=Math.max(sum,maxSum);
        }
        return dp[idx]=maxSum;
    }
}