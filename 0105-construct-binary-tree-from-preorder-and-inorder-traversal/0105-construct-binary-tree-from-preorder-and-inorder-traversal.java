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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //TreeNode head = preorder[0];

        TreeNode head = makeTree(preorder, inorder, 0, 0, preorder.length-1);
        return head;
    }

    public TreeNode makeTree(int[] preorder, int[] inorder,int head, int start, int end){
        if(start>end)return null;
        TreeNode now = new TreeNode(preorder[head]);
        if(start==end){
            return now;
        }
        
        int mid = findNode(inorder,preorder[head]);

        now.left = makeTree(preorder,inorder,head+1,start,mid-1);

        now.right= makeTree(preorder,inorder,head+mid-start+1,mid+1,end);

        return now;
    }

    public int findNode(int[] inorder,int node){
        for(int idx =0 ;idx< inorder.length;idx++){
            if(inorder[idx] == node){
                return idx;
            }
        }

        return -1;
    }
}