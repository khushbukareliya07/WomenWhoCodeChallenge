/*Approach: 

1. Use Stack  - brute force, push nodes in stack until count%k is zero.*/

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
        
        ListNode dummy = new ListNode<>(-1);
        dummy.next = head;
        ListNode begin = head;
        ListNode prev = head;
        ListNode curr  = new ListNode<>(-1);
        Stack<ListNode> stack = new Stack<>();
        
        int count =0;
        
        while(begin != null && begin.next != null)
        {
            if(count%k == 0 && !stack.isEmpty())
            {
                //reverse the nodes - pop
                //1 <-2 <-3 -begin at 4
                head = stack.pop();
                while(!stack.isEmpty())
                {
                    head.next = stack.pop();
                }
                head.next = begin;
                
            }else
            {
                stack.push(begin);
                count++;
                begin = begin.next;
            }
        }
    }
}