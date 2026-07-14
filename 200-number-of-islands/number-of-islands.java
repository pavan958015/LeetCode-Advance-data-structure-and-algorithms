class Solution {
    static class Pair{
        int i;int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    private void dfs(int i,int j,char[][] grid,boolean[][] vis){
        if(i<0 || j<0 || i>=vis.length || j>=vis[i].length || grid[i][j]=='0' || vis[i][j]) return;

        vis[i][j]=true;
        dfs(i+1,j,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i,j-1,grid,vis);

    }
    private void bfs(int i,int j,int n,int m,char[][] grid,boolean vis[][]){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;

        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};

        while(!q.isEmpty()){
            Pair p=q.poll();

            for(int x=0;x<4;x++){
                int nx=p.i+dx[x];
                int ny=p.j+dy[x];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && grid[nx][ny]=='1'){
                    vis[nx][ny]=true;
                    q.add(new Pair(nx,ny));
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    // dfs(i,j,grid,vis);
                    bfs(i,j,n,m,grid,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}