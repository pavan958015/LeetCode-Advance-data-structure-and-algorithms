class Solution {
    public int[] singleNumber(int[] nums) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;
        for (int n : map.keySet()) {
            if (map.get(n) == 1) {
                arr[index++] = n;
            }
            
            // Optimization: stop once both numbers are found
            // if (index == 2) break;
        }

        return arr;
    }
}