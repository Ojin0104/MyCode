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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        

        //left ~ right 까지 이동하면서 next를 이전 노드로 변경 
        //left이전 노드의 next는 right위치에 해당하는 노드
        // left위치의 노드 는 right+1위치에 해당하는 노드 
        ListNode realHead = new ListNode(0,head);
        ListNode now = realHead;
        for(int idx = 1 ;idx<left; idx++){
            now= now.next;
        }
        ListNode tail = dfs(now.next, now,right-left);
        now.next = tail;

        return realHead.next;
    }


    static ListNode dfs(ListNode now, ListNode head, int count){
        if(count==0){
            head.next.next = now.next;
            return now;
        }

        
        ListNode next = now.next;
        ListNode tail = dfs(next,head,count-1);
        next.next = now;

        return tail;

    }
}