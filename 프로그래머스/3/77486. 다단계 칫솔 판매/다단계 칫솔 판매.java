import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String,Node> map = new HashMap<>();
        Node head = new Node(null,0);
        map.put("-",head);
        
        //트리와 맵에 직원 등록
        enrollSeller(enroll,referral,map);
        
        for(int idx = 0;idx<seller.length;idx++){
            Node now = map.get(seller[idx]);
            
            now.sellItem(amount[idx]*100);
        }
        
        for(int idx= 0 ;idx<enroll.length;idx++){
           answer[idx] = map.get(enroll[idx]).money;
        }
        return answer;
    }
    
    static void enrollSeller(String[] enroll, String[] referral,HashMap<String,Node> map){
        for(int i =0 ;i<enroll.length;i++){
            Node parent = map.get(referral[i]);
            Node me = new Node(parent,0);
            map.put(enroll[i],me);
            parent.addChild(me);
        }
    }
    
    
}

class Node{
    Node parent;
    ArrayList<Node> children = new ArrayList<>();
    int money;
    public Node(Node parent,int money){
        this.parent = parent;
        this.money = money;
    }
    
    void sellItem(int amount){
        if(parent!=null){
            int next = amount/10;
            this.money += amount-next;
            parent.sellItem(next);
        }
    }
    
    void addChild(Node child){
        this.children.add(child);
    }
    
    
}