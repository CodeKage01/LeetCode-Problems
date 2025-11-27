class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];

        for(int i=0;i<k;i++){
            minPrefix[i] = Long.MAX_VALUE;
        }

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        minPrefix[0] = 0;

        for(int i=0;i<nums.length;i++){
            prefix += nums[i];
            int rem = (i+1)%k;

            if(minPrefix[rem] != Long.MAX_VALUE){
                ans = Math.max(ans, prefix - minPrefix[rem]);
            }

            minPrefix[rem] = Math.min(minPrefix[rem], prefix);
        }

        return ans;
    }
}
