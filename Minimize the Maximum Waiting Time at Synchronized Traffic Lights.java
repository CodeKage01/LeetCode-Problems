class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;
        for(int light:lights){
            maxLight = Math.max(maxLight, light);
        }

        int ans = 0;

        for(int time:arrivalTime){
            int r = time % period;
            int waiting;
            if(r < maxLight){
                waiting = 0;
            }else{
                waiting = period - r;
            }
            ans = Math.max(ans, waiting);
        }
        return ans;
    }
}
