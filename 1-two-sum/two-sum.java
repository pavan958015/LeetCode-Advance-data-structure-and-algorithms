class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int need=target-nums[i];
            if(map.containsKey(need)) return new int[]{i,map.get(need)};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}