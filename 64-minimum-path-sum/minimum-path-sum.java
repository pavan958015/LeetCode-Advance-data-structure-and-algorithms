class Solution {
    int n,m;
    public int minPathSum(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        Integer[][] dp=new Integer[n][m];
        return solve(0,0,grid,dp);
    }
    private int solve(int i,int j,int[][] grid,Integer[][] dp){
        if(i>=n ||  j>=m) return Integer.MAX_VALUE;

        if(i==n-1 && j==m-1) return dp[i][j]=grid[i][j];

        if(dp[i][j]!=null) return dp[i][j];


        int down=solve(i+1,j,grid,dp);
        int right=solve(i,j+1,grid,dp);

        return dp[i][j]=grid[i][j]+Math.min(down,right);
    }
}