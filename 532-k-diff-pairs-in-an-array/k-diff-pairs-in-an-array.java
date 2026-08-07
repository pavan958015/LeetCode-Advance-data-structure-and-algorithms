class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        Arrays.sort(nums);
        int n = nums.length;

        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] == k) {
                    uniquePairs.add(nums[i] + " " + nums[j]);
                }
            }
        }

        return uniquePairs.size();
    }
}