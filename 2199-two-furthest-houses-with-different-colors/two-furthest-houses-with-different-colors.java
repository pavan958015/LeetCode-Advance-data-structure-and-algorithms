class Solution {
    public int maxDistance(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n;j++){
                if(nums[i]!=nums[j]){
                    ans=Math.max(Math.abs(i-j),ans);
                }
            }
        }
        return ans;
    }
}