class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        Integer[][] dp=new Integer[n][m];

        return solve(0,0,n,m,word1,word2,dp);
    }
    public static int solve(int i,int j,int n ,int m,String s,String t,Integer[][] dp){
        if(i==n) return m-j;
        if(j==m) return n-i;

        if(dp[i][j]!=null) return dp[i][j];

        // match
        if(s.charAt(i)==t.charAt(j)){
            return solve(i+1,j+1,n,m,s,t,dp);
        }
        // insert
        int insert=1+solve(i,j+1,n,m,s,t,dp);
        // delete
        int delete=1+solve(i+1,j,n,m,s,t,dp);
        // replace
        int replace=1+solve(i+1,j+1,n,m,s,t,dp);

        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}