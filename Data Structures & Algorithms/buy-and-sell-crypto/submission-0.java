class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0, r = 1;
        while(r<prices.length) {
            int profit = prices[r]-prices[l];
            if(profit<=0) 
                l=r;
            res = Math.max(res, profit);
            r++;    
        }
        return res;
    }
}
