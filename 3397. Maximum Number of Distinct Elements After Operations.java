class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long last = Long.MIN_VALUE;
        int count = 0;

        for(int num:nums){
            long low = num-k;
            long high = num+k;

            long choose = Math.max(low, last+1);

            if(choose <= high){
                count++;
                last = choose;
            }
        }
        return count;
    }
}
