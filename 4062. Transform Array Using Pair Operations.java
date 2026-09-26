class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sourceSum = 0;
        long targetSum = 0;

        for(int i=0;i<source.length;i++){
            sourceSum+= source[i];
            targetSum+= target[i];
        }

        return sourceSum == targetSum;
    }
}
