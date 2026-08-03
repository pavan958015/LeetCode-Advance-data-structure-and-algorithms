class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] dp=new Integer[stoneValue.length];
        int ans=solve(0,stoneValue.length-1,stoneValue,dp);   

        if(ans>0) return "Alice";
        else if(ans<0) return "Bob";
        else return "Tie";
    }
    private int solve(int i,int n,int[] nums,Integer[] dp){
        if(i>n) return 0;

        if(dp[i]!=null) return dp[i];

        int ans=Integer.MIN_VALUE;

        int take=0;
        for(int k=0;k<3 && i+k<=n;k++){
            take+=nums[i+k];
            ans=Math.max(ans,take-solve(i+k+1,n,nums,dp));
        }
        return dp[i]=ans;
    }
}