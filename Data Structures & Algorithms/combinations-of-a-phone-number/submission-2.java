class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), res, map);
        return res;
    }
    private void backtrack(int start, String digits, StringBuilder cur, List<String> res, Map<Character, String> map) {
        if(start == digits.length() && cur.length() == digits.length()) {
            res.add(cur.toString());
            return;
        }
        for(int i = start; i < digits.length(); i++) {
            for(char c: map.get(digits.charAt(i)).toCharArray()) {
                cur.append(c);
                backtrack(i + 1, digits, cur, res, map);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    } 
}
