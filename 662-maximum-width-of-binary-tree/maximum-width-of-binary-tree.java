/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().level;

            int start = 0;
            int end = 0;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int curIndex = cur.level - minIndex;

                if (i == 0)
                    start = curIndex;
                if (i == size - 1)
                    end = curIndex;
                if (cur.node.left != null)
                    q.add(new Pair(cur.node.left, 2 * curIndex));
                if (cur.node.right != null)
                    q.add(new Pair(cur.node.right, 2 * curIndex + 1));
            }

            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}