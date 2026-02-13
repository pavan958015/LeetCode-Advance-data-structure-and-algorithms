class Solution {
    static class Pair {
        int i;
        int j;
        int time;

        Pair(int i, int j,int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int ans=0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair cur=q.poll();
            int x=cur.i;
            int y=cur.j;
            int time=cur.time;

            ans=Math.max(ans,time);

            for(int k=0;k<4;k++){
                int nx=x+dx[k];
                int ny=y+dy[k];

                if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                    fresh--;
                    grid[nx][ny]=2;

                    q.add(new Pair(nx, ny, time + 1));
                }
            }
        }
        return fresh==0?ans:-1;
    }

}