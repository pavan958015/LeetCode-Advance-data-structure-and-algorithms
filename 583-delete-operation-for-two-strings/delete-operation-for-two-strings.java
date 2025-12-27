class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
            int dp[][] = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                   dp[i][j] = -1;
               }
            }
        return n+m-2*solve(m,n,word1,word2,dp);
    }

    //dp approach
    public static int solve(int m, int n, String s, String t, int[][] dp) {
        // base 
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s.charAt(m-1) == t.charAt(n-1)){
            dp[m][n] = 1 + solve(m-1, n-1, s, t, dp);
            return dp[m][n];
        } else {
            dp[m][n] = Math.max(0 + solve(m-1, n, s, t, dp), 0 + solve(m, n-1, s, t, dp));
            return dp[m][n];
        }
    }


//     abcd-------------> anc
//          -              -
//           -            -
// b d(2 opr) -          - add n (1 opr)
//             -        -   
//              -      -
//                a c


//         delete 2
//         add 1
//         ans 3

//         So I can find both string logest common sequence 
//         which has both stirng 
//        deletetion  Opr in String 1-  n-lcs(s);
//        insertion   opr in Stirng 2-  m-lcs(s);
//         total is opr1+opr2
//         n+m-2*lcs(s1,s2);

}