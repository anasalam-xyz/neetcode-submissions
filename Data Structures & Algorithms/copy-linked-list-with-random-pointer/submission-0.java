/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr!=null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        for(Map.Entry<Node, Node> entry: map.entrySet()) {
            entry.getValue().next = map.get(entry.getKey().next);
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
