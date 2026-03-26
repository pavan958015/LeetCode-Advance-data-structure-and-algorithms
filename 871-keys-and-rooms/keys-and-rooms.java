class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        dfs(0,rooms,vis);
        for(int i=0;i<n;i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
    public static void dfs(int node,List<List<Integer>> adj,boolean vis[]){
        vis[node]=true;

        for(int x:adj.get(node)){
            if(!vis[x]){
                dfs(x,adj,vis);
            }
        }
    } 
}