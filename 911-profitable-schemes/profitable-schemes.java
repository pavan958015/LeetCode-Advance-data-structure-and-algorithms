class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m=group.length;
        int dp[][][]=new int[m][minProfit+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<=minProfit;j++){
                Arrays.fill(dp[i][j],-1);
            }
        } 
        return solve(0,0,minProfit,0,n,group, profit,dp);   
    }
    public static int solve(int idx,int curProfit,int minProfit,int crime,int n,int[] group,int profit[],int[][][] dp){
        // base case;
        if(idx==profit.length) return curProfit>=minProfit?1:0;

        if(dp[idx][curProfit][crime]!=-1) return dp[idx][curProfit][crime];

        int notTake=solve(idx+1,curProfit,minProfit,crime,n,group,profit,dp);

        int take=0;
        if(crime+group[idx]<=n){
            take=solve(idx+1,Math.min(curProfit+profit[idx],minProfit),minProfit,crime+group[idx],n,group,profit,dp);
        }
        return dp[idx][curProfit][crime]=(take+notTake)%1000000007;
    }
}