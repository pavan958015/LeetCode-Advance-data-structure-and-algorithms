class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }   
        return solve(s,0,s.length()-1,dp);
    }
    // public static int solve(String s,int i,int j){
    //     if(i==j) return 1;
    //     if(i>j) return 0;

    //     // match
    //     int match=0;
    //     int noMatch=0;
    //     if(s.charAt(i)==s.charAt(j)){
    //         match= 2+solve(s,i+1,j-1);
    //     }else{
    //         noMatch= Math.max(solve(s,i+1,j),solve(s,i,j-1));
    //     }
    //     return match+noMatch;
    // }

    // using DP
     public static int solve(String s, int i, int j, int dp[][]) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // match
        int match = 0;
        int noMatch = 0;
        if (s.charAt(i) == s.charAt(j)) {
            match = 2 + solve(s, i + 1, j - 1, dp);
        } else {
            noMatch = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
        }
        return dp[i][j] = match + noMatch;
    }

}