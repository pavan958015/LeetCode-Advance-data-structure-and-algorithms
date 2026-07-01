// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return solve(0, target, nums);
//     }

//     public static int solve(int idx, int target, int[] nums) {

//         if (idx == nums.length) {
//             return target == 0 ? 1 : 0;
//         }

//         int positive = solve(idx + 1, target - nums[idx], nums);
//         int negative = solve(idx + 1, target + nums[idx], nums);

//         return  positive + negative;
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) {
            return 0;
        }
        
        int s1 = (totalSum + target) / 2;
        Integer[][] dp = new Integer[nums.length][s1 + 1];
        return solve(0, s1, nums, dp);
    }
    
    private int solve(int idx, int currentTarget, int[] nums, Integer[][] dp) {
        if (idx == nums.length) {
            return currentTarget == 0 ? 1 : 0;
        }
        
        if (dp[idx][currentTarget] != null) {
            return dp[idx][currentTarget];
        }
        
        int skip = solve(idx + 1, currentTarget, nums, dp);
        
        int include = 0;
        if (nums[idx] <= currentTarget) {
            include = solve(idx + 1, currentTarget - nums[idx], nums, dp);
        }
        
        return dp[idx][currentTarget] = skip + include;
    }
}