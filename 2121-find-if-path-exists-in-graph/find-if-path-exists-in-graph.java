class Solution {
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
        return dfs(source,destination,adj,vis);
    }
}