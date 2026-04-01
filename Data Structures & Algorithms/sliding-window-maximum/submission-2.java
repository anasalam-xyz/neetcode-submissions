class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int l = 0, r = 0;
        while(r<nums.length) {
            while(!q.isEmpty() && nums[q.peekLast()]<nums[r])
                q.pollLast();
            q.addLast(r);
            if((r-l+1)>=k) {
                res[l]=nums[q.peekFirst()];
                l++;
            }
            if(l>q.peekFirst())
                q.pollFirst();
            r++;
        }
        return res;
    }
}
