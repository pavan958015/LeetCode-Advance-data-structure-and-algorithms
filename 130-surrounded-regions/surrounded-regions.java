class Solution {
    public static void dfs(int i,int j,int n,int m,char[][] board,boolean vis[][]){
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!='O' || vis[i][j]) return;

        vis[i][j]=true;
        board[i][j]='T';

        dfs(i+1,j,n,m,board,vis);
        dfs(i-1,j,n,m,board,vis);
        dfs(i,j+1,n,m,board,vis);
        dfs(i,j-1,n,m,board,vis);

    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        boolean vis[][]=new boolean[n][m];
        // for boundary
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(i,0,n,m,board,vis);
            if(board[i][m-1]=='O') dfs(i,m-1,n,m,board,vis);
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O') dfs(0,j,n,m,board,vis);
            if(board[n-1][j]=='O') dfs(n-1,j,n,m,board,vis);
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='T') board[i][j]='O';
            }
        }
    }
}