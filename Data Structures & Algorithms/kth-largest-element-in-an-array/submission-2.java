class Solution {
    private int k;
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        return quickSelect(nums, 0, nums.length-1);
    }
    private int quickSelect(int[] nums, int l, int r) {
        int pivot = nums[r];
        int p = l;
        for(int i=l;i<r;i++) {
            if(nums[i]<=pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;

        int target = nums.length - k;
        if(p<target)
            return quickSelect(nums, p+1, r);
        else if(p>target)
            return quickSelect(nums, l, p-1);
        else
            return nums[p];
    }
}
