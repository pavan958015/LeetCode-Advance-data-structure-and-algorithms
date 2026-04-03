class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int leftProduct=1;
        int rightProduct=1;

        int ans=nums[0];

        for(int i=0;i<n;i++){

            // if any case product become zero
            leftProduct=leftProduct==0?1:leftProduct;
            rightProduct=rightProduct==0?1:rightProduct;

            leftProduct*=nums[i];
            rightProduct*=nums[n-1-i];

            ans=Math.max(leftProduct,Math.max(ans,rightProduct));
        }
        return ans;
    }
}