class Solution {
    static class Pair {
        int dist;
        int r;
        int c;

        Pair(int dist, int r, int c) {
            this.dist = dist;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Pair(0, 0, 0));

        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int d = p.dist;
            int r = p.r;
            int c = p.c;

            if (r == n - 1 && c == m - 1)
                return d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int diff = Math.max(Math.abs(heights[nr][nc] - heights[r][c]), d);
                    if (diff < dist[nr][nc]) {
                        dist[nr][nc] = diff;
                        pq.add(new Pair(diff, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}