class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(String s, int i, List<String> curr, List<List<String>> res) {
        if(i >= s.length()) {
            if(arePalindromes(curr))
                res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(String.valueOf(s.charAt(i)));
        backtrack(s, i+1, curr, res);
        curr.remove(curr.size()-1);
        if(!curr.isEmpty()) {
            int last = curr.size()-1;
            String temp = curr.get(last);
            curr.set(last, temp+s.charAt(i));
            backtrack(s, i+1, curr, res);
            curr.set(last, temp);
        }
    }
    private boolean arePalindromes(List<String> strs) {
        for(String s: strs) 
            if(!isPalindrome(s))
                return false;
        return true;
    }   
    private boolean isPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++) 
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        return true;
    }
}
