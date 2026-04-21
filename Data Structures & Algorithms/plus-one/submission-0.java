class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len - 1;
        while(index >= 0) {
            if(digits[index] != 9) {
                digits[index] += 1;
                return digits;
            }
            else {
                digits[index] = 0;
            }
            index--;
        }
        
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}
