class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int min=nums[i];
            int max=nums[i];
            for(int j=i;j<n;j++){
               max=Math.max(max,nums[j]);
               min=Math.min(min,nums[j]);
                ans+=max-min;
            }
        }
        return ans;
    }
}