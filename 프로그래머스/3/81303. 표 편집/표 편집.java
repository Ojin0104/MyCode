import java.util.*;

//linkedlist로 구현 하고 삭제한 위치의 노드 양 옆 가지고 있기
class Solution {
    public String solution(int n, int k, String[] cmd) {
        LinkedList linked = new LinkedList();
        //연결리스트 만들기
        for(int i=0;i<n;i++){
            linked.addLast(new Node(i));
        }
        Stack<Node> stack = new Stack<>();
        Node now = linked.head.next;
        for(int i=0;i<k;i++){
            now= now.next;
        }
        int time=0;
        for(String str : cmd){
            time++;
            String[] strs = str.split(" ");
            if(strs[0].equals("U")){
                
                now= beforeNode(now,Integer.parseInt(strs[1]));
            }else if(strs[0].equals("D")){
               
                 now= nextNode(now,Integer.parseInt(strs[1]));
          
            }else if(strs[0].equals("C")){
                stack.add(now);
                linked.delete(now);
                if(now.next==null){
                    now=now.before;
                }else{
                    now=now.next;
                }
            }else{//복구
                Node reload = stack.pop();
                
                reload.before.next=reload;
                if(reload.next!=null)
                    reload.next.before= reload;
            }
           
        }
        Node node= linked.head.next;
        StringBuilder sb =new StringBuilder();
        int point = 0;
        for(int i=0;i<n;i++){
            if(node!=null&&node.status==i){
                sb.append("O");
                node=node.next;
            }else{
                sb.append("X");
            }
            
        
        }
        
        return sb.toString();
    }
    static Node nextNode(Node node,int times){
        for(int i=0;i<times;i++){
            node= node.next;
        }
        
        return node;
    }
    
    
    static Node beforeNode(Node node,int times){
        for(int i=0;i<times;i++){
            node= node.before;
        }
        
        return node;
    }
    
    class LinkedList{
        Node head;
        Node tail;
        int num;
        public LinkedList(){
            head= new Node(-1);
            tail= head;
            num=0;
        }
        
        public void addLast(Node node){
            tail.next = node;
            node.before =tail;
            tail= node;
            node.status=num;
            num++;
        }
        public void delete(Node node){
            if(node.next!=null){
                Node next = node.next;
                next.before=node.before;
                node.before.next=next;
            }else{
                node.before.next=null;
            }
            
        }
    }
    
    class Node{
        Node before;
        int status; //0은 head 1은 body
        Node next;
        
        public Node(int status){
            this.status= status;
        }
    }
}