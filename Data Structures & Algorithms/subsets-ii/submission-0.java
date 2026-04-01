class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++) {
            if(i > start && nums[i-1] == nums[i])
                continue;
            subset.add(nums[i]);
            backtrack(nums, i+1, subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
