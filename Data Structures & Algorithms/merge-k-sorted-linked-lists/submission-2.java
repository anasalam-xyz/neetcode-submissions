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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null)
            curr.next = list1;
        else
            curr.next = list2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        while(lists.length>1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i+1<lists.length) ? lists[i+1] : null;
                mergedLists.add(mergeTwoLists(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}
