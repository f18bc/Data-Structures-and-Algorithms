/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    // Time O(N)
    // Time O(1)
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;
        while(cur.next!=null){
            cur.val=cur.next.val;
            prev = cur;
            cur=cur.next;
        }
        prev.next = null;
    }
    */
    public void deleteNode(ListNode node) {
        // Time O(1)
        // Time O(1)
        node.val = node.next.val;
        node.next = node.next.next;
    }
}