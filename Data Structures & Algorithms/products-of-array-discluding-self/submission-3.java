class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int count=0;
        int index=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                index=i;
                count++;
                if(count==1) continue;
            }
            product *= nums[i];
        }
        if(count>0) {
            int[] arr = new int[nums.length];
            Arrays.fill(arr, 0);
            arr[index] = product;
            return arr;
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = product/nums[i];
        }
        return nums;
    }
}  
