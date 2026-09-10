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
    int ans=0;
    private int[] dfs(TreeNode root){
        if(root==null) return new  int[]{0,0};

        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        int curSum=left[0]+right[0]+root.val;
        int curCount=left[1]+right[1]+1;

        if(root.val==curSum/curCount) ans++;

        return new int[]{curSum,curCount};

    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}