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
    private int ans = 0;
    private int maxDepth=-1;

    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        solve(root, 0);
        return ans;
    }

    public  void solve(TreeNode root, int depth) {
        if (root == null)
            return;
        

        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }

        solve(root.left, depth+1);
        solve(root.right, depth+1);
    }
}