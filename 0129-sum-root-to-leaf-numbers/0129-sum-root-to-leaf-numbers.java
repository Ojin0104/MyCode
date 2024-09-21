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
    public int sumNumbers(TreeNode root) {

        return sumsNumbers(root,0);
    }

    public int sumsNumbers(TreeNode node, int num){
        if(node.left==null && node.right ==null){
            return num*10+node.val;
        }
        int number = 0;
        if(node.left!=null){
            number+= sumsNumbers(node.left,num*10+node.val);
        }

        if(node.right!=null){
            number+= sumsNumbers(node.right,num*10+node.val);
        }

        return number;
    }
}