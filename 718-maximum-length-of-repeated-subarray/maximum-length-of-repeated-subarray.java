class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int ans=0;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,solve(i,j,nums1,nums2,dp));
            }
        }
        return ans;
    }
    public static int solve(int m, int n, int[] nums1, int[] nums2, int[][] dp) {
        // base 
        if(m==nums1.length) return 0;
        if(n==nums2.length) return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(nums1[m] == nums2[n]){
            dp[m][n] = 1 + solve(m+1, n+1, nums1, nums2, dp);
            return dp[m][n];
        } else {
            dp[m][n] = 0;
        }
        return dp[m][n];
    }
}