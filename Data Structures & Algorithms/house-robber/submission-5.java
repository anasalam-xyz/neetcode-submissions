class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int n: nums) {
            int temp = rob1;
            rob1 = Math.max(n + rob2, rob1);
            rob2 = temp;
        }
        return rob1;
    }
}
