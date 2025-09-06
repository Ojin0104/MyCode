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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while(count<k ){
            if(current== null)return head;
            count++;
            current = current.next;
        }

        
        if(count==k){
            current = reverseKGroup(current,k);
        
            while(k-->0){
                ListNode temp = head.next;
                head.next = current;
                current= head;
                head = temp;
            }
        head = current;
        }

        return head;
    }
}