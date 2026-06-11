class Solution {
    private static final int mod = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=edges.length+2;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        return (int) pow(2,dfs(1,0,adj)-1);
    }
    private int dfs(int node, int prev, List<List<Integer>> graph) {
        int dist = 0;
        for (int g : graph.get(node))
            if (g != prev)
                dist = Math.max(dist, dfs(g, node, graph) + 1);
        return dist;
    }

    private long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 > 0)
                res = res * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return res;
    }
}