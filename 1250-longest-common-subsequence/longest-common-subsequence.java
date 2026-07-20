class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length(); 

        Integer dp[][]=new Integer[n][m];

        return solve(0,0,n,m,text1,text2,dp);
    }
    private int solve(int idx1,int idx2,int n,int m,String s,String t,Integer[][] dp){
        if(idx1>=n || idx2>=m) return 0;

        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];

        int match=0;
        if(s.charAt(idx1)==t.charAt(idx2)){
            match=1+solve(idx1+1,idx2+1,n,m,s,t,dp);
        }
        int notMatch=Math.max(solve(idx1+1,idx2,n,m,s,t,dp),solve(idx1,idx2+1,n,m,s,t,dp));

        return dp[idx1][idx2]=Math.max(match,notMatch);
    }
}