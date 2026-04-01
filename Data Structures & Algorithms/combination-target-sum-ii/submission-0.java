class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, combo, res);
        return res;
    }
    private void backtrack(int[] candidates, int i, int target, List<Integer> combo, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if(target < 0 || i >= candidates.length) return;
        
        combo.add(candidates[i]);
        backtrack(candidates, i+1, target-candidates[i], combo, res);
        combo.remove(combo.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1])
            i++;
        backtrack(candidates, i+1, target, combo, res);
    }
}
