class Solution {
    public boolean check(int[] nums) {
        // we know that we can rotate one 
        // so if more then one conditions are true then it will false;

        int n=nums.length;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%n]) count++;
        }
        return count<=1;
    }
}