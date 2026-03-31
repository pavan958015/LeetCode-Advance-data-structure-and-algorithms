class Solution {
    public int subarraySum(int[] nums, int k) {
        return solve(0,k,nums);
    }
    public static int solve(int start,int k,int[] nums){
        if(start==nums.length) return 0;

        int count=0;
        int sum=0;

        for(int i=start;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                count++;
            }
        }
        return count+solve(start+1,k,nums);
    }
}