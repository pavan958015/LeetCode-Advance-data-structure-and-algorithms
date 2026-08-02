class Solution {
    // public boolean stoneGame(int[] piles) {
    //     return true;
    // }
    public boolean stoneGame(int[] piles){
        Integer[][] dp=new Integer[piles.length][piles.length];

        // return solve(0,piles.length-1,piles,dp)>0;
        return tabulation(piles)>0;
    }
    // private int solve(int i,int j,int[] piles,Integer[][] dp){
    //     if(i==j) return piles[i];

    //     if(dp[i][j]!=null) return dp[i][j];
    //     int left=piles[i]-solve(i+1,j,piles,dp);
    //     int right=piles[j]-solve(i,j-1,piles,dp);


    //     return dp[i][j]=Math.max(left,right);
    // }

    private int tabulation(int piles[]){
        int n=piles.length;
        int dp[][]=new int[n+1][n+1];

        for(int i=0;i<n;i++){
            dp[i][i]=piles[i];
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}