class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node() {}
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private Node left;
    private Node right;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node();
        this.right = new Node();
        this.left.next = right;
        this.right.prev = left;
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if(cache.size()>cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
