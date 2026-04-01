class Solution {

    public String encode(List<String> strs) {
        String code = "";
        for(String str: strs)
            code+=str.length()+"#"+str;
        return code;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        String word="";
        int len=0;

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='#') {
                len=Integer.parseInt(str.substring(0, i));
                word = str.substring(i+1, i+len+1);
                str = str.substring(i+len+1);
                strs.add(word);
                i=0;
            }
        }
        return strs;
    }
}
