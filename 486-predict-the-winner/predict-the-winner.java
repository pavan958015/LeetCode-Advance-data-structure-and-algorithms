class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        Integer[][] dp=new Integer[nums.length][nums.length];
        // return solve(0,nums.length-1,nums,dp)>=0;
        return tabulation(nums,nums.length)>=0;
    }
    private int solve(int i,int j,int[] nums,Integer[][] dp){
        if(i==j) return nums[i];

        if(dp[i][j]!=null) return dp[i][j];

        int pickLeft=nums[i]-solve(i+1,j,nums,dp);
        int pickRight=nums[j]-solve(i,j-1,nums,dp);

        return dp[i][j]= Math.max(pickLeft,pickRight);
    }
    private int tabulation(int[] nums,int n){
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int pickLeft=nums[i]-dp[i+1][j];
                int pickRight=nums[j]-dp[i][j-1];

                dp[i][j]=Math.max(pickLeft,pickRight);
            }
        }
        return dp[0][n-1];
    }
}