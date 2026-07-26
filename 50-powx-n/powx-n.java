class Solution {
    public double myPow(double x, int n) {
        long N = n;              
        if (N < 0) {
            x = 1 / x;            
            N = -N;                
        }
        return fastPower(x, N);
    }
    private double fastPower(double base, long exp) {
        if (exp == 0) {                        
            return 1.0;
        }
        double half = fastPower(base, exp / 2); 
        if (exp % 2 == 0) {                     
            return half * half;
        } else {                                
            return half * half * base;
        }
    }
}