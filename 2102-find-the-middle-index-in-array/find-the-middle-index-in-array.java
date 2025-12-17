class Solution {
    public int findMiddleIndex(int[] nums) {
        // total sum
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        // cur sum
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            if(curSum==sum-curSum-nums[i]){
                return i;
            }
            curSum+=nums[i];
        }
    return -1;
    }

}