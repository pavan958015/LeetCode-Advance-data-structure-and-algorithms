class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int opr=0;
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==k){
                nums[left]=0;
                nums[right]=0;
                opr++;
            }
            if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return opr;
    }
}