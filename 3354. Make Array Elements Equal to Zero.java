class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                if(check(nums, i, 1)) count++;
                if(check(nums, i, -1)) count++;
            }
        }
        return count;
    }

    private boolean check(int[] nums, int start, int dir){
        int n = nums.length;
        int[] temp = nums.clone();
        int cur = start;
        int d = dir;

        while(cur >= 0 && cur < n){
            if(temp[cur] == 0){
                cur+= d;
            }else{
                temp[cur]--;
                d = -d;
                cur+= d;
            }
        }

        for(int val: temp){
            if(val != 0) return false;
        }
        return true;
    }
}
