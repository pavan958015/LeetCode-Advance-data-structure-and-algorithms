class Solution {
    // public int findCircleNum(int[][] isConnected) {
    //     int n = isConnected.length;
    //     int provience = 0;
    //     boolean vis[] = new boolean[n];
    //     for (int i = 0; i < n; i++) {
    //         if (vis[i] == false) {
    //             provience++;
    //             // bfs(i, isConnected, vis);
    //             dfs(i, isConnected, vis);

    //         }
    //     }
    //     return provience;
    // }

    // public static void bfs(int source, int[][] matrix, boolean[] vis) {
    //     Queue<Integer> q = new LinkedList<>();
    //     vis[source] = true;
    //     q.add(source);
    //     while (!q.isEmpty()) {
    //         int city = q.poll();
    //         for (int i = 0; i < matrix.length; i++) {
    //             if (matrix[city][i] == 1 && !vis[i]) {
    //                 vis[i] = true;
    //                 q.add(i);
    //             }
    //         }
    //     }
    // }

    // using dfs

    // public static void dfs(int source, int[][] connected, boolean[] vis) {
    //     //base conditon
        
    //     vis[source] = true;

    //     for(int i=0;i<connected.length;i++){
    //         if(connected[source][i]==1 && !vis[i]){
    //             dfs(i,connected,vis);
    //         }
    //     }
    // }



    // using DSU




    public static int find(int node, int[] par) {
        if (par[node] == node)
            return node;
        return par[node] = find(par[node], par);
    }

    public static void union(int u, int v, int[] par, int[] rank) {
        int ul_pu = find(u, par);
        int ul_pv = find(v, par);

        if (ul_pu == ul_pv)
            return;
        if (rank[ul_pu] > rank[ul_pv]) {
            par[ul_pv] = ul_pu;
        } else if (rank[ul_pu] < rank[ul_pv]) {
            par[ul_pu] = ul_pv;
        } else {
            par[ul_pu] = ul_pv;
            rank[ul_pv]++;
        }

    }

    public int findCircleNum(int[][] isConnected){
        int n=isConnected.length;
        int par[]=new  int[n];
        int rank[]=new  int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
         for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1)
                    union(i, j, par, rank);
            }
        }
        int provience=0;
        for(int i=0;i<n;i++){
            if(par[i]==i) provience++;
        }
        return provience;
    }
}