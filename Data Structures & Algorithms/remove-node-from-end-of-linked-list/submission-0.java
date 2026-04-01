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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        int len = 0;
        while(curr!=null) {
            len++;
            curr = curr.next;
        }
        curr = dummy;
        int i = 0;
        while(i<len-n) {
            curr = curr.next;
            i++;
        }
        if(len>1) {
            ListNode temp = curr.next.next;
            curr.next.next = null;
            curr.next = temp;
            head = dummy.next;
        }
        else {
            head = null;
        }
        return head;
    }
}
