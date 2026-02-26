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
    // int target;
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     target=targetSum; // for globly check sum
    //     return helper(root, 0);
    // }
    // public boolean helper(TreeNode root,int sum){
    //     if(root==null ) return false;
    //     sum+=root.val;
    //     if(root.left==null && root.right==null){
    //         return sum==target;
    //     }
    //     boolean left=helper(root.left,sum);
    //     boolean right=helper(root.right,sum);

    //     return left|| right;
    // }
    public boolean hasPathSum(TreeNode root,int targetSum){
        return helper(root,0,targetSum);
    }
    public static boolean helper(TreeNode root,int sum,int targetSum){
        if(root==null) return false;
        // if(root.val!=targetSum) return false;            
        // if(sum==targetSum) return true;
        
        sum+=root.val;
        if(root.left==null && root.right==null){
            return sum==targetSum;
        }
        boolean left=helper(root.left,sum,targetSum);
        boolean right=helper(root.right,sum,targetSum);
        return left|| right;
    }
}