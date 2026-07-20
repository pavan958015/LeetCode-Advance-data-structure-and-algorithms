class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        Integer[][] dp=new Integer[n][m];

        return solve(0,0,n,m,s1,s2,dp);   
    }
    private int solve(int i,int j,int n, int m,String s,String t,Integer[][] dp){
        if(i>=n){
            int sum=0;
            for(int x=j;x<m;x++){
                sum+=t.charAt(x);
            }
            return sum;
        }
        if(j>=m){
            int sum=0;
            for(int x=i;x<n;x++){
                sum+=s.charAt(x);
            }
            return sum;
        }

        if(dp[i][j]!=null) return dp[i][j];

        int same=Integer.MAX_VALUE;
        if(s.charAt(i)==t.charAt(j)){
            same=solve(i+1,j+1,n,m,s,t,dp);
        }

        int notSame=Math.min(s.charAt(i)+solve(i+1,j,n,m,s,t,dp),t.charAt(j)+solve(i,j+1,n,m,s,t,dp));
        return dp[i][j]=Math.min(same,notSame);
    }
}