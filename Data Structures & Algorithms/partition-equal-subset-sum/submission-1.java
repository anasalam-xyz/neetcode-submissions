class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i = nums.length-1; i >= 0; i--) {
            Set<Integer> temp = new HashSet<>();
            for(int n: dp) {
                if(n + nums[i] == sum) return true;
                temp.add(n + nums[i]);
                temp.add(n);
            }
            dp = temp;
        }

        return false;
    }
}
