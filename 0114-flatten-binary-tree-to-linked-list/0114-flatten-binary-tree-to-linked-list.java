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
    public void flatten(TreeNode root) {
        TreeNode now = root;
        
        while(now != null){
            if(now.left!=null){
                TreeNode curr = now.left;
                while(curr.right!=null)
                {
                    curr = curr.right;
                }

                curr.right = now.right;
                now.right = now.left;
                now.left = null;
            }

            now = now.right;
        }
    }

}