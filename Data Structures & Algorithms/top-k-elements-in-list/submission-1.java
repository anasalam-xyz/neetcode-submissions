class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> arr = new ArrayList<>();
        int[] res = new int[k];
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0)+1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        arr.sort((a, b) -> b[0]-a[0]);
        for(int i=0;i<k;i++)
            res[i] = arr.get(i)[1];
        return res;
    }
}
