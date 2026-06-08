class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int left=0;               // for small value compare then pivot
        int right=n-1;  // for large value compare then pivot;
        int i=0,j=n-1; 
        int ans[]=new int[n];
        while(i<n){
            if(nums[i]<pivot){
                ans[left++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[right--]=nums[j];
            }
            i++;
            j--;
        }

        // fill pivot in middle between left an right;
        while(left<=right){
            ans[left++]=pivot;
        }
        return ans;
    }
}
