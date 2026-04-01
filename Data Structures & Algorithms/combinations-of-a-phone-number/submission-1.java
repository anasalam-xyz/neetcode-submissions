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
        backtrack(digits, 0, map, new StringBuilder(), res);
        return res;
    }
    private void backtrack(String digits, int i, Map<Character, String> map, StringBuilder combo, List<String> res) {
        if(i >= digits.length()) {
            res.add(combo.toString());
            return;
        }
        for(char c: map.get(digits.charAt(i)).toCharArray()) {
            combo.append(c);
            backtrack(digits, i+1, map, combo, res);
            combo.deleteCharAt(combo.length()-1);
        }
    }
}
