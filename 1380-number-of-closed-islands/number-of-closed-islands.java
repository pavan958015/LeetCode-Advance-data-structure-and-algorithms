class Solution {
    public static boolean dfs(int i,int j,int[][] grid,boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return false;

        if (grid[i][j] == 1 || vis[i][j]) {
        return true; 
        }

        vis[i][j]=true;

        boolean down=dfs(i+1,j,grid,vis);
        boolean up=dfs(i-1,j,grid,vis);
        boolean right=dfs(i,j+1,grid,vis);
        boolean left=dfs(i,j-1,grid,vis);

        return down && up && right && left;
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)
                    if(!vis[i][j])
                if(dfs(i,j,grid,vis)){
                    count++;
                }
            }
        }
        return count;
    }
}