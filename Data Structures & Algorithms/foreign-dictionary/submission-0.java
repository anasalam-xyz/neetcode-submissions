class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited;
    private List<Character> res;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word: words)
            for(char c: word.toCharArray()) 
                adj.putIfAbsent(c, new HashSet<>());

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int len1 = w1.length(), len2 = w2.length();
            int minLen = Math.min(len1, len2);
            if(len1 > len2 && w1.substring(0, minLen).equals(w2.substring(0, minLen)))
                return "";
            for(int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2) {
                    adj.get(c1).add(c2);
                    break;
                }
            }
        }

        visited = new HashMap<>();
        res = new ArrayList<>();
        for(char c: adj.keySet())
            if(dfs(c))
                return "";

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for(char c: res)
            sb.append(c);

        return sb.toString();
    }
    private boolean dfs(char c) {
        if(visited.containsKey(c))
            return visited.get(c);
        visited.put(c, true);
        for(char next: adj.get(c))
            if(dfs(next))
                return true;
        
        visited.put(c, false);
        res.add(c);
        return false;
    }
}
