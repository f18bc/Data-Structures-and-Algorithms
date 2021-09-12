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
    /*
    public ListNode middleNode(ListNode head) {
        // Time O(N);
        // Space O(1);
        ListNode cur = head;
        int length = 0;
        
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        cur = head;
        
        for(int i=0;i<length/2;i++){
            cur=cur.next;
        }
        return cur;
    }
    */
    /*
    public ListNode middleNode(ListNode head) {
        // Time O(N);
        // Space O(1);
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    */
    public ListNode middleNode(ListNode head) {
        // Time O(1)
        // Space O(N)
        ListNode[] A = new ListNode[100];
        int length = 0;
        while(head!=null){
            A[length++]=head;
            head=head.next;
        }
        return A[length/2];
    }
}