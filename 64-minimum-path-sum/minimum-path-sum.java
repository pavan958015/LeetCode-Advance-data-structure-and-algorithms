class Solution {
    // public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;

    //     return solve(0,0,n-1,m-1,grid);
    // }
    // public  int solve(int i,int j,int n,int m,int[][]grid){
    //     if(i==n && j==m) return grid[i][j];
    //     if(i>n || j>m) return Integer.MAX_VALUE;

    //     int bottom=solve(i+1,j,n,m,grid);
    //     int left=solve(i,j+1,n,m,grid);

    //     int min=Math.min(bottom,left);
    //     if(min==Integer.MAX_VALUE) return min;
        
    //     return grid[i][j]+min;

    // }

    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,n-1,m-1,grid,dp);
    }
    public  int solve(int i,int j,int n,int m,int[][]grid,int[][] dp){
        if(i==n && j==m) return grid[i][j];
        if(i>n || j>m) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int bottom=solve(i+1,j,n,m,grid,dp);
        int left=solve(i,j+1,n,m,grid,dp);

        int min=Math.min(bottom,left);
        if(min==Integer.MAX_VALUE) return min;
        
        return dp[i][j]=grid[i][j]+min;

    }
}