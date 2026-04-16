class Solution {
    public int maxCoins(int[] nums) {
        // add val in front and last 1
        int arr[]=new int[nums.length+2];
        int n=nums.length;

        arr[0]=1;
        arr[nums.length+1]=1;

        for(int i=0;i<nums.length;i++){
            arr[i+1]=nums[i];
        }
        Integer dp[][]=new Integer[n+2][n+2];

        return solve(1,n,arr,dp);
    }
    public static int solve(int i,int j,int[] arr,Integer [][]dp){
        if(i>j) return 0;

        if(dp[i][j]!=null) return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++){
            int cost=arr[i-1]*arr[idx]*arr[j+1]+solve(i,idx-1,arr,dp)+solve(idx+1,j,arr,dp);
            max=Math.max(cost,max);

        }
        dp[i][j]=max;
        return dp[i][j];
    }
    
}