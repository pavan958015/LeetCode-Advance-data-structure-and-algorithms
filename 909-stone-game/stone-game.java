class Solution {
    // public boolean stoneGame(int[] piles) {
    //     return true;
    // }
    public boolean stoneGame(int[] piles){
        Integer[][] dp=new Integer[piles.length][piles.length];

        return solve(0,piles.length-1,piles,dp)>0;
    }
    private int solve(int i,int j,int[] piles,Integer[][] dp){
        if(i==j) return piles[i];

        if(dp[i][j]!=null) return dp[i][j];
        int left=piles[i]-solve(i+1,j,piles,dp);
        int right=piles[j]-solve(i,j-1,piles,dp);


        return dp[i][j]=Math.max(left,right);
    }
}