class Solution {
    public String[] largestString(int[] nums) {
        String[] res = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            int x = nums[i];

            StringBuilder sb = new StringBuilder();

            int power = 33554432;
            while(x >= power){
                sb.append('z');
                x = x - power;
            }

            for(int k=24;k>=0;k--){
                power = power/2;

                if(x >= power){
                    sb.append((char)('a' + k));
                    x = x - power;
                }
            }

            res[i] = sb.toString();
        }
        return res;
    }
}
