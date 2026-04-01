class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int preP=1;
        int postP=1;
        for(int i=0;i<nums.length;i++) {
            res[i]=preP;
            preP*=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--) {
            res[i]*=postP;
            postP*=nums[i];
        }
        return res;
    }
}  
