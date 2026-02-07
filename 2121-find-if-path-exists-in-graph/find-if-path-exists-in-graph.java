class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        } 
        boolean vis[]=new boolean[n];
        return usingDFS(adj,source,destination,vis);
    }
    // public static boolean usingBFS(List<List<Integer>> adj, int source, int destination,boolean[] vis){
    //     if(source==destination) return true;

    //     Queue<Integer> q=new LinkedList<>();
    //     vis[source]=true;
    //     q.add(source);
    //     while(!q.isEmpty()){
    //         int node =q.poll();
    //         for(int x:adj.get(source)){
    //             if(x==destination) return true;
    //             if(!vis[x]){
    //                 q.add(x);
    //                 vis[x]=true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean usingDFS(List<List<Integer>> adj,int source,int destination,boolean[] vis){
        if(source==destination) return true;
        vis[source]=true;
        for(int node:adj.get(source)){
            if(node==destination) return true;
            if(!vis[node]){
                if(usingDFS(adj,node,destination,vis)) return true;
            }
        }
        return false;
    }
}