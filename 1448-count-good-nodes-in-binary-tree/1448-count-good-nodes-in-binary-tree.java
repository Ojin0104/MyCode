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
    public int goodNodes(TreeNode root) {
        
        return dfs(root,-10000);
    }

    public int dfs(TreeNode node,int max){
        int answer  = 0;
        if(node.val>=max){
            max = node.val;
            answer++;
        }

        if(node.left!=null){
            answer+=dfs(node.left,max);
        }

        if(node.right!=null){
            answer+=dfs(node.right,max);
        }
       return answer;
    }
}