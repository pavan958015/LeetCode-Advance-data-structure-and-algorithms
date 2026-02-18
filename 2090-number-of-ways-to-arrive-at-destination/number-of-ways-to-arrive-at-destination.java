class Solution {
    static class Edges{
        int to;
        int w;
        Edges(int to,int w){
            this.to=to;
            this.w=w;
        }
    }
    static class Pair implements Comparable<Pair>{
        long dist;
        int node;
        Pair(long d,int n){
            this.dist=d;
            this.node=n;
        }
        public int compareTo(Pair o){
            return Long.compare(this.dist,o.dist);
        }
    }
    private int dijkstra(int source,int n,List<List<Edges>> adj){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        long dist[]=new long[n];
        long ways[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,source));

        int ans=0;
        int INF=1_000_000_007;

        while(!pq.isEmpty()){
            Pair cur=pq.poll();

            if(cur.dist>dist[cur.node]) continue;

            for(Edges e: adj.get(cur.node)){
                long newCost=cur.dist+e.w;
                if(newCost<dist[e.to]){
                    dist[e.to]=newCost;
                    ways[e.to]=ways[cur.node];
                    pq.add(new Pair(newCost,e.to));
                }
                else if (newCost == dist[e.to]) {
                    ways[e.to] = (ways[e.to] + ways[cur.node]) % INF;
                }
            }
        }
        return (int)(ways[n - 1] % INF);

    }
    public int countPaths(int n, int[][] roads) {
        List<List<Edges>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];

            adj.get(u).add(new Edges(v,w));
            adj.get(v).add(new Edges(u,w));
        }
        return dijkstra(0,n,adj);
    }
}