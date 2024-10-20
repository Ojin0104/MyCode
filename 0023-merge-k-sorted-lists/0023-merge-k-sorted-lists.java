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
        ListNode node = answer;
        while(true){
            
            boolean flag = false;
            int minVal = 100000;
            int minIdx = 0;
            for(int idx= 0; idx<lists.length;idx++){
                if(lists[idx] ==null)continue;
                if(lists[idx].val <minVal){
                    minVal = lists[idx].val;
                    minIdx = idx;
                    flag = true;
                }
            }


            if(!flag)break;
            node.next = new ListNode(minVal);
            node = node.next;
            lists[minIdx] = lists[minIdx].next;
        }

        return answer.next;
    }
}