class Solution {
    public static int[] dy={-1,0,1};
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        int ans = dfs(0,0,m-1,grid,dp);
        return Math.max(0, ans);
    }
    public static int dfs(int row,int col1,int col2,int grid[][],int[][][] dp){
        if(row==grid.length) return 0;
        if(col1<0 || col2<0) return Integer.MIN_VALUE;
        if(col1>=grid[0].length || col2>=grid[0].length) return Integer.MIN_VALUE;

        if(dp[row][col1][col2]!=Integer.MIN_VALUE) return dp[row][col1][col2];

        int maxCherry=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                maxCherry=Math.max(maxCherry,dfs(row+1,col1+dy[i],col2+dy[j],grid,dp));
            }
        }
        maxCherry+=col1==col2?grid[row][col1]:grid[row][col1]+grid[row][col2];

        return dp[row][col1][col2]=maxCherry;
    }

}