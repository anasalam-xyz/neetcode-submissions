class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len%2==1) return false;
        Deque<Character> q = new ArrayDeque<>();
        for(int i=0;i<len;i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                q.addLast(c);
            else {
                if(q.isEmpty())
                    return false;
                char t = q.peekLast();
                if((t=='(' && c==')') || (t=='{' && c=='}') ||(t=='[' && c==']'))
                    q.pollLast();
                else
                    return false;
            }
        }
        return q.isEmpty();
    }
}
