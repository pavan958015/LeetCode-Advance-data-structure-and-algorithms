class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;

            } else if (nums[mid] < nums[r]) {
                r = mid;

            } else {
                // if not decide means dublicate so only shrink one step form right;
                r--;
            }
        }

        return nums[l];
    }
}