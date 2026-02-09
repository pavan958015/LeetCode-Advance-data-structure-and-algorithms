class Solution {
    // public static int dfs(int i,int j,int[][] grid,boolean vis[][],int n,int m){
    //     if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0 || vis[i][j]){
    //         return 0;
    //     }
    //         vis[i][j]=true;

    //     int left=dfs(i,j-1,grid,vis,n,m);
    //     int right=dfs(i,j+1,grid,vis,n,m);
    //     int up=dfs(i-1,j,grid,vis,n,m);
    //     int down=dfs(i+1,j,grid,vis,n,m);

    //     return 1+left+right+up+down;
    // }

    // using bfs
    public static int bfs(int i, int j, int[][] grid, boolean vis[][], int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new int[] { i, j });

        int area = 1;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];

            // up

            if (r - 1 >= 0 && grid[r - 1][c] == 1 && !vis[r - 1][c]) {
                vis[r - 1][c] = true;
                q.add(new int[] { r - 1, c });
                area++;
            }
            //down

            if (r + 1 < n && grid[r + 1][c] == 1 && !vis[r + 1][c]) {
                vis[r + 1][c] = true;
                q.add(new int[] { r + 1, c });
                area++;
            }
            // left

            if (c - 1 >= 0 && grid[r][c - 1] == 1 && !vis[r][c - 1]) {
                vis[r][c - 1] = true;
                q.add(new int[] { r, c - 1 });
                area++;
            }

            // right
            if (c + 1 < m && grid[r][c + 1] == 1 && !vis[r][c + 1]) {
                vis[r][c + 1] = true;
                q.add(new int[] { r, c + 1 });
                area++;
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    // int res=dfs(i,j,grid,vis,n,m);
                    int res = bfs(i, j, grid, vis, n, m);
                    ans = Math.max(ans, res);
                }
            }
        }
        return ans;
    }

}