class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i=0, j=0, k=nums.length-1;
        while(i<k) {
            j=i+1;
            k=nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else {   
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    Collections.sort(triplet);
                    if(!list.contains(triplet))
                        list.add(triplet);
                    j++;
                    k--;
                }
            }
            i++;
        }
        return list;
    }
}
