class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if(n < 2) return 0;

        int[] incStart = new int[n];
        incStart[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            if(nums.get(i) < nums.get(i+1)){
                incStart[i] = incStart[i+1] + 1;
            }else{
                incStart[i] = 1;
            }
        }

        // binary search
        int l=0,h=n/2;
        int ans = 0;

        while(l<=h){
            int mid = l+(h-l)/2;
            if(canDo(mid,incStart,n)){
                ans = mid;
                l = mid+1;
            }else{
                h=mid-1;
            }
        }

        return ans;
    }

    private boolean canDo(int k, int[] incStart, int n){
        if(k==0) return true;
        for(int a=0;a+2*k <= n;a++){
            if(incStart[a] >= k && incStart[a+k] >= k) return true;
        }

        return false;
    }
}
