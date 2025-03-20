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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return dfs(root,targetSum);
    }

    public int dfsCheck(TreeNode node, int targetSum, long sum){
        int answer = 0;
        sum+=node.val;

        if(sum == targetSum){answer++;
        }

        if(node.left !=null){
            answer+= dfsCheck(node.left,targetSum, sum);
        }

        if(node.right !=null){
            answer+= dfsCheck(node.right,targetSum,sum);
        }

        return answer;
    }

    public int dfs(TreeNode node, int targetSum){
        int answer = 0;

        answer+=dfsCheck(node,targetSum,0);

        if(node.left !=null){
            answer+= dfs(node.left,targetSum);
        }

        if(node.right !=null){
            answer+= dfs(node.right,targetSum);
        }

        return answer;
    }



    
}