class Solution {
    // public int maxSubArray(int[] nums) {
    //     int max=0;
    //     int sum=0;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i;j<nums.length;j++){
    //             sum+=nums[j];
    //             max=Math.max(sum,max);
    //         }
    //         sum=0;
    //     }
    //     return max;
    // }


        // using Kanade ALgorithm
    public int maxSubArray(int [] nums){
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

              if(sum>max){
                max=sum;
              }

             if(sum<0) {
                sum=0;
             }
        }
        return max;
    }
}