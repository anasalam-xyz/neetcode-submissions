class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] res = new int[nums.length];
        int preP=1;
        int postP=1;
        for(int i=0;i<nums.length;i++) {
            preP*=nums[i];
            pre[i]=preP;
        }
        for(int i=nums.length-1;i>=0;i--) {
            postP*=nums[i];
            post[i]=postP;
        }
        for(int i=0;i<nums.length;i++) {
            res[i] = (i==0?1:pre[i-1])*(i==nums.length-1?1:post[i+1]);
        }
        return res;
    }
}  
