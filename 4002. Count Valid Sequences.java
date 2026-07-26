class Solution {

    static final int MOD = 1_000_000_007;

    public int countValidSequences(int n, int k) {

        // factorial[i] = i!
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        // Total = C(n-1, k-1)
        long total = combination(n - 1, k - 1, factorial);

        long odd = 0;

        // Total Odd sequences
        if ((n - k) % 2 == 0) {
            int top = (n + k - 2) / 2;
            odd = combination(top, k - 1, factorial);
        }

        return (int) ((total - odd + MOD) % MOD);
    }

    private long combination(int n, int r, long[] factorial) {

        if (r < 0 || r > n)
            return 0;

        long numerator = factorial[n];

        long denominator = (factorial[r] * factorial[n - r]) % MOD;

        return (numerator * power(denominator, MOD - 2)) % MOD;
    }

    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;

            exp >>= 1;
        }

        return result;
    }
}
