class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int len = beginWord.length();
        Map<String, List<String>> adj = new HashMap<>();
        wordList.add(beginWord);
        for(String word: wordList) {
            for(int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        int res= 1;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.equals(endWord))
                    return res;
                for(int j = 0; j < len; j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1);
                    for(String nei: adj.getOrDefault(pattern, new ArrayList<>())) {
                        if(!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                    adj.get(pattern).clear();
                }
            }
            res++;
        }
        return 0;
    }
}
