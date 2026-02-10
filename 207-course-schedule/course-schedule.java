class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int j[] : prerequisites) {
            int u = j[0];
            int v = j[1];
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, st, vis, path))
                    return false;
            }
        }
        return true;
    }

   public static boolean dfs(int source, List<List<Integer>> adj, Stack<Integer> st, boolean[] vis, boolean[] path) {
        vis[source] = true;
        path[source] = true;

        for (int x : adj.get(source)) {
            if (!vis[x]) {
                if (dfs(x, adj, st, vis, path))
                    return true;
            } else if (path[x]) {
                return true;
            }
        }
        path[source] = false;
        st.push(source);
        return false;
    }
}