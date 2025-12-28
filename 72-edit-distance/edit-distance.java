class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n-1,m-1,word1,word2,dp);
    }
    // public static int solve(int i,int j,String s1,String s2){
    //     // base case;
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;

    //     // recursive
    //     // if match nothing to do 
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return 0+solve(i-1,j-1,s1,s2);
    //     }
    //     // no match

    //     // insert hypothetically
    //     return Math.min(1+solve(i,j-1,s1,s2),Math.min(1+solve(i-1,j,s1,s2),
    //                                                   1+solve(i-1,j-1,s1,s2)));
    // }

    // using DP;
    public static int solve(int i,int j,String s1,String s2,int[][]dp){
        // base case;
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        // recursive
        // if match nothing to do 
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 0+solve(i-1,j-1,s1,s2,dp);
        }
        // no match
        else{
        // insert 
        int insert=1+solve(i,j-1,s1,s2,dp);
        int delete=1+solve(i-1,j,s1,s2,dp);
        int replace=1+solve(i-1,j-1,s1,s2,dp);

        return dp[i][j]= Math.min(insert,Math.min(delete,replace));
        }
    }
}