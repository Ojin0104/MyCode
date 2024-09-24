import java.util.*;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        if(root!=null)
            findRight(root, numbers, 0);

        return numbers;
    }

    public void findRight(TreeNode node, List<Integer> numbers, int depth){
        if(numbers.size()==depth)numbers.add(node.val);
        
        if(node.right!=null){
            findRight(node.right,numbers,depth+1);
        }
        
         if(node.left!=null){
            findRight(node.left,numbers,depth+1);
        }
    }
}