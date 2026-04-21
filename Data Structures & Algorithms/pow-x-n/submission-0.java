class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1.0 / x;
            n *= -1;
        }
        double res = 1;
        for(int i = 0; i < n; i++) {
            res *= x;
        }
        return res; 
    }
}
