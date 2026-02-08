class Solution {
    public static void dfs(int i,int j,char[][] grid,boolean[][] vis,int n,int m){
        // base;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0' || vis[i][j]) return;
        vis[i][j]=true;
        dfs(i,j-1,grid,vis,n,m);
        dfs(i,j+1,grid,vis,n,m);
        dfs(i-1,j,grid,vis,n,m);
        dfs(i+1,j,grid,vis,n,m);
    }
    public int numIslands(char[][] grid) {
        int islands=0;
        int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                     dfs(i,j,grid,vis,n,m);
                     islands++;
                }
            }
        }
        return islands;
    }
}