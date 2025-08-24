import java.util.*;
class WordDictionary {

    Node head;
    public WordDictionary() {
        head = new Node('*');
    }
    
    public void addWord(String word) {
        Node now = this.head;
        for(int idx = 0;idx<word.length(); idx++){
            now = now.addChild(word.charAt(idx));
        }
        now.addChild('/');
    }
    
    public boolean search(String word) {
        return dfs(word,0,this.head);
    }

    public boolean dfs(String word, int idx, Node before){
        if(word.length() == idx && before.findChild('/') !=null){
            return true;
        }

        if(word.length() == idx) return false;

        Character now = word.charAt(idx);

        boolean status = false;

        for(Node next : before.children){
            if(now.equals('.') || now.equals(next.now)){
                status = status || dfs(word,idx+1,next);
            }

            if(status) return true;
        }

        return status;

    }

    public class Node{
        Character now;
        List<Node> children;

        public Node(Character chars){
            this.now = chars;
            children = new ArrayList<Node>();
        }

        public Node addChild(Character chars){
            Node child = findChild(chars);
            if(child == null){
                child = new Node(chars);
                children.add(child);
            }
            return child;
        }

        private Node findChild(Character chars){

            for(Node child : children){
                if(child.now.equals(chars))return child;
            }
            return null;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */