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
    // public boolean isSymmetric(TreeNode root) {
    //     return root==null || isSymmetricHelp(root.left,root.right);
    // }
    // public static boolean isSymmetricHelp(TreeNode left,TreeNode right){
    //     if(left==null || right==null){
    //         return left==right;
    //     }
    //     if(left.val!=right.val) return false;

    //     return isSymmetricHelp(left.left,right.right)
    //     &&
    //     isSymmetricHelp(left.right,right.left);
    // }


    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null || root.right==null) return root.left==root.right;
        if(root.left.val!=root.right.val) return false;

        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode a,TreeNode b){
        if(a==null || b==null) return a==b;
        if(a.val!=b.val) return false;
        return helper(a.left,b.right) && helper(a.right,b.left);
    }

}