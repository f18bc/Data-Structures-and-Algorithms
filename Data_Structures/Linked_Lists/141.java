/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode one = head;
        ListNode two = head.next;
        
        //Here we judge two at first, if we first judge two.next, NullPointerError occurs
        while (one!=null && two!= null && two.next!=null) {
            if (one == two) return true;
            one = one.next;
            two = two.next.next;
        }
        return false;
        // Slightly improved solution
        /*while (one != two) {
            if (two == null || two.next == null) return false;
            one = one.next;
            two = two.next.next;
        }
        return true;*/
    }
}