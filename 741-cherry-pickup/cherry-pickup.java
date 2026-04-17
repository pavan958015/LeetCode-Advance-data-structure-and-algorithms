class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        Integer dp[][][][]=new Integer[n+1][n+1][n+1][n+1];

        int ans=solve(0,0,0,0,n-1,grid,dp);
        return Math.max(0,ans);
    }
    public static int solve(int r1,int c1,int r2,int c2,int n,int[][]grid,Integer[][][][]dp){
        if(r1>n || r2>n || c1>n || c2>n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;

        if(r1==n && c1==n || r2==n && c2==n) return grid[r1][c1];;

        if(dp[r1][c1][r2][c2]!=null) return dp[r1][c1][r2][c2];

        int charry=0;
        if(r1==r2 && c1==c2){
            charry=grid[r1][c1];
        }else{
            charry=grid[r1][c1]+grid[r2][c2];
        }

    // Both Down
    int a = solve(r1 + 1, c1, r2 + 1, c2, n, grid, dp);
    //  Down Right
    int b = solve(r1 + 1, c1, r2, c2 + 1, n, grid, dp);
    // Right Down
    int c = solve(r1, c1 + 1, r2 + 1, c2, n, grid, dp);
    // Both Right
    int d = solve(r1, c1 + 1, r2, c2 + 1, n, grid, dp);
        
        return dp[r1][c1][r2][c2]=charry+Math.max(Math.max(a,b),Math.max(c,d));

        
    }
}