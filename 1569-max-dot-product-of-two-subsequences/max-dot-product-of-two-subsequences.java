class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }

        }
        return solve(0,0,nums1,nums2,dp);
    }
    // public static int solve(int i,int j,int[] arr1,int[]arr2){
    //     if(i==arr1.length){
    //         if(j==0) return Integer.MIN_VALUE;
    //         else return 0;
    //     }
    //     if(j==arr2.length) return 0;

    //     // not take;
    //     int skip=solve(i+1,j,arr1,arr2);
    //     // take;
    //     int take=Integer.MIN_VALUE;
    //     for(int k=j;k<arr2.length;k++){
    //         take=Math.max(take,arr1[i]*arr2[k]+solve(i+1,k+1,arr1,arr2));
    //     }
    //     return Math.max(take,skip);
    // }



    // using DP

     public static int solve(int i,int j,int[] arr1,int[]arr2,int[][]dp){
        if(i==arr1.length){
            if(j==0) return Integer.MIN_VALUE;
            else return 0;
        }
        if(j==arr2.length) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        // not take;
        int skip=solve(i+1,j,arr1,arr2,dp);
        // take;
        int take=Integer.MIN_VALUE;
        for(int k=j;k<arr2.length;k++){
            take=Math.max(take,arr1[i]*arr2[k]+solve(i+1,k+1,arr1,arr2,dp));
        }
        return dp[i][j]=Math.max(take,skip);
    }
}