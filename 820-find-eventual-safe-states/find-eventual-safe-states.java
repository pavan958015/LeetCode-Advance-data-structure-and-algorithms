class Solution {
    public static boolean dfs(int source,int graph[][],boolean vis[],boolean path[]){
        vis[source]=true;
        path[source]=true;

        for(int i=0;i<graph[source].length;i++){
            int node=graph[source][i];
            if(!vis[node]){
                if(dfs(node,graph,vis,path)) return true;
            }
            else if(path[node]){
                return true;
            }
        }
        path[source]=false;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();

        boolean[] vis=new boolean[graph.length];
        boolean[] path=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){  
            if(!dfs(i,graph,vis,path)) ans.add(i);
        }
       
        return ans;
    }
}