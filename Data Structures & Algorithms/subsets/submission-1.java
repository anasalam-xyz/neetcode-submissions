class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(i+1, nums, subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
