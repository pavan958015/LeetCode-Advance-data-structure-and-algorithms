class Solution {
    static class Pair implements Comparable<Pair>{
        int count;
        int row;
        int column;

        Pair(int a, int b, int c) {
            count = a;
            row = b;
            column = c;
        }
        public int compareTo(Pair o){
            return Integer.compare(this.count,o.count);
        }
    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dist[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int c = cur.count;
            int x = cur.row;
            int y = cur.column;

            if(x==m-1 && y==n-1) return c;
            if (c > dist[x][y])
                continue;

            for (int i = 0; i < 4; i++) {
                int newR = x + dx[i];
                int newC = y + dy[i];

                if(newR<0 || newC<0 || newR>=m || newC>=n) continue;

                int newCost=c+grid[newR][newC];
                if(newCost<dist[newR][newC]){
                    dist[newR][newC]=newCost;
                    pq.add(new Pair(newCost, newR, newC));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dist[i][j]+" ");
            }
        }
        return dist[m-1][n-1];
    }
}