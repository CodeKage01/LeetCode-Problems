class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;

        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int ans = 1;

        for(int j=1;j<n;j++){
            for(int i=0;i<j;i++){
                boolean valid = true;

                for(int row=0;row<m;row++){
                    if(Math.abs(grid[row][j] - grid[row][i]) > limit){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    lis[j] = Math.max(lis[i]+1, lis[j]);
                }
            }
        }
        for(int val:lis){
            ans = Math.max(ans, val);
        }
        return ans;
    }
}
