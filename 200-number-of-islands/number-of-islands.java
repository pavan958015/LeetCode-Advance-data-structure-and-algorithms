class Solution {
    // public static void dfs(int i,int j,int n,int m,char[][] grid,boolean[][] vis){
    //     //base conditon
    //     if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0' || vis[i][j]){
    //         return;
    //     }
    //     vis[i][j]=true;

    //     //up
    //     dfs(i-1,j,n,m,grid,vis);
    //     //down
    //     dfs(i+1,j,n,m,grid,vis);
    //     //left
    //     dfs(i,j-1,n,m,grid,vis);
    //     //right
    //     dfs(i,j+1,n,m,grid,vis);

    // }

    // using bsf
    public static void bfs(int i, int j, int n, int m, char[][] grid, boolean vis[][]) {
       
        Queue<int[]> q=new LinkedList<>();
        vis[i][j]=true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int []cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            // for up;
            if(x-1>=0 && grid[x-1][y]=='1' && !vis[x-1][y]){
                vis[x-1][y]=true;
                q.add(new int[]{x-1,y});
            }
            // for down;
            if(x+1<n && grid[x+1][y]=='1' && !vis[x+1][y]){
                vis[x+1][y]=true;
                q.add(new int[]{x+1,y});
            }
            // for left
            if(y-1>=0 && grid[x][y-1]=='1' && !vis[x][y-1]){
                vis[x][y-1]=true;
                q.add(new int[]{x,y-1});
            }
            //  for right
            if(y+1<m && grid[x][y+1]=='1' && !vis[x][y+1]){
                vis[x][y+1]=true;
                q.add(new int[]{x,y+1});
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        int island = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    // dfs(i, j, n, m, grid, vis);
                    bfs(i, j, n, m, grid, vis);
                    island++;
                }
            }
        }
        return island;
    }
}