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
    //Time O(N)
    //Space O(1)
    //Reverse the first half, best solution
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode cur = head;
        
        int length = 0;
        while(cur!=null){
            length++; //Loop and get the whole length
            cur=cur.next;
        }
        
        //Start to reverse the first half
        cur = head;
        ListNode prev = null;
        
        for(int i=0;i<length/2;i++){
            ListNode temp = prev;
            prev = cur;
            cur = cur.next;
            prev.next = temp;
        }
        if (length % 2 != 0) cur = cur.next; //For length odd situation
        while (cur!= null && prev!=null) {
            if (cur.val != prev.val) return false; //check if palindrome
            cur = cur.next;
            prev = prev.next;
        }
        return true;
    }
}