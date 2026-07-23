class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if ((long)m * k > n)
            return -1;

        int ans = max;
        int left = min;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (possible(mid, m, k, bloomDay)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int day, int m, int k, int[] nums) {

        int flowers = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= day) {
                flowers++;

                if (flowers == k) {
                    count++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return count >= m;
    }
}