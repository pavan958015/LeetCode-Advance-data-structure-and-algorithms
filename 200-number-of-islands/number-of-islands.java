class Solution {
    public static void dfs(int i,int j,char[][] grid,boolean vis[][]){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]=='0' || vis[i][j]) return;
        
        vis[i][j]=true;

        dfs(i,j-1,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i+1,j,grid,vis);

    }
    public static void bfs(int i,int j,char[][] grid,boolean vis[][]){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]=='0' || vis[i][j]) return;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;

        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};

        while(!q.isEmpty()){
            int cur[]=q.poll();

            for(int x=0;x<4;x++){
                int nx=cur[0]+dx[x];
                int ny=cur[1]+dy[x];

                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]=='1' && !vis[nx][ny]){
                    q.add(new int[]{nx,ny});
                    vis[nx][ny]=true;
                }
            }
        }
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
                    // dfs(i,j,grid,vis);
                    bfs(i,j,grid,vis);

                }
            }
        }
        return islands;
    }
}