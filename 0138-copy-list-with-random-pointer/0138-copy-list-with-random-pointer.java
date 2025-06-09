/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();
        Node now = head;
        Node newNow = copyNode(now);

        nodeMap.put(newNow,now);

        Node newHead = addNode(nodeMap, now);

        now = head;
        while(now!= null){
            Node newRandom = nodeMap.get(now.random);
            nodeMap.get(now).random = newRandom;
            now = now.next;
        }
        
        return newHead;
    }

    public Node addNode(Map<Node,Node> map, Node node){
        if(node == null){
            return null;
        }
        
        Node newNode = copyNode(node);

        newNode.next=addNode(map,node.next);
        map.put(node,newNode);
        return newNode;
    }

    public Node copyNode(Node node){
        if(node == null) return null;
        Node newNode = new Node(node.val);
        return newNode;
    }
}