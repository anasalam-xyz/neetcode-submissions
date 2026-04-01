class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int count=0;
        int index=0;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                index=i;
                count++;
                if(count>1)
                    return result;
                continue;
            }
            product *= nums[i];
        }
        if(count>0) {
            result[index] = product;
            return result;
        }
        for(int i=0;i<nums.length;i++) {
            result[i] = product/nums[i];
        }
        return result;
    }
}  
