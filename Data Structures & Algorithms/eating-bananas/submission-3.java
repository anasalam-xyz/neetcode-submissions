class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0];           
        for(int p: piles) 
            r = Math.max(r, p);
        int k = 1;
        while(l<r) {
            int hours = 0;
            k = l+(r-l)/2;
            for(int p: piles) 
                hours += (p+k-1)/k;
            if(hours<=h)
                r = k;
            else
                l = k+1;
        }
        
        return l;
    }
}
