/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node ==null){
            return null;
        }
        return dfs(node);

    }

    public Node dfs(Node node){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        ArrayList<Node> list = new ArrayList<>();
        map.put(node.val, new Node(node.val,list));
        
        for(Node now: node.neighbors){
            map.get(node.val).neighbors.add(dfs(now));
        }


        return map.get(node.val);
    }
}