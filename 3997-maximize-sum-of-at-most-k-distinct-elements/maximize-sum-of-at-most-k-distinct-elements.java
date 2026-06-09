class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int dis[] = new int[set.size()];
        int idx = 0;
        for (int n : set) {
            dis[idx++] = n;
        }
        Arrays.sort(dis);
        int n = dis.length;
        k = Math.min(k, n);

        int ans[] = new int[k];
        int left = 0;
        for (int i = n - 1; i >= n - k; i--) {
            ans[left++] = dis[i];
        }
        return ans;

    }
}