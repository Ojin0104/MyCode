/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode answer = new ListNode();
        ListNode now = answer;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node: lists){
        
            while(node!=null){
                pq.add(node.val);

                node = node.next;
            }
        }

        
        while(!pq.isEmpty()){
            Integer num = pq.poll();
            now.next = new ListNode(num);
            now = now.next;
        }

        return answer.next;
    }
}