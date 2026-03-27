class Solution {
    public static void dfs(int i,int j,char[][] grid,boolean vis[][]){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]=='0' || vis[i][j]) return;
        
        vis[i][j]=true;

        dfs(i,j-1,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i+1,j,grid,vis);

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];

        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return islands;
    }
}