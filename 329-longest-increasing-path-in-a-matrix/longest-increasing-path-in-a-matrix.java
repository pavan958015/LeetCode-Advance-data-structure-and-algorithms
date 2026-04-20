class Solution {
    public static int solve(int i,int j,int[][] matrix,int dir[][],int dp[][]){
        if(dp[i][j]!=0) return dp[i][j];

        int maxLen=1;

        for(int d[]:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            

        if(nx>=0 && ny>=0 && nx<matrix.length && ny<matrix[0].length && matrix[i][j]<matrix[nx][ny]){
            int len=1+solve(nx,ny,matrix,dir,dp);
           maxLen= Math.max(len,maxLen);
        }
        }
        return dp[i][j]=maxLen;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        int ans=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, solve(i, j, matrix, dir, dp));
            }
        }
        return ans;
    }
}