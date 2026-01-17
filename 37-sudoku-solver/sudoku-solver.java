class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(char[][] board,int row,int cols,char c){
        for(int i=0;i<9;i++){
            if(board[i][cols]==c){
                return false;
            }
            if(board[row][i]==c){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(cols/3)+i%3]==c){
                return false;
            }
        }
        return true;   
    }
}