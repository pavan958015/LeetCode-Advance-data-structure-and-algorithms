class Solution {
    
    public static int minFallingPathSum(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans = Integer.MAX_VALUE;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        // last row ke har column se start
        for (int col = 0; col < m; col++) {
            ans = Math.min(ans, helper(n - 1, col, matrix,dp));
        }
        return ans;
    }

    public static int helper(int row, int col, int matrix[][],int dp[][]) {
        if (col < 0 || col >= matrix[0].length)
            return Integer.MAX_VALUE;
        if (row == 0)
            return matrix[0][col];
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        int s = helper(row - 1, col, matrix,dp);
        int ld = helper(row - 1, col - 1, matrix,dp);
        int rd = helper(row - 1, col + 1, matrix,dp);

        int min = Math.min(s, Math.min(ld, rd));
        if (min == Integer.MAX_VALUE) {
            return dp[row][col]=Integer.MAX_VALUE;
        }
        return dp[row][col]=matrix[row][col] + min;
    }

}