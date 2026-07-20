class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        Integer[][]dp=new Integer[n+1][m+1];

        return solve(0,0,n,m,nums1,nums2,dp);
    }
    private int solve(int i,int j,int n,int m,int[] nums1,int[]nums2,Integer[][] dp){
        if(i>=n || j>=m) return 0; 

        if(dp[i][j]!=null) return dp[i][j];

        int match=0;
        if(nums1[i]==nums2[j]){
            match=1+solve(i+1,j+1,n,m,nums1,nums2,dp);
        }
        int not=Math.max(solve(i+1,j,n,m,nums1,nums2,dp),solve(i,j+1,n,m,nums1,nums2,dp));

        return dp[i][j]=Math.max(match,not);
    }
}