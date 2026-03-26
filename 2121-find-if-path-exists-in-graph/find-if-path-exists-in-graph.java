class Solution {
    public static boolean bfs(int source,int destination,List<List<Integer>> adj,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        vis[source]=true;

        while(!q.isEmpty()){
            int cur=q.poll();

            if(cur==destination) return true;

            for(int node:adj.get(cur)){
                if(!vis[node]){
                    vis[node]=true;
                    q.add(node);
                }
            }
        }
        return false;
    }
    public static boolean dfs(int source,int destination,List<List<Integer>> adj,boolean[] vis){
        vis[source]=true;
        if(source==destination) return true;

        for(int x:adj.get(source)){
            if(!vis[x]){
                if(x==destination) return true;
                if(dfs(x,destination,adj,vis))
                    return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        boolean vis[]=new boolean[n];
        // return dfs(source,destination,adj,vis);
        return bfs(source,destination,adj,vis);

    }
}