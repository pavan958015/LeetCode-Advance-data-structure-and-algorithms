class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int product = 1;
        int zeroCount = 0;

        for (int x : nums) {
            if (x == 0) {
                zeroCount++;
            } else {
                product *= x;
            }
        }

        if (zeroCount > 1) {
            return ans; // all values remain 0
        }

        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    ans[i] = product;
                }
            } else {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}