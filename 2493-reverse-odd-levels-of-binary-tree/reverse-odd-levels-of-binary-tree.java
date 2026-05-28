class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root != null) {
            dfs(root.left, root.right, 1);
        }
        return root;
    }

    private void dfs(TreeNode leftNode, TreeNode rightNode, int level) {
        if (leftNode == null || rightNode == null) {
            return;
        }

        if (level % 2 != 0) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }

        dfs(leftNode.left, rightNode.right, level + 1);
        dfs(leftNode.right, rightNode.left, level + 1);
    }
}