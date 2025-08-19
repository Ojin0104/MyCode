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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(root,0,answer);
        
        for(int idx =1; idx<answer.size();idx+=2){
            Collections.reverse(answer.get(idx));
        }
        return answer;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>> answer){
        if(node == null) return;
        if(answer.size()<=depth){
            answer.add(new ArrayList<>());
        }

        answer.get(depth).add(node.val);

        dfs(node.left,depth+1,answer);
        dfs(node.right,depth+1,answer);
    }
}