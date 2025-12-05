class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        // make prefix sum array
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int total=prefix[prefix.length-1];

        for(int i=0;i<nums.length-1;i++){
            int left=nums[i];
            int right=total-nums[i];
            if((left-right)%2==0){
                count++;
            }
        }
        return count;
    }
}