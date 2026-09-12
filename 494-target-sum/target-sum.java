class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,nums,target);
    }
    private int solve(int idx,int[] nums,int target){
        if(idx==nums.length){
            if(target==0) return 1;
            else return 0;
        }

        int positive=solve(idx+1,nums,target+nums[idx]);
        int negative=solve(idx+1,nums,target-nums[idx]);

        return positive+negative;
    }
}