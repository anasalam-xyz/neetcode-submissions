class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    private void backtrack(int n, int l, int r, StringBuilder sb, List<String> res) {
        if(sb.length() == n*2) {
            res.add(sb.toString());
            return;
        }
        if(l < n) {
            sb.append("(");
            backtrack(n, l+1, r, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r < l) {
            sb.append(")");
            backtrack(n, l, r+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
