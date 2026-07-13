class Solution {
    private boolean checkSum(int[] nums,int divisor,int threshold){
        long sum=0;

        for(int num:nums){
            sum+=(divisor+num-1)/divisor;
        }
        return sum<=threshold;
    }
    private int max(int[] nums){
        int max=0;
        for(int num:nums){
            if(max<num) max=num;
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=max(nums);

        // TLE

        // for(int i=1;i<=max;i++){
        //     int sum=checkSum(nums,i);
        //     if(sum<=threshold) return i;
        // }

        int low=1;
        int high=max;

        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean checkSum=checkSum(nums,mid,threshold);
            if(checkSum){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}