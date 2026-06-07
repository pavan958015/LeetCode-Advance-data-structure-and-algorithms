class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        // set for childrent node and we can find root with the help of this
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int[] node : descriptions) {

            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];

            children.add(child);

            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }



            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }




        // Root find karne ke liye
        for (int[] node : descriptions) {
            int parent = node[0];

            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
     }

}