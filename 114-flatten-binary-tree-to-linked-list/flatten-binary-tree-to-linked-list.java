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
    TreeNode before=null;
    public void flatten(TreeNode root) {
        if(root==null) return;

        flatten(root.right);
        flatten(root.left);

        root.right=before;
        root.left=null;

        before=root;
    }
}