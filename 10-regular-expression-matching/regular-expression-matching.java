class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        int row = dp.length - 1;
        int col = dp[0].length - 1;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }

                else if (i == 0) {
                    if (j >= 2 && p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j-2];
                    }
                }

                else if (j == 0) {
                    dp[i][j] = false;
                }

                else {
                    char ch1 = s.charAt(i-1);
                    char ch2 = p.charAt(j-1);

                    if (ch1 == ch2 || ch2 == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }

                    else if (ch2 == '*' && j >= 2) {
                        dp[i][j] = dp[i][j-2];  // zero occurrence

                        char chpm = p.charAt(j-2);
                        if (chpm == '.' || chpm == ch1) {
                            dp[i][j] = dp[i][j] || dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[row][col];
    }
}
