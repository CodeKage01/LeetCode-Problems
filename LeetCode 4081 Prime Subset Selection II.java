class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        // Find primes

        List<Integer> primes = new ArrayList<>();
        for(int i =2;i<=n; i++){
            boolean prime = true;

            for(int j=2;j*j <= i;j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                primes.add(i);
            }
        }

        // dp[sum] stores best subset for this
        List<Integer>[] dp = new ArrayList[s+1];
        dp[0] = new ArrayList<>();

        for(int p:primes){
            for(int sum=s;sum>=p;sum--){
                if(dp[sum-p] == null){
                    continue;
                }

                List<Integer> candidate = new ArrayList<>(dp[sum-p]);
                candidate.add(p);

                if(dp[sum] == null || candidate.size() < dp[sum].size() || (
                    candidate.size() == dp[sum].size() && smaller(candidate, dp[sum])
                )){
                    dp[sum] = candidate;
                }
            }
        }

        for(int sum=s;sum>0;sum--){
            if(dp[sum] != null){
                return dp[sum];
            }
        }
        return new ArrayList<>();
    }

    private boolean smaller(List<Integer> a, List<Integer> b){
        for(int i=0;i<a.size();i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i) < b.get(i);
            }
        }
        return false;
    }
}
