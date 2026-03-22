class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, target, nums);
    }

    public static int solve(int idx, int target, int[] nums) {

        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int positive = solve(idx + 1, target - nums[idx], nums);
        int negative = solve(idx + 1, target + nums[idx], nums);

        return  positive + negative;
    }
}