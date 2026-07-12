class Solution {
    public int search(int[] nums, int target) {
    //     int left=0;
    //     int right=nums.length-1;

    //     while(left<=right){
    //         int mid=(right-left)+left/2;
    //         if(nums[mid]==target) return mid;
    //         else if(nums[mid]<target){
    //             left=mid+1;
    //         }else{
    //             right=mid-1;
    //         }
    //     }
    //     return -1;


        return rec(0,nums.length-1,nums,target);
    }
    public static int rec(int l,int r,int[] nums,int target){
        if(l>r){
            return -1;
        }

        int mid=l+(r-l)/2;
        if(nums[mid]==target) return mid;

        if(nums[mid]<target) return rec(mid+1,r,nums,target);
        else return rec(l,mid-1,nums,target);
    }
}