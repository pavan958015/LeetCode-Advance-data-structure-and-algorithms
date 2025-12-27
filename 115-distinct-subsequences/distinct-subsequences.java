class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n-1,m-1,s,t,dp);
    }

    // using Recursion

    // public static int solve(int i,int j,String s,String t){
    //     // base case;
    //     if(j<0) return 1;
    //     if(i<0) return 0;

    //     // recursive
    //     if(s.charAt(i)==t.charAt(j)){
    //         return solve(i-1,j-1,s,t)+solve(i-1,j,s,t);
    //     }
    //     else{
    //         return solve(i-1,j,s,t);
    //     }
    // }


    // using DP
    public static int solve(int i,int j,String s,String t,int dp[][]){
        // base case;
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        // recursive
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]= solve(i-1,j-1,s,t,dp)+solve(i-1,j,s,t,dp);
        }
        else{
            dp[i][j]= solve(i-1,j,s,t,dp);
        }
        return dp[i][j];
    }
}