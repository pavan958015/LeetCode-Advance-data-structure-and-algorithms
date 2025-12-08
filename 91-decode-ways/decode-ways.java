class Solution {
    // public int numDecodings(String s) {
    //     int n=s.length();
    //     int dp[]=new int[n+1];
    //     dp[0]=1;
    //     dp[1]=s.charAt(0)=='0'?0:1;

    //     for(int i=2;i<=n;i++){
    //         int one=Integer.valueOf(s.substring(i-1,i));
    //         int two=Integer.valueOf(s.substring(i-2,i));

    //         if(one>=1){
    //             dp[i]=dp[i]+dp[i-1];
    //         }
    //         if(two>=10 &&two<=26){
    //             dp[i]=dp[i]+dp[i-2];
    //         }

    //     }
    //     return dp[n];
    // }

    public int numDecodings(String s){
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(0,s,dp);
    }
    public int helper(int idx,String s,int dp[]){
        if(s.length()==idx) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ways=0;
        if(valid(s.substring(idx,idx+1))){
            ways+=helper(idx+1,s,dp);
        }
        if(idx+2<=s.length() && valid(s.substring(idx,idx+2))){
            ways+=helper(idx+2,s,dp);
        }
        return dp[idx]=ways;
    }
    public boolean valid(String s){
        if(s.length()==1) return s.charAt(0)!='0';
        int n=Integer.parseInt(s);
        return n>=10 && n<=26;
    }
}