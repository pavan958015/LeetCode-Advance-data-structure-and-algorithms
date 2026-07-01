class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if (sum % k != 0)
            return false;

        int target = sum / k;

        Arrays.sort(nums);

        // reverse(nums);

        boolean[] visited = new boolean[nums.length];

        return dfs(nums, visited, 0, 0, k, target);
    }

    private boolean dfs(int[] nums, boolean[] visited,
                        int start, int currSum,
                        int k, int target) {

        if (k == 1)
            return true;

        if (currSum == target)
            return dfs(nums, visited, 0, 0, k - 1, target);

        for (int i = start; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (currSum + nums[i] > target)
                continue;

            visited[i] = true;

            if (dfs(nums, visited, i + 1,
                    currSum + nums[i], k, target))
                return true;

            visited[i] = false;
        }

        return false;
    }

    private void reverse(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}