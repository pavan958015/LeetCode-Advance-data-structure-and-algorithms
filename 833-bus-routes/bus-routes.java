class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // stops value of index
        Map<Integer, List<Integer>> map = new HashMap<>();

        if(source==target) return 0;
        

        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) {
                    map.put(j, new ArrayList<>());
                }
                map.get(j).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[routes.length];
        int count = 0;

        q.add(source);

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int route : map.getOrDefault(node, new ArrayList<>())) {
                    if (vis[route])
                        continue;

                    vis[route]=true;

                    for (int next : routes[route]) {
                        if (next == target)
                            return count;

                        q.add(next);

                    }

                }

            }

        }
        return -1;

    }
}