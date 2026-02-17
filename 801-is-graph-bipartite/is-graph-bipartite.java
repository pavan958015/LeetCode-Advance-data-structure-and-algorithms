class Solution {
    public static boolean check(int source,int[]color,int[][] graph){
        color[source]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int x:graph[cur]){
                if(color[x]==-1){
                    color[x]=1-color[cur];
                    q.add(x);
                }
                else if(color[x]==color[cur]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!check(i,color,graph)) return false;
            }
        }
        return true;
    }
}