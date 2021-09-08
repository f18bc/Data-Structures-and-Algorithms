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

/*
class Solution {
    //Time O(N)
    //Space O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null) return head; // Could be deleted
        ListNode cur = head;
        ListNode prev = null;
        while (cur!=null){
            ListNode temp = prev;
            prev = cur;
            cur=cur.next;
            prev.next=temp;
        }
        return prev; // Here if you put head here, it becomes the tail node
    }
}
*/

class Solution{
    // Recursive for fun
    // Both O(N)
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode ans = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return ans;
    }
}

