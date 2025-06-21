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
class BSTIterator {

    private int idx;
    private List<TreeNode> nodeList;
    public BSTIterator(TreeNode root) {
        this.idx = -1;
        nodeList = new ArrayList<TreeNode>();
        createNodelist(root);
    }
    
    public int next() {
        this.idx++;
        return nodeList.get(this.idx).val;
    }
    
    public boolean hasNext() {
        if(this.idx+1 >= this.nodeList.size())return false;

        return true;
    }

    public void createNodelist(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            createNodelist(node.left);
        }
        this.nodeList.add(node);
        
        if(node.right !=null){
            createNodelist(node.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */