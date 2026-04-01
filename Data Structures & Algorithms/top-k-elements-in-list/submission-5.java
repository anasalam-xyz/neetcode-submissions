class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) 
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int len = nums.length;
        List<Integer>[] buckets = new ArrayList[len + 1];
        for(int i = 0; i <= len; i++)
            buckets[i] = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freq.entrySet())
            buckets[entry.getValue()].add(entry.getKey());
        int index = 0;
        int[] res = new int[k];
        for(int i = len; i > 0 && index < k; i--) {
            for(int num: buckets[i]) {
                res[index] = num;
                index++;
                if(index == k)
                    return res;
            }
        }
        return res;
    }
}
