class Solution {
    // public int jump(int[] nums) {
    //     int count = 0;
    //     int max = 0;
    //     int currend = 0;
    //     for(int i = 0; i<nums.length-1; i++){
    //          max = Math.max(max, nums[i] + i);
    //        if(i == currend){
    //         count++;
    //         currend = max;
    //        }
    //     }
    //     return count;
    // }

    // public int jump(int[] nums){
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return solve(0,n-1,nums,dp);
    // }
    // public static int solve(int idx,int n,int[] nums,int dp[]){
    //     if(idx==n) return 1;
    //     if(idx>n) return 0;

    //     if(dp[idx]!=-1) return dp[idx];

    //     int jump=idx+nums[idx];
    //     int can=Integer.MAX_VALUE;
    //     int go=Integer.MAX_VALUE;
    //     for(int i=1;i<=jump;i++){
    //         can=1+solve(idx+i,n,nums,dp);
    //         go=Math.min(go,can);
    //     }
    //     return dp[idx]=go;
    // }

    public int jump(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    dp[i + j] = Math.min(dp[i + j], 1 + dp[i]);
                }
            }
        }
        return dp[n - 1];
    }
}