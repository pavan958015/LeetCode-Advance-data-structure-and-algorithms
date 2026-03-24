class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int dp[][]=new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                ans=Math.max(ans,solve(i,j,n,m,nums1,nums2,dp));
            }
        }
        return ans;
    }
    public static int solve(int i,int j,int n,int m,int[] nums1,int[] nums2,int[][] dp){
        if(i==0 || j==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(nums1[i-1]==nums2[j-1]){
            dp[i][j]=1+solve(i-1,j-1,n,m,nums1,nums2,dp);
        }else{
            dp[i][j]=0;
        }
        return dp[i][j];
    }
}