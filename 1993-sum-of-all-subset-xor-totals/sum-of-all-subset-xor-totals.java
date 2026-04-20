class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(0,nums,0);
    }
    private int solve(int idx,int[] nums,int xor){
        if(idx>=nums.length) return xor;

        return solve(idx+1,nums,xor^nums[idx]) + solve(idx+1,nums,xor);
    }
}