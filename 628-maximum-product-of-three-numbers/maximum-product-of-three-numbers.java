class Solution {
    public int maximumProduct(int[] nums) {
        int  first = Integer.MIN_VALUE;
        int  second = Integer.MIN_VALUE;
        int  third = Integer.MIN_VALUE;

        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {
            // for min value
            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }else if (nums[i]<min2){
                min2=nums[i];
            }

            // for max value;
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];

            } else if (nums[i] > second) {
                third = second;
                second = nums[i];

            } else if(nums[i]>third) {
                third = nums[i];
            }
        }
        int maxProduct=Math.max(first*second*third,min1*min2*first);
        return maxProduct;
    }
}