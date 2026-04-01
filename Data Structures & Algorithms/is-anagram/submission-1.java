class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for(char c: s.toCharArray()) mapS.put(c, mapS.getOrDefault(c, 0)+1);
        for(char c: t.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0)+1);
        if(mapS.equals(mapT))
            return true;
        return false;
    }  
}