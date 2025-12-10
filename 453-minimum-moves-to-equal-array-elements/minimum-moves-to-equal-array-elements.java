class Solution {
    public int minMoves(int[] nums) {
        int res=0;
        int min=nums[0];

        // find min 
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        // find diff between min and each digit of nums;
        for(int i=0;i<nums.length;i++){
            res+=nums[i]-min;
        }
        return res;
    }
}