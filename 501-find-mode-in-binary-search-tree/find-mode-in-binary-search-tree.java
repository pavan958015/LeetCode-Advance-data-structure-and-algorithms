class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[] {};
        if (root.left == null && root.right == null)
            return new int[] { root.val };

        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, map);

        int max = 0;
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        dfs(node.left, map);
        dfs(node.right, map);
    }
}