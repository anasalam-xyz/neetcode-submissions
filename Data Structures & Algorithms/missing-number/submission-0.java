class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int total = (len + 1) * len / 2;
        int sum = 0;
        for(int n: nums)
            sum += n;
        return total - sum;
    }
}
