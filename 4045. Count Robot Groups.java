class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int groups = 0;
        int n = position.length;

        int rightPos = Integer.MAX_VALUE;
        int rightSpeed = Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--){
            int curPos = position[i];
            int curSpeed = speed[i];

            if(rightPos - curPos > distance && curSpeed <= rightSpeed){
                groups++;
                rightSpeed = curSpeed;
            }
            rightPos = curPos;
        }
        return groups;
    }
}
