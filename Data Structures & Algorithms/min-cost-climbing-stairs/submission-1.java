class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int next1 = cost[n-2];
        int next2 = cost[n-1];

        for(int i = n-3; i >= 0; i--) {
            int temp = next1;
            next1 = cost[i] + Math.min(next1, next2);
            next2 = temp;
        }

        return Math.min(next1, next2);  
    }
}
