class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();

        for (int count : map.values()) {
            if (set.contains(count)) {
                return false;
            }
            set.add(count);
        }

        return true;
    }
}