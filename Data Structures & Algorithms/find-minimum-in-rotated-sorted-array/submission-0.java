class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int min = nums[0];
        int m = 0;
        while(l<=r) {
            m = l + (r-l)/2;
            if(nums[l]>nums[r])
                if(nums[m]>nums[r])
                    l = m+1;
                else
                    r = m;
            else
                return nums[l];
        }
        return nums[m];
    }
}
