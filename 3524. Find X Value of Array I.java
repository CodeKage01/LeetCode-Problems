class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];

        long[] dp = new long[k];

        for(int num: nums){
            long[] next = new long[k];

            int value = num % k;
            next[value]++;

            for(int r=0;r<k;r++){
                int newRem = (r*value) % k;
                next[newRem]+= dp[r];
            }

            for(int r=0;r<k;r++){
                res[r]+= next[r];
            }
            dp = next;
        }
        return res;
    }
}
