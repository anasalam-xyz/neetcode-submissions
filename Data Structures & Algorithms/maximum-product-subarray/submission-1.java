class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int res = nums[0];
        for(int n: nums) {
            int temp = min;
            min = Math.min(n, Math.min(min * n, max * n));
            max = Math.max(n, Math.max(temp * n, max * n));
            res = Math.max(res, max);
        }
        return res;
    }
}
