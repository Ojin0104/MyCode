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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)return null;
        int size =0;
        ListNode now = head;
        while(now.next!=null){
            size++;
            now = now.next;
        }
        int delIdx = (size)/2;
        int idx = 0;

        now = head;
        while(size-- >0){
            if(size==delIdx){
                now.next = (now.next).next;
                break;
            }
            now=now.next;
        }

        return head;
    }
}