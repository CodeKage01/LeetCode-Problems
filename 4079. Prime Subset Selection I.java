class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        int remainingSum = s;
        List<Integer> ans = new ArrayList<>();

        for(int p:primes){
            if(remainingSum >= p){
                ans.add(p);
                remainingSum-= p;
            }else{
                break;
            }
        }
        return ans;
    }
}
