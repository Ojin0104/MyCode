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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode now = answer;
        boolean upbit = false;
        while(l1!=null && l2!=null){
            int a = l1.val;
            int b= l2.val;
            int num = a+b;
            if(upbit){
                num+=1;
                upbit=false;
            }
            if(num>=10){
                num-=10;
                upbit = true;
            }
            now.next = new ListNode(num);
            now= now.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(upbit){
            if(l1==null&&l2==null)now.next = new ListNode(1);
            extend(l1,l2);
        }

        if(l1!=null){
            now.next = l1; 
        }

        if(l2!=null){
            now.next = l2;
        }
        
        return answer.next;
    }

    static void extend(ListNode l1,ListNode l2){
        
        while(l1!=null){

            int num = l1.val+1;
            
            if(num>=10){
                num-=10;
                if(l1.next==null){
                    l1.next = new ListNode(0);
                }
                l1.val = num;
                l1 = l1.next;
                continue;
            }

            l1.val = num;
            break;
            
        }

       

       

         while(l2!=null){

            int num = l2.val+1;
            
            if(num>=10){
                num-=10;
                if(l2.next==null){
                    l2.next = new ListNode(0);
                }
             l2.val = num;
            l2 = l2.next;
            continue;
            }
            l2.val = num;
            break;
        }


    }
}