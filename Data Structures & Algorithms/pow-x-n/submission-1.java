class Solution {
    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));
        if(n < 0) return 1 / res;
        return res;
    }
    private double helper(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        
        double res = helper(x*x, n/2);
        if(n%2 != 0) return res * x;
        return res;
    }
}
