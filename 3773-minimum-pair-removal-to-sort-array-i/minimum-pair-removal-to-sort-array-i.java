class Solution {

    public static void shiftLeft(int[] nums, int idx, int size) {
        for (int i = idx; i < size - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void mergePairs(int[] nums, int[] sizeRef) {
        int size = sizeRef[0];
        int minSum = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < size - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (sum < minSum) {
                minSum = sum;
                minIdx = i;
            }
        }

        nums[minIdx] = minSum;
        shiftLeft(nums, minIdx + 1, size);
        sizeRef[0]--;  
    }

    public static boolean isSorted(int[] nums, int size) {
        for (int i = 0; i < size - 1; i++) {
            if (nums[i + 1] < nums[i]) return false;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int res = 0;
        int[] sizeRef = new int[]{nums.length};

        while (!isSorted(nums, sizeRef[0])) {
            mergePairs(nums, sizeRef);
            res++;
        }
        return res;
    }
}
