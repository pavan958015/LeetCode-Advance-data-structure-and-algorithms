class Solution {
    int n;
    int m;
    public boolean hasValidPath(char[][] grid) {
        n=grid.length;
        m=grid[0].length;

        Boolean[][][] dp=new Boolean[n][m][n+m];

        if((n+m-1)%2!=0) return false;

        if(grid[0][0]==')' || grid[n-1][m-1]=='(') return false;

        return solve(0,0,0,grid,dp);
    }
    private boolean solve(int i,int j,int balance,char[][] grid,Boolean[][][] dp){
        if (balance > (m - i) + (n - j) - 1) {
            return false;
        }
        
        if(grid[i][j]=='(') balance++;
        else balance--;

        if(balance<0) return false;

        if(dp[i][j][balance]!=null) return dp[i][j][balance];
        if(i==n-1 && j==m-1)
            return balance==0;

        boolean ans=false;
        if(i+1<n){
            ans=ans || solve(i+1,j,balance,grid,dp);
        }
        if(j+1<m){
            ans=ans || solve(i,j+1,balance,grid,dp);
        }

        return dp[i][j][balance]=ans;

    }
}