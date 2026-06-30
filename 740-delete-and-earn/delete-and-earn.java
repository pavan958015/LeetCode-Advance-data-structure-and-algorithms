class Solution {
    int max;
    int[] point;
    public int deleteAndEarn(int[] nums) {
        max=0;
        for(int num:nums){
            if(num>max) max=num; 
        }

        point=new int[max+1];
        for(int x:nums){
            point[x]+=x;
        }

        int dp[]=new int[max+1];
        Arrays.fill(dp,-1);
        return solve(0,dp);
    }
    private int solve(int i,int dp[]){
        if(i>max) return 0;

        if(dp[i]!=-1) return dp[i];

        // skip
        int skip=solve(i+1,dp);
        // take
        int take=point[i]+solve(i+2,dp);

        return dp[i]=Math.max(take,skip);
    }
}