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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode realHead = new ListNode(0,head);
        dfs(realHead,n);

        return realHead.next;
    }

    static int dfs(ListNode node,int n){
        if(node.next==null)return 1;

        int count = dfs(node.next,n);
        if(count == n){
            node.next = node.next.next;
        }
            return count+1;
        
    }
}