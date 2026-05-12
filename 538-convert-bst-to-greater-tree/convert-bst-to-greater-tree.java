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
    static int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        sum=0;
        return solve(root);
    }
    public static TreeNode solve(TreeNode root){
        if(root==null) return null;

        solve(root.right);

        sum+=root.val;
        root.val=sum;
        solve(root.left);

        return root;
    }
}