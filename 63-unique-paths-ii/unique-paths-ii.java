class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int n=obstacleGrid.length;
     int m=obstacleGrid[0].length;
     int dp[][]=new int[n][m];
      for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
     return helper(0,0,n,m,dp,obstacleGrid);   
    }
    private int helper(int sr,int sc,int n,int m,int[][]dp,int[][]grid){
        if(sr>=n || sc>=m) return 0;

        if(grid[sr][sc]==1) return 0;

        if(sr==n-1 && sc==m-1) return 1;
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        dp[sr][sc]= helper(sr+1,sc,n,m,dp,grid)+helper(sr,sc+1,n,m,dp,grid);
        return dp[sr][sc];
    }
}