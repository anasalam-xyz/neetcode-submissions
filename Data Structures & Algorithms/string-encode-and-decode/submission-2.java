class Solution {

    public String encode(List<String> strs) {
        String code = "";
        for(String str: strs)
            code=code+str+"\n";
        return code;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        String word="";
        for(char c: str.toCharArray()) {
            if(c=='\n') {
                strs.add(word);
                word="";
                continue;
            }
            word+=c;
        }
        return strs;
    }
}
