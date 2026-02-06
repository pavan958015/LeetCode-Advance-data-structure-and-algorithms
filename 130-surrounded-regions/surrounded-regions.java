class Solution {

    public static void dfs(int i, int j, char[][] board, boolean[][] vis, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || board[i][j] != 'O')
            return;

        vis[i][j] = true;
        board[i][j] = 'T';

        dfs(i+1,j,board,vis,n,m);
        dfs(i-1,j,board,vis,n,m);
        dfs(i,j+1,board,vis,n,m);
        dfs(i,j-1,board,vis,n,m);
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // boundary
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(i,0,board,vis,n,m);
            if(board[i][m-1]=='O') dfs(i,m-1,board,vis,n,m);
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O') dfs(0,j,board,vis,n,m);
            if(board[n-1][j]=='O') dfs(n-1,j,board,vis,n,m);
        }

        // replace in X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='T') board[i][j]='O';
            }
        }
    }
}
