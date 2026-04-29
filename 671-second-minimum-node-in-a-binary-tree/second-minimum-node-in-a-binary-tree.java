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
    int first;
    long second=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;

        first=root.val;

        dfs(root);

        return second==Long.MAX_VALUE?-1:(int)second;
    }
    public void dfs(TreeNode node){
        if(node==null) return;

        if(node.val>first){
            second=Math.min(second,node.val);
        }
        else if(node.val==first){
            dfs(node.left);
            dfs(node.right);
        }
    }
}