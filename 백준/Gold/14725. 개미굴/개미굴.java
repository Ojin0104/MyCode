
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node head = new Node("",-1);
        for(int times = 0 ;times < N; times++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node now = head;
            for(int depth = 0; depth<K ; depth++){
                String child = st.nextToken();

                now = now.add(child);
            }
        }


        dfs(head,sb);

        System.out.println(sb);
    }

    static void dfs(Node node,StringBuilder sb){
        node.sort();
        for(int times = 0 ;times<node.depth; times++){
            sb.append("--");
        }
        if(!node.value.isEmpty()) {
            sb.append(node.value + "\n");
        }
        if(node.children.isEmpty())return;
        for(int idx = 0 ;idx<node.children.size();idx++){
            dfs(node.children.get(idx),sb);
        }

    }

    static class Node{
        String value;
        ArrayList<Node> children;
        HashMap<String,Integer> childMap;

        int depth;

        public Node(String value,int depth){
            this.value = value;
            this.depth = depth;
            children = new ArrayList<>();
            childMap = new HashMap<>();
        }
        public void sort(){
            Collections.sort(this.children,(s1, s2)->s1.value.compareTo(s2.value));
        }
        public Node add(String child){
            if(!childMap.containsKey(child)){
                Node node = new Node(child,this.depth+1);
                children.add(node);
                childMap.put(child,children.size()-1);
                return node;
            }else{
                return children.get(childMap.get(child));
            }
        }
    }
}