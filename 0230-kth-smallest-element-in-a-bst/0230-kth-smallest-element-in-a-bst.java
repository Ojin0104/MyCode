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
    int answer = 0;
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        

        dfs(root,k);


        return answer;       
    }

    public void dfs(TreeNode node,int k ){
        if(node.left!=null){
            dfs(node.left,k);
        }

        count++;
        if(k == count){
            answer = node.val;
            return;
        }

        if(node.right!=null){
            dfs(node.right,k);
        } 
}
}