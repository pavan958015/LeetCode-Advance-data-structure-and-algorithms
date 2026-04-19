class Solution {
    // public static boolean check(int start,int v,int graph[][],int color[]){
    //     color[start]=0;

    //     Queue<Integer> q=new LinkedList<>();
    //     q.add(start);
    //     while(!q.isEmpty()){
    //         int cur=q.poll();

    //         for(int x:graph[cur]){
    //             if(color[x]==-1){
    //                 q.add(x);
    //                 color[x]=1-color[cur];
    //             }else if(color[x]==color[cur]) return false;
    //         }
    //     }
    //     return true;

    // }

    public static boolean DFS(int start,int curColor,int graph[][],int color[]){
        color[start]=curColor;

        for(int x:graph[start]){
            if(color[x]==-1){
                if(!DFS(x,1-curColor,graph,color)){
                     return false;
                }

            }else if(color[x]==curColor) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int color[]=new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++){
            if(color[i]==-1)
                // if(!check(i,v,graph,color)) return false;
                if(!DFS(i,0,graph,color)) return false;

        }
        return true;
    }
}