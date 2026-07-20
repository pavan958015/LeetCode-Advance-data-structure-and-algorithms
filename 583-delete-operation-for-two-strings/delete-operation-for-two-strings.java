class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        Integer[][] dp=new Integer[n][m];

        return solve(0,0,n,m,word1,word2,dp);
    }
    private int solve(int i,int j,int n,int m,String s,String t,Integer[][] dp){
        // I make mistake for this base case 
        // if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(i>=n) return m-j;
        if(j>=m) return n-i;

        if(dp[i][j]!=null) return dp[i][j];

        int same=Integer.MAX_VALUE;
        if(s.charAt(i)==t.charAt(j))
            same=solve(i+1,j+1,n,m,s,t,dp);
        int notSame=Math.min(1+solve(i+1,j,n,m,s,t,dp),1+solve(i,j+1,n,m,s,t,dp));

        return dp[i][j]=Math.min(same,notSame);
    }
}