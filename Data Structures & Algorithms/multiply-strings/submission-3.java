class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for(int i = 0; i < m; i++) {
            int x = num1.charAt(i) - '0';
            for(int j = 0; j < n; j++) {
                int y = num2.charAt(j) - '0';
                int p = x * y;
                res[i + j] += p;
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while(i >= 0 && res[i] == 0) 
            i--;
        while(i >= 0)
            result.append(res[i--]);

        return result.toString();
    }
}
