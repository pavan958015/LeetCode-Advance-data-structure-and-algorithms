class Solution {
    public int minimumDistance(int[] nums) {
        int max = Integer.MAX_VALUE;
        int n = nums.length;

        if (n < 3) return -1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {

                if (nums[i] != nums[j]) continue; 

                for (int k = j + 1; k < n; k++) {

                    if (nums[j] != nums[k]) continue;

                    int dist = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                    max = Math.min(max, dist);
                }
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}