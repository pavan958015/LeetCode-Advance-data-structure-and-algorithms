class Solution {

    public void dfs(int i, int j, int[][] heights, boolean[][] vis) {
        int n = heights.length;
        int m = heights[0].length;

        vis[i][j] = true;

        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};


        for (int x=0;x<4;x++) {
            int ni = i + dx[x];
            int nj = j + dy[x];

            if (ni >= 0 && nj >= 0 && ni < n && nj < m
                    && !vis[ni][nj]
                    && heights[ni][nj] >= heights[i][j]) {

                dfs(ni, nj, heights, vis);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        boolean pacific[][] = new boolean[n][m];
        boolean altantic[][] = new boolean[n][m];

        // for Top and left bottom
        for (int r = 0; r < n; r++) {
            dfs(r, 0, heights, pacific);
            dfs(r, m - 1, heights, altantic);
        }
        // for right and right down
        for (int c = 0; c < m; c++) {
            dfs(0, c, heights, pacific);
            dfs(n - 1, c, heights, altantic);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && altantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}