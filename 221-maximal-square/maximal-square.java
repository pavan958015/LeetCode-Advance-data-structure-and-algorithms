class Solution {
    public int maximalSquare(char[][] matrix) {
      
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int left = dp[i][j - 1];
                        int up = dp[i - 1][j];
                        int up_left = dp[i - 1][j - 1];

                        dp[i][j] = 1 + Math.min(left, Math.min(up, up_left));
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return max * max;
    }
}