class Solution {
    public int majorityElement(int[] nums) {

        // using N^2;

        // int n=nums.length;
        // int maxcount=0;
        // int ele=0;

        // for(int i=0;i<n;i++){
        //     int count=0;
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //         if(count>maxcount){
        //             ele=nums[i];
        //             maxcount=count;
        //         }
        //     }
        // }
        // return ele;


        int n=nums.length;
        int count=0;
        int ele=0;
        for(int i=0;i<n;i++){
            if(count==0){
                ele=nums[i];
            }
            if(ele==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
}