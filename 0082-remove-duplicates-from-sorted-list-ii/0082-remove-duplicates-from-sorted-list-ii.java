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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode realHead = new ListNode(0,head);
        
        ListNode now = realHead;
        while(now.next!=null && now.next.next !=null){
        
            if(now.next.val == now.next.next.val){
                int num = now.next.val;
                while(now.next != null && now.next.val ==num){
                    now.next = now.next.next;
                }
                continue;
            }

            if(now.next.val!= now.next.next.val){
                now = now.next;
            }
        }
        

        return realHead.next;
    }
}