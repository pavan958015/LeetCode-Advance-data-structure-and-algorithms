class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n+1][n+1];

        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int j=n-2;j>=0;j--){
            for(int i=0;i<=j;i++){
                dp[j][i]=triangle.get(j).get(i)+Math.min(dp[j+1][i],dp[j+1][i+1]);
            }
        }
        return dp[0][0];
    }
}