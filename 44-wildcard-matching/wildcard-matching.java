class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean[n][m];
        
        return solve(n-1,m-1,s,p,dp);
    }
    // public static boolean solve(int i,int j,String s,String p){
    //     // base case 
    //     if(i<0 && j<0) return true;
    //     if(j<0 && i>=0) return false;
    //     if(i<0 && j>=0){
    //         for(int ii=0;ii<=j;ii++){
    //             if(p.charAt(ii)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     // recursion
    //     // if match
    //     if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
    //         return solve(i-1,j-1,s,p);
    //     }
    //     if(p.charAt(j)=='*'){
    //         return solve(i-1,j,s,p) || solve(i,j-1,s,p);
    //     }
    //     return false;
    // }



    // using Dp
    public static boolean solve(int i,int j,String s,String p,Boolean[][]dp){
        // base case 
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int ii=0;ii<=j;ii++){
                if(p.charAt(ii)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        // recursion
        // if match
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]= solve(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j)=='*'){
            return dp[i][j]= solve(i-1,j,s,p,dp) || solve(i,j-1,s,p,dp);
        }
        return dp[i][j]=false;
    }
}