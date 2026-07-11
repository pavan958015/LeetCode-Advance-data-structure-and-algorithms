class Solution {
    public static void dfs(int idx, List<List<Integer>> adj, int[]count, boolean vis[]) {
        vis[idx] = true;
        count[0]++;
        count[1]+=adj.get(idx).size();

        for (int nei : adj.get(idx)) {
            if (!vis[nei])
                dfs(nei, adj,count, vis);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        

        boolean vis[] = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int count[]=new int[2];
                dfs(i, adj,count, vis);

                int node=count[0];
                int edge=count[1]/2;

                if (edge==node*(node-1)/2)
                    ans++;
            }
        }
        return ans;
    }
}