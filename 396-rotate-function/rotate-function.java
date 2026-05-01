class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;
        
        // Calculate the sum of the array and the initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        
        long maxVal = f;
        
        // Iterate to find F(1) ... F(n-1) using the derived formula
        for (int i = 1; i < n; i++) {
            // F(i) = F(i-1) + sum - n * nums[n - i]
            f = f + sum - (long) n * nums[n - i];
            maxVal = Math.max(maxVal, f);
        }
        
        return (int) maxVal;
    }
}