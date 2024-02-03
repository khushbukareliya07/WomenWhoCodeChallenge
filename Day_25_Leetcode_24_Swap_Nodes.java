/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

//approach - in place pointer swapping.
//TC: O(n)
//sc: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // calculate the length f the linkedList

        ListNode prev, curr, temp, connect = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        connect = dummy;
        prev = head;
        curr = prev.next;
        temp = curr.next;

        while (prev != null && curr != null) {
            prev.next = curr.next;
            curr.next = prev;
            connect.next = curr;

            connect = prev;
            prev = temp;

            if (prev != null) {
                curr = prev.next;
                if (prev.next != null)
                    temp = prev.next.next;
            }

        }
        return dummy.next;
    }
}