class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provience=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                provience++;
                bfs(i,isConnected,vis);
            }
        }
        return provience;
    }
    	public static void bfs(int source,int[][] matrix,boolean[] vis){
			Queue<Integer> q=new LinkedList<>();
			vis[source]=true;
			q.add(source);
			while(!q.isEmpty()){
				int city=q.poll();
				for(int i=0;i<matrix.length;i++){
					if(matrix[city][i]==1 && !vis[i]){
						vis[i]=true;
						q.add(i);
					}
				}
			}
	}

}