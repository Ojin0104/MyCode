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
    public ListNode partition(ListNode head, int x) {
        if(head==null)return head;
        ListNode realHead = new ListNode(-1,head);
        ListNode now = head;
        ListNode beforeNode = realHead;
        ListNode point = null;
        ListNode bigHead = null;
        while(now!=null){

            if(now.val<x && point !=null){
                beforeNode.next = now.next;
                point.next = now;
                point = point.next;
                now = now.next;
                continue;
            }
            if(now.val>=x && point == null){
                point = beforeNode;
                bigHead = now;
            }
            beforeNode = now;
            now = now.next;
        }
        if(point!=null)
        point.next = bigHead;
        return realHead.next;
    }
}