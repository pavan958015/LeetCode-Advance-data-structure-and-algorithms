class Solution {
    int count=0;
    private void dfs(int i,int j,int empty,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1) return; 

        if(grid[i][j]==1){
            if(empty==0){
                count++;
                return;
            } 
        }

        empty--;
        int temp=grid[i][j];
        grid[i][j]=-1;

        dfs(i+1,j,empty,grid);
        dfs(i-1,j,empty,grid);
        dfs(i,j+1,empty,grid);
        dfs(i,j-1,empty,grid);

        empty++;
        grid[i][j]=temp;
    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int x=0;int y=0;
        int empty=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) empty++;
                if(grid[i][j]==2){
                    x=i;
                    y=j;
                    empty++;
                }
            }
        }
        dfs(x,y,empty,grid);
        return count;
    }
}