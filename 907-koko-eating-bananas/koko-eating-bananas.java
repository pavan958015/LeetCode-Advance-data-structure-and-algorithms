class Solution {
    private int findMax(int nums[]){
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(max<num){
                max=num;
            }
        }
        return max;
    }
    private boolean findValidity(int[] nums,int h,int perHour){
        long totalHour=0;
        for(int num:nums){
            totalHour += (num + perHour - 1) / perHour;
        }
        return totalHour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=findMax(piles);

        // TLE

        // for(int i=1;i<=max;i++){
        //     int totalHours=findValidity(piles,i);
        //     if(totalHours<=h) return i;
        // }

        int low=1; int high=max;
        int ans=high;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(findValidity(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

}