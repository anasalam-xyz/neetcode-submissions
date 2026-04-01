class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: t.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        HashMap<Character, Integer> window = new HashMap<>();
        String res = "";
        int l = 0;
        for(int r=0;r<s.length();r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            while(l<r && !freq.containsKey(s.charAt(l))) {
                l++;
            }
            boolean flag = true;
            for(char c: freq.keySet()) {
                if(freq.get(c)>window.getOrDefault(c, 0))
                    flag = false;
            }
            while(flag && l<=r) {
                String temp = s.substring(l, r+1);
                if(res.equals(""))
                    res = temp;
                else
                    if(temp.length()<res.length())
                        res = temp;
                if(window.get(s.charAt(l))>0) {
                    window.put(s.charAt(l), window.get(s.charAt(l))-1);
                    for(char c: freq.keySet()) {
                        if(freq.get(c)>window.getOrDefault(c, 0))
                        flag = false;
                    }
                } 
                else
                    window.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}
