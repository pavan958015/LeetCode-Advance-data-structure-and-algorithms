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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res =new ArrayList<>();
        findPathSum(root,targetSum,res,new ArrayList<>());
        return res;
    }
    private void findPathSum(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer>list){
        if(root==null) return;

        list.add(root.val);

        if(root.left==null && root.right==null && targetSum-root.val==0){
            res.add(new ArrayList<>(list));
        }

        findPathSum(root.left,targetSum-root.val,res,list);
        findPathSum(root.right,targetSum-root.val,res,list);

        list.remove(list.size()-1);

    }
}