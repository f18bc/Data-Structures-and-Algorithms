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
    public ListNode deleteDuplicates(ListNode head) {
        //Time O(n)
        //Space O(n)
        //Approach did not notice sorted
        /*if (head ==null) return head; //best solution
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.val == cur.next.val) cur.next = cur.next.next;
                else cur = cur.next;
        }*/
        Set<Integer> hSet = new HashSet<>();
        ListNode cur = head, prev = null;
        while(cur!=null){
            if (hSet.contains(cur.val)){
                cur = cur.next;
                prev.next = cur;
                
            } else {
                hSet.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}