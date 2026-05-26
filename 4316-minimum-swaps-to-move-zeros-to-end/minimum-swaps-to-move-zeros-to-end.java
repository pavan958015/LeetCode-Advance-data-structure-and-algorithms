class Solution {
    public int minimumSwaps(int[] nums) {
        int n=nums.length;
        int count=0;
        int swap=0;

        for(int num:nums)
            if(num==0) count++;

        for(int i=n-1;i>=0;i--){
            if(nums[i]>0 && count>0){
                count--;
                swap++;
            }else {
                count--;
            }
        }       
        return swap;
    }
}