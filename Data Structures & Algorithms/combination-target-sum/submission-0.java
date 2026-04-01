class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int[] nums, int target, List<Integer> combo, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        for(int i=start;i<nums.length;i++) {
            combo.add(nums[i]);
            backtrack(i, nums, target-nums[i], combo, res);
            combo.remove(combo.size()-1);
        }
    }
}
