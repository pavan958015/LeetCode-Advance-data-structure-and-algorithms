class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int e[] : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);

        }
        boolean vis[] = new boolean[n];
        return bfs(graph, source, destination, vis);
    }

    public static boolean bfs(List<List<Integer>> graph, int source, int destination, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        vis[source] = true;
        q.add(source);
        while (!q.isEmpty()) {
            int front = q.poll();
            if (front == destination)
                return true;
            for (int a : graph.get(front)) {
                if (!vis[a]) {
                    vis[a] = true;
                    q.add(a);
                }
            }
        }
        return false;
    }
}