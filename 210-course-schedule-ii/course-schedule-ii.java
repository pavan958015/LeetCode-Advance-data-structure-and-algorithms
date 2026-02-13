class Solution {
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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int node[] : prerequisites) {
            int u = node[0];
            int v = node[1];
            adj.get(v).add(u);
        }

        List<Integer> ans=Topological_Sort(numCourses,adj);
        int nums[]=new int[ans.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=ans.get(i);
        }
        if(ans.size()!=numCourses){
            return new int[]{};
        }
        return nums;
    }
    
}