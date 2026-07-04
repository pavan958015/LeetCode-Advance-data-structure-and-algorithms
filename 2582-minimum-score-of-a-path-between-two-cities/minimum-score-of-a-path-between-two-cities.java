class Solution {
    static class Pair{
    int u;
    int v;
    int dist;
    Pair(int u,int v,int dist){
        this.u=u;
        this.v=v;
        this.dist=dist;
    }
}
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int dist=road[2];

            adj.get(u).add(new Pair(u,v,dist));
            adj.get(v).add(new Pair(v,u,dist));

        }

        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n+1];
        q.add(1);
        vis[1]=true;

        int ans=Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int node=q.poll();

            for(Pair p:adj.get(node)){
                int nei=p.v;;
                int wt=p.dist;

                ans=Math.min(ans,wt);

                if(!vis[nei]){
                    q.add(nei);
                    vis[nei]=true;
                }
            }
        }
        return ans;
    }
}