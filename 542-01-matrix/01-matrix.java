class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int ans[][]=new int[n][m];

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                }
            }
        }   
        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};

        while(!q.isEmpty()){
            int[] node=q.poll();
            int x=node[0];
            int y=node[1];

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];


                if(nx>=0 && ny>=0 && nx<n && ny<m && ans[nx][ny]==-1){
                    ans[nx][ny]=ans[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return ans;
    }
}