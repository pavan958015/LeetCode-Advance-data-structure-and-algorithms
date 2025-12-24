class Solution {
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m=text1.length();
    //     int n=text2.length();
    //     int dp[][] = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++) {
    //         for (int j = 0; j <= n; j++) {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     // return solve(m,n,text1,text2,dp);
    //     return solve(m,n,text1,text2);
    // }

    // Using Recursion

    // public static int solve(int m, int n, String str1, String str2) {
    //     // BASE;
    //     if (m == 0 || n == 0) {
    //         return 0;
    //     }

    //     // TWO OPTION
    //     // IF MATCHED
    //     if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
    //         return 1 + solve(m - 1, n - 1, str1, str2);
    //     } else {
    //         // NOT MATCH
    //         return Math.max(0 + solve(m - 1, n, str1, str2), 
    //                         0 + solve(m, n - 1, str1, str2));
    //     }
    // }


    // dp approach
    // public static int solve(int m, int n, String s, String t, int[][] dp) {
    //     // base 
    //     if(m==0 || n==0){
    //         return 0;
    //     }
    //     if(dp[m][n] != -1){
    //         return dp[m][n];
    //     }
    //     if(s.charAt(m-1) == t.charAt(n-1)){
    //         dp[m][n] = 1 + solve(m-1, n-1, s, t, dp);
    //         return dp[m][n];
    //     } else {
    //         dp[m][n] = Math.max(0 + solve(m-1, n, s, t, dp), 0 + solve(m, n-1, s, t, dp));
    //         return dp[m][n];
    //     }
    // }


    // tabulation
    // public static int solve(int m,int n,String s1,String s2){
    //     int tab[][]=new int[m+1][n+1];

    //     for(int i=0;i<=m;i++){
    //         for(int j=0;j<=n;j++){
    //             if(i==0 || j==0){
    //                 tab[i][j]=0;
    //             }
    //              else if(s1.charAt(i-1)==s2.charAt(j-1)){
    //                 tab[i][j]=tab[i-1][j-1]+1;
    //             }else{
    //                 tab[i][j]=Math.max(tab[i-1][j],tab[i][j-1]);
    //             }
    //         }
    //     }
    //     return tab[m][n];
    // }



    // Space Optimization

    public int longestCommonSubsequence(String text1, String text2){
        int n=text1.length(); int m=text2.length();
        
        int prev[]=new int[m+1];
        int cur[]=new int[m+1];

        for(int j=0;j<=m;j++){
            prev[j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cur[j]=1+prev[j-1];
                }else{
                    cur[j]=Math.max(prev[j],cur[j-1]);
                }
            }
            // swap
            int[] temp = prev;
            prev = cur;
            cur = temp;

        }
    return prev[m];

    }

}