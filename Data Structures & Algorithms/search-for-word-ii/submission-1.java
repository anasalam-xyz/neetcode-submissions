class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList<>();
        createTrie(words, root);
        for(int r=0;r<board.length;r++) {
            for(int c=0;c<board[0].length;c++) {    
                backtrack(r, c, root, board, new StringBuilder(), res);
            }
        }
        return res;
    }
    private void backtrack(int r, int c, TrieNode node, char[][] board, StringBuilder word, List<String> res) {
        if(r<0 || r>=board.length || c<0 || c>= board[0].length)
            return;
        char ch = board[r][c];
        if(ch=='#' || !node.children.containsKey(ch))
            return;
        TrieNode next = node.children.get(ch);
        board[r][c] = '#';
        word.append(ch);
        if(next.isWord) {
            res.add(word.toString());
            next.isWord = false;
        }
        backtrack(r-1, c, next, board, word, res); 
        backtrack(r+1, c, next, board, word, res); 
        backtrack(r, c-1, next, board, word, res); 
        backtrack(r, c+1, next, board, word, res); 
        word.deleteCharAt(word.length()-1);
        board[r][c] = ch;
    }
    private void createTrie(String[] words, TrieNode root) {
        for(String word: words) {
            TrieNode cur = root;
            for(char c: word.toCharArray()) {
                cur.children.computeIfAbsent(c, k -> new TrieNode());
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }
}
