class Solution {
    public int lengthAfterTransformations(String s, int t) {

        final int MOD = 1_000_000_007;

        // dp[c][i] = length of string starting with character c after i transformations
        int[][] dp = new int[26][t + 1];

        // Base case: 0 transformations = length 1
        for (int c = 0; c < 26; c++) {
            dp[c][0] = 1;
        }

        // Fill dp table
        for (int i = 1; i <= t; i++) {
            for (int c = 0; c < 26; c++) {
                if (c == 25) { // 'z'
                    dp[c][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD; // "ab"
                } else {
                    dp[c][i] = dp[c + 1][i - 1]; // next character
                }
            }
        }

        // Sum up the total length for all characters in s
        long total = 0;
        for (char ch : s.toCharArray()) {
            total = (total + dp[ch - 'a'][t]) % MOD;
        }

        return (int) total;
    }
}