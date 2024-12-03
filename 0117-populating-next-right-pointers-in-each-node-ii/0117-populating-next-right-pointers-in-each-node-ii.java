/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    ArrayList<Node> list = new ArrayList<>();
    public Node connect(Node root) {
        list.add(root);
        inorder(root,1);
        return root;
    }

    void inorder(Node node, int idx){

        if(node ==null)return;

        if(list.size()<idx+1){
            list.add(node);
        }else{
            addNode(list.get(idx),node);
        }

        inorder(node.left,idx+1);

        inorder(node.right,idx+1);
    }

    void addNode(Node head, Node node){
        Node now = head;
        while(now.next!=null){
            now = now.next;
        }

        now.next = node;
    }
}