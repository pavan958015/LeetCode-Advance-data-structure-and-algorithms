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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (root == null) return ans;

        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();

            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                sum+=node.val;

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);

            }
            double avg=(double)sum/size;
            ans.add(avg);
        }
    return ans;
    }
}