class Solution {
    static class Triple{
        int dist;
        int second;
        int third;
        Triple(int d,int s,int t){
            dist=d;
            second=s;
            third=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        return shortestPath(grid,new int[]{0,0},new int[]{n-1,n-1});
    }
    private int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1)
            return -1;
        if(source[0]==destination[0] && source[1]==destination[1]) return 1;
        Queue<Triple> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[source[0]][source[1]]=1;
        q.add(new Triple(1,source[0],source[1]));
        
        
        
        int[] dx = {-1,-1,-1, 0,0, 1,1,1};
        int[] dy = {-1, 0, 1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            Triple cur=q.poll();
            int dis=cur.dist;
            int r=cur.second;
            int c=cur.third;
            for(int i=0;i<8;i++){
                    int newR=r+dx[i];
                    int newC=c+dy[i];
                    
                    if(newR>=0 && newR<n && newC>=0 && newC<m && grid[newR][newC]==0
                               && dis+1<dist[newR][newC]){
                                   dist[newR][newC]=cur.dist+1;
                        if(newR==destination[0] && newC==destination[1]){
                            return cur.dist+1;
                        }
                        q.add(new Triple(1+cur.dist,newR,newC));
                    }
                    
                    
                }
            }
            return -1;
        }
}