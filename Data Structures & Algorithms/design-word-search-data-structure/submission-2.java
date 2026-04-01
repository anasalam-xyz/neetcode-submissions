class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            node.children.computeIfAbsent(c, k -> new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchDots(word, 0, root);
    }

    public boolean searchDots(String word, int start, TrieNode curr) {
        TrieNode node = curr;
        for(int i=start;i<word.length();i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child: node.children.values()) {
                    if(searchDots(word, i+1, child)) 
                        return true;
                }
                return false;
            }
            TrieNode next = node.children.get(c);
            if(next == null) return false;
            node = next;
        }
        return node.isWord;
    }
}
