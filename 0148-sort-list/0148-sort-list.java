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
    public ListNode sortList(ListNode head) {
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null)return head;
        
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //나누고
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        //합치고
        return merge(left,right);

    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(0);
        ListNode now = head;
        while(left!=null &&right!=null){
            if(left.val < right.val){
                now.next = left;
                left = left.next;
            }else{
                now.next = right;
                right = right.next;
            }
            now = now.next;
        }

        if(left == null){
           now.next = right; 
        }else{
            now.next = left;
        }


        return head.next;
    }
}