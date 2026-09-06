class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n/2;

        long totalSum = 0;
        for(int num:nums){
            totalSum+= num;
        }

        long firstHalfSum = 0;

        for(int i=0;i<half;i++){
            firstHalfSum+= nums[i];
        }

        int count = 0;

        for(int start=0;start<n;start++){
            long secondHalfSum = totalSum - firstHalfSum;
            if(firstHalfSum > secondHalfSum){
                count++;
            }

            int elementToRmemove = nums[start];
            int elementToAdd = nums[(start+half)%n];

            firstHalfSum-= elementToRmemove;
            firstHalfSum+= elementToAdd;
        }
        return count;
    }
}
