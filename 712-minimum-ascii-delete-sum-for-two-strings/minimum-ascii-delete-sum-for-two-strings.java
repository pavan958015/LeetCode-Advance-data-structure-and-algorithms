class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,s1,s2,dp);
    }
    /*
    public static int solve(int i,int j,String s1,String s2){
        // base case;
        if(i==s1.length() && j==s2.length()) return 0;

        if(i==s1.length()){
            int ans=0;
            for(int k=j;k<s2.length();k++){
                ans+=s2.charAt(k);
            }
            return ans;
        }

        if(j==s2.length()){
            int ans=0;
            for(int k=i;k<s1.length();k++){
                ans+=s1.charAt(k);
            }
            return ans;
        }
        



        // recursion
        if(s1.charAt(i)==s2.charAt(j)){
            return solve(i+1,j+1,s1,s2);
        }
        // not matches
        return Math.min(s1.charAt(i)+solve(i+1,j,s1,s2),
                        s2.charAt(j)+solve(i,j+1,s1,s2));
    }
    */


    public static int solve(int i,int j,String s1,String s2,int[][]dp){
        // base case;
        if(i==s1.length() && j==s2.length()) return 0;

        if(i==s1.length()){
            int ans=0;
            for(int k=j;k<s2.length();k++){
                ans+=s2.charAt(k);
            }
            return dp[i][j]=ans;
        }

        if(j==s2.length()){
            int ans=0;
            for(int k=i;k<s1.length();k++){
                ans+=s1.charAt(k);
            }
            return dp[i][j]=ans;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];


        // recursion
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solve(i+1,j+1,s1,s2,dp);
        }
        // not matches
        return dp[i][j]= Math.min(s1.charAt(i)+solve(i+1,j,s1,s2,dp),
                        s2.charAt(j)+solve(i,j+1,s1,s2,dp));
    }
}