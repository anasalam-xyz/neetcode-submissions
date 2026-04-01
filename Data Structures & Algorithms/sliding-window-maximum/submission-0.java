class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++) {
            for(int j=0;j<k;j++) {
                heap.add(nums[i+j]);
            }
            res[i] = heap.peek();
            heap.clear();
        }
        return res;
    }
}
