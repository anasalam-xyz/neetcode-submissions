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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(l1.val+l2.val);
        ListNode curr1 = l1.next;
        ListNode curr2 = l2.next;
        ListNode prev = sum;
        while(curr1!=null || curr2!=null) {
            ListNode curr = new ListNode();
            if(curr1==null) {
                curr.val = curr2.val;
                curr2 = curr2.next;
            }
            else if(curr2==null) {
                curr.val = curr1.val;
                curr1 = curr1.next;
            }
            else {
                curr.val = curr1.val + curr2.val;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            prev.next = curr;
            prev = curr;
        }
        prev = sum;
        while(prev!=null) {
            if(prev.val>9) {
                if(prev.next==null) {
                    prev.next = new ListNode();
                }
                prev.val-=10;
                prev.next.val+=1;
            }
            prev = prev.next;
        }
        return sum;
    }
}
