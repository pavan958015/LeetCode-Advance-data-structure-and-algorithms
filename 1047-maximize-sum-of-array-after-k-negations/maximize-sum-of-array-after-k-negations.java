class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && k>0){
                nums[i]*=-1;
                k--;
            }
        }
        Arrays.sort(nums);
        if(k%2==1){
            nums[0]*=-1;
        }
        int total=0;
        for(int n:nums){
            total+=n;
        }
        return total;
    }
}
/*
[4 2 3] k=1
sort
[2 3 4] k=1 [-2 3 4] max=5


[3 -1 0 2] k=3
sort
[-1 0 2 3] k=3  [1,0,0,2 3] max=6  if zero then k-- for multiple


[2 -3 -1 5 -4] k=2
sort
[-4 -3 -1 2 5] k=2  [4 3 -1 2 5] max=13


[-2,9,9,8,4]  k=5; ans 32
*/
