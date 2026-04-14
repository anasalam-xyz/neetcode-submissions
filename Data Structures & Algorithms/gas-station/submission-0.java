class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if(sum < 0) return -1;
        int curr = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            curr += gas[i] - cost[i];
            if(curr < 0) {
                curr = 0;
                idx = i+1;
            }
        }
        return idx;
    }
}
