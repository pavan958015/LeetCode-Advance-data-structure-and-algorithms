class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.get(nums[j])>k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}