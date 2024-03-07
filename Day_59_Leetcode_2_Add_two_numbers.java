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
//BF
//1. Take a ArrayList, we'll store result here
//2. We traverse thrgh the l1 and l2 to fnd ou t which one is bigger, and we go over that length!
//we check if number is not 0 - then do the addition
//if number is zero, 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int n1 = 0, n2 =0;
        ListNode t1 = l1, t2 = l2;
        while(t1.next != null) {
            t1 = t1.next;
            n1++;
        }
        while(t2.next != null) {
            t2 = t2.next;
            n2++;
        }
        if(n2 > n1) return addTwoNumbers(l2, l1);
        
        //reset the nodes
        t1 = l1;
        t2 = l2;
        
        int carry =0; 
        int sum =0;
        
        //l2 is the smaller side
        while(l2 != null)
        {
            sum = l2.val+ l1.val+carry;
            if(sum>9)
            {
                l1.val =sum%10; //add remainder as a value
                carry = sum/10;
            }else
            {
                l1.val =sum;
                carry =0;
            }
            sum =0;
             // System.out.println("At last SUM: "+sum);
            l1 = l1.next;
            l2 = l2.next;
        }        
       
        while(l1 != null && carry >0)
        {
            sum = l1.val+carry;
            carry = sum/10;
            l1.val = sum%10;
            l1 = l1.next;
        }  
       
        if(carry ==1)
        {
             l1 =t1;
            while(l1.next != null)
            { 
                l1 = l1.next;
             }
            l1.next = new ListNode(carry);
        }
        
        return t1;
    }
}
