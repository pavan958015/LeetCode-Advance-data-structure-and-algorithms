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
    long maxProduct = 0;
    long totalSum = 0;
    int mod = (int) 1e9 + 7;
    public  void calculateSum(TreeNode root){
        if(root==null) return;
        totalSum+=root.val;
        calculateSum(root.left);
        calculateSum(root.right);
    }
    public  int solve(TreeNode root){
        if(root==null) return 0;
        int subTree=root.val;
        subTree+=solve(root.left);
        subTree+=solve(root.right);
        maxProduct=Math.max(maxProduct,subTree*(totalSum-subTree));
        return subTree;
    }
    public int maxProduct(TreeNode root) {

        calculateSum(root);
        long ans=solve(root);
        long mod=(int)(1e9+7);
        return (int) (maxProduct % mod);
    }
}