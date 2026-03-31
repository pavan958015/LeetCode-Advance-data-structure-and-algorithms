class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left=0;
        int right=n-1;
        int operation=0;
        while(left<right){
            if(nums[left]+nums[right]==k){
                nums[left++]=0;
                nums[right--]=0;
                operation++;
            }
            else if(nums[left]+nums[right]<k){
                left++;
            }else{
                right--;
            }
        }
        return operation;
    }
}