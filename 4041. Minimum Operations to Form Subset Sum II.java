class Solution {
    int n;
    int[] nums;
    int[][] dp;

    public int minOperations(int[] nums, int sum) {
        this.nums = nums;
        this.n = nums.length;
        dp = new int[n][sum+1];

        for(int[] r:dp){
            Arrays.fill(r, -1);
        }

        int ans = solve(0, sum);

        return ans == Integer.MAX_VALUE ? -1  : ans;
    }

    private int solve(int i, int sum){
        if(sum == 0){
            return 0;
        }
        if(i == n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }

        // skip
        int ans = solve(i+1, sum);

        // option conver
        int x = nums[i];

        for(int div=0;x>0;div++,x/=2){
            int val = x;
            int ops = div;

            while(val <= sum){
                int rem = solve(i+1, sum-val);
                if(rem != Integer.MAX_VALUE){
                    ans = Math.min(ans, ops+rem);
                }
                val*=2;
                ops++;
            }
        }
        return dp[i][sum] = ans;
    }
}
