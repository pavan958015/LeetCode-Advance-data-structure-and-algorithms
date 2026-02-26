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
    // public TreeNode invertTree(TreeNode root) {
    //   // Using Itration
    //   if(root==null) return null;

    //   // Using Level Order 
    //   Queue<TreeNode> q=new LinkedList<>();
    //   q.add(root);
    //   while(!q.isEmpty()){
    //     TreeNode node=q.poll();

    //     // Swap
    //     TreeNode temp=node.left;
    //     node.left=node.right;
    //     node.right=temp;

    //     if(node.left!=null){
    //         q.add(node.left);
    //     }
    //     if(node.right!=null){
    //         q.add(node.right);
    //     }

    //   }
    //   return root;
    // }


        public static TreeNode invertTree(TreeNode root){
            if(root==null){
                return root;
            }
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode cur=q.poll();
                    
                    TreeNode temp=cur.left;
                    cur.left=cur.right;
                    cur.right=temp;

                    if(cur.left!=null){
                        q.add(cur.left);
                    }
                    if(cur.right!=null){
                        q.add(cur.right);
                    }
                }
            }
            return root;
        }
}