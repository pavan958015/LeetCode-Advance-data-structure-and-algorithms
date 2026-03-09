class NumMatrix {
    int preCompute[][];

    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        preCompute= new int[n][m];

        preCompute[0][0]=matrix[0][0];

        for (int i = 1; i < n; i++) {
            preCompute[i][0] = matrix[i][0] + preCompute[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            preCompute[0][j] = matrix[0][j] + preCompute[0][j-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                preCompute[i][j] = matrix[i][j] + preCompute[i - 1][j] + preCompute[i][j - 1]
                        - preCompute[i - 1][j - 1];
            }
        }
    }

    // Brute Force O(n^2);

    // public int sumRegion(int row1, int col1, int row2, int col2) {
    //     int sum=0;
    //     for(int i=row1;i<=row2;i++){
    //         for(int j=col1;j<=col2;j++){
    //             sum+=matrix[i][j];
    //         }
    //     }
    //     return sum;
    // }

    public int sumRegion(int row1, int col1, int row2, int col2) {
       
        
        int up=(row1>0)?preCompute[row1-1][col2]:0;
        int left=(col1>0)?preCompute[row2][col1-1]:0;
        int corner=(row1>0 && col1>0)?preCompute[row1-1][col1-1]:0;
        int ans=preCompute[row2][col2]-up-left+corner;
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */