class Solution {
    static class Edge {
        int to, time;
        Edge(int t, int ti) {
            to = t;
            time = ti;
        }
    }
     static class State implements Comparable<State> {
        int cost, time, node;
        State(int c, int t, int n) {
            cost = c;
            time = t;
            node = n;
        }
        public int compareTo(State o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        List<List<Edge>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(new Edge(e[1], e[2]));
            adj.get(e[1]).add(new Edge(e[0], e[2]));
        }

        int dp[][]=new int[n][maxTime+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq=new PriorityQueue<>();
        pq.add(new State(passingFees[0],0,0));

        while(!pq.isEmpty()){
            State cur=pq.poll();

            if(cur.node==n-1) return cur.cost;

            for(Edge e:adj.get(cur.node)){
                int newTime=cur.time+e.time;
                if(newTime>maxTime) continue;

                int newCost=cur.cost+passingFees[e.to];
                if(newCost<dp[e.to][newTime]){
                    dp[e.to][newTime]=newCost;
                    pq.add(new State(newCost,newTime,e.to));
                }
            }
        }
        return -1;
    }
}