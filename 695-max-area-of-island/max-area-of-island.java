class Solution {
    public static int dfs(int i,int j,int[][] grid,boolean vis[][],int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0 || vis[i][j]){
            return 0;
        }
            vis[i][j]=true;
        
        int left=dfs(i,j-1,grid,vis,n,m);
        int right=dfs(i,j+1,grid,vis,n,m);
        int up=dfs(i-1,j,grid,vis,n,m);
        int down=dfs(i+1,j,grid,vis,n,m);

        return 1+left+right+up+down;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int ans=0;
        boolean vis[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int res=dfs(i,j,grid,vis,n,m);
                ans=Math.max(ans,res);
            }
        }
        return ans;
    }

}