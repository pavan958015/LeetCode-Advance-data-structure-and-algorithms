import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n]; // 1 = true, 0 = false

        return solve(0, n - 1, nums, dp);
    }

    public boolean solve(int idx, int n, int[] nums, Integer[] dp) {
        if (idx >= n) return true;

        if (dp[idx] != null) return dp[idx] == 1;

        int maxJump = nums[idx];

        for (int i = 1; i <= maxJump; i++) {
            if (idx + i <= n && solve(idx + i, n, nums, dp)) {
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0; // ❗ store false properly
        return false;
    }
}