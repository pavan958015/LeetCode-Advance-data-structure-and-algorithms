class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean dp[][]=new Boolean[s1.length()+1][s2.length()+1];
        return solve(0, 0, 0, s1, s2, s3,dp);
    }

    private boolean solve(int i, int j, int k, String s1, String s2, String s3,Boolean dp[][]) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        
        if(dp[i][j]!=null) return dp[i][j];
        boolean first = false, second = false;
        if (i != s1.length()) {
            if (s3.charAt(k) == s1.charAt(i)) {
                first = solve(i + 1, j, k + 1, s1, s2, s3,dp);
            }
        }
        if (j != s2.length()) {
            if (s3.charAt(k) == s2.charAt(j)) {
                second = solve(i, j + 1, k + 1, s1, s2, s3,dp);
            }
        }

        return dp[i][j]=first || second;
    }
}