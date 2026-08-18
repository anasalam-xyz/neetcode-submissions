class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len1 = w1.length(), len2 = w2.length();
            int minLen = Math.min(len1, len2);
            if(len1 > len2 && w1.substring(0, minLen).equals(w2))
                return "";

            for(int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    adj.get(c1).add(c2);
                    break;
                }
            }
        }

        int[] state = new int[26];
        StringBuilder res = new StringBuilder();
        for(char c: adj.keySet()) {
            if(dfs(c, adj, state, res))
                return "";
        } 

        return res.reverse().toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> adj, int[] state, StringBuilder sb) {
        int idx = c - 'a';
        if(state[idx] == 2) return false;
        else if(state[idx] == 1) return true;

        state[idx] = 1;
        for(char nei: adj.get(c)) {
            if(dfs(nei, adj, state, sb))
                return true;
        }
        state[idx] = 2;
        sb.append(c);

        return false;
    } 
}
