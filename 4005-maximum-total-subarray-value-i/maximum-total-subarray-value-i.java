class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;

        for(int n:nums){
            minVal=Math.min(minVal,n);
            maxVal=Math.max(maxVal,n);
        }

        long bestAnswer=maxVal-minVal;
        return bestAnswer*k;
    }
}