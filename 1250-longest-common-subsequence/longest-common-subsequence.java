class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();


        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,n,m,text1,text2,dp);
    }
    private int solve(int idx1,int idx2,int n,int m,String t,String s,int[][] dp){
        if(idx1>=n || idx2>=m) return 0;

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        int pick=0;
        if(t.charAt(idx1)==s.charAt(idx2)){
            pick=1+solve(idx1+1,idx2+1,n,m,t,s,dp);
        }
        int notPick=Math.max(solve(idx1+1,idx2,n,m,t,s,dp),solve(idx1,idx2+1,n,m,t,s,dp));
        return dp[idx1][idx2]=Math.max(pick,notPick);
    }
}