class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = series1.length;
        int m = series2.length;
        int i = 0, j = 0;

        while (i < n || j < m) {

            int CurrentTime;

            if (j == m || (i < n && series1[i][0] < series2[j][0])) {
                CurrentTime = series1[i][0];
            } else if (i == n || series2[j][0] < series1[i][0]) {
                CurrentTime = series2[j][0];
            } else {
                CurrentTime = series1[i][0];
            }

            int value1, value2;

            if (i < n) {
                value1 = series1[i][1];
                if (series1[i][0] == CurrentTime) i++;
            } else {
                value1 = 0;
            }

            if (j < m) {
                value2 = series2[j][1];
                if (series2[j][0] == CurrentTime) j++;
            } else {
                value2 = 0;
            }

            ans.add(Arrays.asList(CurrentTime, value1 + value2));
        }

        return ans;
    }
}
