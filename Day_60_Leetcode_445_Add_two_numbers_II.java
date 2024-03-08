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
//approach-1 use stack
//TC: O(m+n) - 2 pass
//Sc: O(m+n) - stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //edge case
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;
        
        
        Stack<Integer> st1 = new Stack<>(); 
        Stack<Integer> st2 = new Stack<>(); 
        
        ListNode head1 = l1, head2 = l2;
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                st1.push(l1.val);
                l1 = l1.next;
            }
            
            if(l2 != null)
            {
                st2.push(l2.val);
                l2 = l2.next;
            }
        }
        
        //pop from the stack and make a node!
        ListNode after = null;
        int borrow =0;
        int sum =0;
        while(!st1.isEmpty() || !st2.isEmpty() )
        {
            int val1 = st1.isEmpty() ? 0 : st1.pop();
            int val2 = st2.isEmpty() ? 0 : st2.pop();
            
            //sum for both values
            sum = val1 + val2 + borrow;
            borrow = sum/10;
            
            ListNode newNode = new ListNode(sum%10);
            newNode.next = after;
            after = newNode;
        }
        
        //checl if broow is 0 or not
        if(borrow >0)
        {
            ListNode newNode = new ListNode(borrow);
            newNode.next = after;
            return newNode;
        }
        return after;
    }
}