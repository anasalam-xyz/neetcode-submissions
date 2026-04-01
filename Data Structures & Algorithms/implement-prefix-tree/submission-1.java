class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            TrieNode next = node.children[index];
            if(next == null) {
                next = new TrieNode();
                node.children[index] = next;
            }
            node = next;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String str) {
        TrieNode node = root;
        for(char c: str.toCharArray()) {
            int index = c - 'a';
            TrieNode next = node.children[index];
            if(next == null)
                return null;
            node = next;
        }
        return node;
    }
}
