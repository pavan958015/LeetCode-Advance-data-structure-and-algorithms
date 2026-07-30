class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int newArr[]=new int[n+2];
        newArr[0]=1;
        newArr[n+1]=1;

        for(int i=0;i<n;i++){
            newArr[i+1]=nums[i];
        }

        Integer dp[][]=new Integer[n+2][n+2];

        return solve(1,n,newArr,dp);
    }
    private int solve(int i,int j,int[] nums,Integer dp[][]){
        if(i>j) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int max=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){
            int cost=nums[i-1]*nums[k]*nums[j+1]+
            solve(i,k-1,nums,dp)+
            solve(k+1,j,nums,dp);

            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}