class Solution {
    static class Edge {
        int to;
        int w;
        Edge(int t, int w) {
            this.to = t;
            this.w = w;
        }
    }
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;
        Pair(int n, int d) {
            node = n;
            dist = d;
        }
        public int compareTo(Pair o) {
            return Long.compare(this.dist, o.dist);
        }
    }
    static int[] dijkstra(int src, int n, List<List<Edge>> adj) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.dist > dist[cur.node])
                continue;
            for (Edge e : adj.get(cur.node)) {
                if (dist[cur.node] + e.w < dist[e.to]) {
                    dist[e.to] = dist[cur.node] + e.w;
                    pq.add(new Pair(e.to, dist[e.to]));
                }
            }
        }
        return dist;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Edge(v, w));
            // adj.get(v).add(new Edge(u, w));
        }
        int dis[]=dijkstra(k,n,adj);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<dis.length;i++){
            // System.out.print(dis[i]+" ");
            max=Math.max(dis[i],max);
        }
        if(max==Integer.MAX_VALUE){
            return -1;
        }else{
            return max;
        } 
    }
}