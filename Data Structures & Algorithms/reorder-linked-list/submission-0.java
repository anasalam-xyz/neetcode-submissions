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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null) {
            list.add(curr);
            curr = curr.next;
        }
        int i = 0, j = list.size() - 1;
        while(i<j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
