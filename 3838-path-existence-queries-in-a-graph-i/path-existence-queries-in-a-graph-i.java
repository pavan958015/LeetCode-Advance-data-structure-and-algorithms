class Solution {
    public class DSU {
        int n;
        int size[];
        int par[];

        DSU(int n) {
            this.n = n;
            size = new int[n];
            par = new int[n];

            for(int i=0;i<n;i++){
                par[i]=i;
                size[i]=1;
            }
        }

        public int find(int node) {
            if (par[node] == node)
                return node;
            return par[node] = find(par[node]);
        }

        public void union(int u, int v) {
            int ul_u = find(u);
            int ul_v = find(v);

            if (ul_u == ul_v)
                return;

            if (size[ul_u] < size[ul_v]) {
                size[ul_v] += size[ul_u];
                par[ul_u] = ul_v;
            } else {
                size[ul_u] += size[ul_v];
                par[ul_v] = ul_u;
            }

        }

    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];

        DSU ds = new DSU(n);

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff) {
                ds.union(i, i + 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (ds.find(u) == ds.find(v)) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }
}