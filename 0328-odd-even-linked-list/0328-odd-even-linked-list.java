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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return head;
        ListNode odd = new ListNode(head.val);
        if(head.next == null)return head;
        ListNode even = new ListNode(head.next.val);
        ListNode node = head.next.next;

        ListNode nowOdd = odd;
        ListNode nowEven = even;
        int point =1;
        while(node!=null){
            if(point%2==1){
                nowOdd.next = new ListNode(node.val);
                nowOdd = nowOdd.next;
            }else{
                nowEven.next = new ListNode(node.val);
                nowEven = nowEven.next;
            }

            node = node.next;
            point++;
        }

        nowOdd.next = even;

        return odd; 
    }
}