class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1,str2);
    }
    // for printing;
    public static String print(int l1,int l2,String s1,String s2,int[][] dp){
        int i=l1; int j=l2;
        StringBuilder str=new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                str=str.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                str=str.append(s1.charAt(i-1));
                i--;
            }else{
                str=str.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0){ str=str.append(s1.charAt(i-1)); i--;}
        while(j>0){ str=str.append(s2.charAt(j-1)); j--;}

        return str.reverse().toString();
    }
    // find lcs
    public static String lcs(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        solve(m,n,s1,s2,dp);
        return print(m,n,s1,s2,dp);
    }
    public static void  solve(int m,int n,String s1,String s2,int[][] dp){
        // using Tabulation

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
}