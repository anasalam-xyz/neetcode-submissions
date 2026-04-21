class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        long N = n;
        double res = 1;
        if(N < 0) {
            x = 1 / x;
            N *= -1;
        }
        while(N > 0) {
            if(N% 2 != 0) res *= x;
            x = x * x;
            N /= 2;
        }
        return res;
    }
}
