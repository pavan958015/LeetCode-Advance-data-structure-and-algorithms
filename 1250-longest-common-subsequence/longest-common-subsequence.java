class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);

        return solve(n,m,text1,text2,dp);
    }
    public static int solve(int idx1,int idx2,String s1,String s2,int[][] dp){
        if(idx1<=0 || idx2<=0) return 0;

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        int pickup=0;
        if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
            pickup=1+solve(idx1-1,idx2-1,s1,s2,dp);
        }
        int notPickup=Math.max(solve(idx1-1,idx2,s1,s2,dp),solve(idx1,idx2-1,s1,s2,dp));

        return dp[idx1][idx2]=Math.max(pickup,notPickup);
    }
}