class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int x = 0, y = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(x>=nums1.length) {
                nums[i] = nums2[y];
                y++;
                continue;
            }
            if(y>=nums2.length) {
                nums[i] = nums1[x];
                x++;
                continue;
            }
            if(nums1[x]<=nums2[y]) {
                nums[i] = nums1[x];
                x++;
            }
            else {
                nums[i] = nums2[y];
                y++;
            }
        }
        if(n%2 == 0)
            return (double)(nums[n/2] + nums[n/2-1])/2;
        return nums[n/2];

    }
}
