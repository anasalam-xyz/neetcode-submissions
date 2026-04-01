class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> res) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, perm, res);
            perm.remove(perm.size()-1);
            used[i] = false;
        }
    }
}
