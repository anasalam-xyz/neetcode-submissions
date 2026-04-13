class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int steps = 0;

        while(l <= r && r < n-1) {
            int maxJump = 0;
            for(int i = l; i <= r; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            l = r + 1;
            r = maxJump;
            steps++;
        }

        return steps;
    }
}
