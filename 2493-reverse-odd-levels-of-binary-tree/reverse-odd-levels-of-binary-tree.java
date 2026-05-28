// class Solution {
//     public TreeNode reverseOddLevels(TreeNode root) {
//         if (root != null) {
//             dfs(root.left, root.right, 1);
//         }
//         return root;
//     }

//     private void dfs(TreeNode leftNode, TreeNode rightNode, int level) {
//         if (leftNode == null || rightNode == null) {
//             return;
//         }

//         if (level % 2 != 0) {
//             int temp = leftNode.val;
//             leftNode.val = rightNode.val;
//             rightNode.val = temp;
//         }

//         dfs(leftNode.left, rightNode.right, level + 1);
//         dfs(leftNode.right, rightNode.left, level + 1);
//     }
// }


class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (level % 2 != 0) {
                int left = 0;
                int right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}