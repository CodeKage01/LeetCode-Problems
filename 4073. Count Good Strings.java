class Solution {
    long mod = 1_000_000_007;
    public int countGoodStrings(long n) {
        long[] res = fib(n);

        return (int)((2*res[0]) % mod);
    }

    // Returns {F(n), F(n+1)}
    private long[] fib(long n){
        if(n == 0){
            return new long[]{0, 1};
        }

        long[] pair = fib(n/2);

        long a = pair[0]; // F(k)
        long b = pair[1]; // F(k+1)

        // F(2k)
        long c = (a * ((2*b % mod - a + mod) % mod)) % mod;

        // F(2k+1)
        long d = (a*a % mod + b*b % mod) % mod;

        if(n % 2 == 0){
            return new long[]{c, d};
        }else{
            return new long[]{d, (c+d) % mod};
        }
    }
}
