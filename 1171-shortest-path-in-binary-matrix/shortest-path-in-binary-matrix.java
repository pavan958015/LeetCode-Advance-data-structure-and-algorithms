class Solution {

    static class Triple {
        int dist;
        int r;
        int c;

        Triple(int dist, int r, int c) {
            this.dist = dist;
            this.r = r;
            this.c = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<Triple> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        q.offer(new Triple(1, 0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {

            Triple cur = q.poll();

            int dist = cur.dist;
            int r = cur.r;
            int c = cur.c;

            if (r == n - 1 && c == n - 1)
                return dist;

            for (int i = 0; i < 8; i++) {

                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    !vis[nr][nc] && grid[nr][nc] == 0) {

                    vis[nr][nc] = true;
                    q.offer(new Triple(dist + 1, nr, nc));
                }
            }
        }

        return -1;
    }
}