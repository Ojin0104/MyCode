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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        

        return makeTree(inorder, postorder, 0,inorder.length-1, 0,postorder.length-1);
    }

    public TreeNode makeTree(int[] inorder,int[] postorder,int inLeft,int inRight, int postLeft, int postRight){
        if(inLeft > inRight || postLeft > postRight) return null;

        TreeNode node = new TreeNode(postorder[postRight]);

        int rootIdx= findIdx(inorder,node.val);

        int leftSize = rootIdx - inLeft;
        int rightSize = inRight - rootIdx;
        node.left = makeTree(inorder,postorder,inLeft,rootIdx-1 ,postLeft,postLeft+leftSize -1);
        node.right = makeTree(inorder,postorder, rootIdx+1 , inRight, postRight-rightSize, postRight-1);

        return node;
    }

    public int findIdx(int[] inorder, int num){

        for(int idx = 0 ; idx< inorder.length; idx++){
            if(inorder[idx] ==num)
                return idx;
        }

        return -1;
    }
}