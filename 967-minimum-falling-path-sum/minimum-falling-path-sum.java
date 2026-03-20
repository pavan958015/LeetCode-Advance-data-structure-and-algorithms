class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        
        int ans=Integer.MAX_VALUE;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int j=0;j<n;j++){
            ans=Math.min(ans,solve(0,j,matrix,dp));
        }
        return ans;
    }
    public static int solve(int i,int j,int matrix[][],int[][] dp){
        int n=matrix.length;

        if(j<0 || j>=n) return Integer.MAX_VALUE;
        
        if(i==n-1) return matrix[i][j];

        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int downLeft=solve(i+1,j-1,matrix,dp);
        int down=solve(i+1,j,matrix,dp);
        int downRight=solve(i+1,j+1,matrix,dp);

        return dp[i][j]=matrix[i][j]+Math.min(downLeft,Math.min(down,downRight));

    }
}