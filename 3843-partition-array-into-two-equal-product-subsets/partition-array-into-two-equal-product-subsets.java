class Solution {
    private long product(int[] nums) {
        long mul = 1;

        for (int x : nums) {
            mul *= x;
        }

        return mul;
    }

    public boolean checkEqualPartitions(int[] nums, long target) {

        long product = product(nums);

        if (product != target * target)
            return false;


        return solve(0, nums, target);
    }

    private boolean solve(int idx, int[] nums, long target) {

        if (target == 1)
            return true;

        if (idx >= nums.length)
            return false;

        boolean take = false;

        if (target % nums[idx] == 0) {
            take = solve(idx + 1, nums, target / nums[idx]);
        }

        boolean notTake = solve(idx + 1, nums, target);

        return take || notTake;
    }
}