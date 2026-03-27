class Solution {
    public static int dfs(int i, int j, int[][] grid, boolean[][] vis) {
        if (i < 0 || j < 0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || vis[i][j])
            return 0;

        vis[i][j] = true;

        int left = dfs(i, j - 1, grid, vis);
        int up = dfs(i - 1, j, grid, vis);
        int right = dfs(i, j + 1, grid, vis);
        int down = dfs(i + 1, j, grid, vis);

        return 1+left+right+up+down;
    }

    public static int bfs(int i, int j, int[][] grid, boolean[][] vis) {
        if (i < 0 || j < 0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || vis[i][j])
            return 0;
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;

        int area=0;

        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };

        while(!q.isEmpty()){
            int[] cur=q.poll();
            area++;
            
            for(int x=0;x<4;x++){
                int nx=cur[0]+dx[x];
                int ny=cur[1]+dy[x];

                if(nx>=0 &&ny>=0&&nx<grid.length && ny<grid[0].length && !vis[nx][ny] && grid[nx][ny] == 1){
                    q.add(new int[]{nx,ny});
                    vis[nx][ny]=true;
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (!vis[i][j]) {
                        // maxArea = Math.max(maxArea, dfs(i, j, grid, vis));
                        maxArea = Math.max(maxArea, bfs(i, j, grid, vis));

                    }
                }
            }
        }
        return maxArea;
    }
}