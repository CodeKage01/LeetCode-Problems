class Solution {
    public long maximumTotalDamage(int[] power) {
        if(power == null || power.length == 0) return 0L;

        Map<Integer,Long> total = new HashMap<>();
        for(int v:power){
            total.put(v, total.getOrDefault(v, 0L) + (long)v);
        }

        List<Integer> vals = new ArrayList<>(total.keySet());
        Collections.sort(vals);
        int n = vals.size();
        if(n==0) return 0L;

        long[] dp = new long[n];

        dp[0] = total.get(vals.get(0));

        for(int i=1;i<n;i++){
            long take = total.get(vals.get(i));

            //binary search
            int l=0,h=i-1,j=-1;
            int limit = vals.get(i)-2;

            while(l<=h){
                int mid = l+(h-l)/2;
                if(vals.get(mid) < limit){
                    j = mid;
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
            if(j!=-1) take += dp[j];

            long skip = dp[i-1];

            dp[i] = Math.max(take,skip);
        }

        return dp[n-1];
    }
}
