class Solution {
    public boolean[] transformStr(String s, String[] strs) {

        int n = s.length();

        // Prefix count of 1's in source string
        int[] sourcePrefix = new int[n];
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
            sourcePrefix[i] = totalOnes;
        }

        boolean[] ans = new boolean[strs.length];

        for (int idx = 0; idx < strs.length; idx++) {

            char[] arr = strs[idx].toCharArray();

            int fixedOnes = 0;
            int questions = 0;

            // Count fixed 1's and '?'
            for (char ch : arr) {
                if (ch == '1') {
                    fixedOnes++;
                } else if (ch == '?') {
                    questions++;
                }
            }

            // Impossible to match total number of 1's
            if (totalOnes < fixedOnes || totalOnes > fixedOnes + questions) {
                ans[idx] = false;
                continue;
            }

            // Extra 1's that must be placed
            int need = totalOnes - fixedOnes;

            // Put required 1's at the rightmost '?'
            for (int i = n - 1; i >= 0 && need > 0; i--) {
                if (strs[idx].charAt(i) == '?') {
                    arr[i] = '1';
                    need--;
                }
            }
            // Replace remaining ? with 0
            for (int i = 0; i < n; i++) {
                if (arr[i] == '?') {
                    arr[i] = '0';
                }
            }

            // Prefix validation
            int prefixOnes = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    prefixOnes++;
                }

                if (prefixOnes > sourcePrefix[i]) {
                    possible = false;
                    break;
                }
            }

            ans[idx] = possible;
        }

        return ans;
    }
}
