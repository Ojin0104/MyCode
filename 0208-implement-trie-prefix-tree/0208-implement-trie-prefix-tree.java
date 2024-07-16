class Trie {
    Node head;
    public Trie() {
        head = new Node(' ');
    }
    
    public void insert(String word) {
        Node now = head;

        for(int idx = 0 ;idx<word.length();idx++){
            if(now.getChild(word.charAt(idx))==null){
                now.addNode(word.charAt(idx));
            }

            now = now.getChild(word.charAt(idx));
        }
        now.addNode(' ');
    }
    
    public boolean search(String word) {
        Node now = head;

        for(int idx = 0 ;idx<word.length();idx++){
            if(now.getChild(word.charAt(idx))==null){
                return false;
            }
            now = now.getChild(word.charAt(idx));
        }
        if(now.getChild(' ')!=null)return true;

        return false;
    }
    
    public boolean startsWith(String prefix) {
       Node now = head;

        for(int idx = 0 ;idx<prefix.length();idx++){
            if(now.getChild(prefix.charAt(idx))==null){
                return false;
            }
            now = now.getChild(prefix.charAt(idx));
        }

        return true;
    }
}

class Node {
    HashMap<Character,Node> children;
    char ch;

    public Node(char ch){
        this.ch = ch;
        children = new HashMap<>();
    }

    public void addNode(char child){
        children.put(child,new Node(child));
    }

    public Node getChild(char child){
        return children.get(child);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */