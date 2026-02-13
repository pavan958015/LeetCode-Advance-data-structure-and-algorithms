class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int node[] : prerequisites) {
            int u = node[0];
            int v = node[1];
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        // for (int i = 0; i < numCourses; i++) {
        //     if (!vis[i]) {
        //         if (dfs(i, adj, st, vis, path))
        //             return false;
        //     }
        // }
        List<Integer> ans= Topological_Sort(numCourses,adj);

        if(ans.size()!=numCourses){
            return false;
        }
        return true;
    }

//    public static boolean dfs(int source, List<List<Integer>> adj, Stack<Integer> st, boolean[] vis, boolean[] path) {
//         vis[source] = true;
//         path[source] = true;

//         for (int x : adj.get(source)) {
//             if (!vis[x]) {
//                 if (dfs(x, adj, st, vis, path))
//                     return true;
//             } else if (path[x]) {
//                 return true;
//             }
//         }
//         path[source] = false;
//         st.push(source);
//         return false;
//     }
public static List<Integer> Topological_Sort(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();

        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            for (int x : adj.get(i)) {
                indegree[x]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for (int x : adj.get(cur)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }

        return ans;
    }



}