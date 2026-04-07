class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[]=new int[10001];
        int max=0;
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            max=Math.max(max,nums[i]);
        }
        int dp[]=new int[max+1];

        dp[1]=freq[1]*1;

        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+freq[i]*i);
        }
        return dp[max];
    }
}