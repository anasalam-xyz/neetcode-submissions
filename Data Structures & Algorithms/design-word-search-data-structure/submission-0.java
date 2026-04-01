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
        return searchDots(word, root);
    }

    public boolean searchDots(String word, TrieNode curr) {
        TrieNode node = curr;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()) {
                    boolean flag = searchDots(word.substring(i+1), entry.getValue());
                    if(flag) return flag;
                }
            }
            TrieNode next = node.children.get(c);
            if(next == null) return false;
            node = next;
        }
        return node.isWord;
    }
}
