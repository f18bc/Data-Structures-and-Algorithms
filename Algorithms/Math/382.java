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
    ListNode head;
    Random rand;
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    public int getRandom() {
        ListNode cur = head;
        int ans = head.val;
        for (int i = 1; cur.next != null; i++) {

            cur = cur.next;
            if (i == rand.nextInt(i + 1)) {
                ans = cur.val;
            }
        }
        return ans;
    }
}


/*
class Solution {
    int len;
    ListNode head;
    ListNode cur;
    public Solution(ListNode head) {
        this.head = head;
        cur = head;
        /*
        len = 0;
        
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        
        cur = head;
        
    }
    
    public int getRandom() {
        int n = (int) (Math.random() * 1e4) + 1;
        int ans = 0;
        while (n-- > 0) {
            cur = cur.next == null ? head : cur.next;
        }
        return cur.val;
    }
}
*/

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */