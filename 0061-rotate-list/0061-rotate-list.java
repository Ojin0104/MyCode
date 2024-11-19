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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode realHead = new ListNode(-1);
        realHead.next = head;
        
        

        ListNode now= head;
        int size =1;
        if(now==null)return head;
        while(now.next!=null){
            now = now.next;
            size++;
        }
        now.next = head;

        k%=size;

        for(int idx =0 ; idx<size-k;idx++){
            
            now= now.next;
            if(idx ==size-k-1){
            realHead.next = now.next;
            now.next = null;
            }
        }
        return realHead.next;
    }

    
}