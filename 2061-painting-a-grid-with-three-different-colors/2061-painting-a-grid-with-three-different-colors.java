class Solution {

    private static final int MOD=1_000_000_007;
    public int colorTheGrid(int m, int n) {

        List<int[]> patterns = new ArrayList<>();
        Map<String, Integer> patternIndex = new HashMap<>();

        // Generate all valid patterns for one column
        generatePatterns(m, new int[m], 0, patterns, patternIndex);

        int pLen = patterns.size();
        int[][] compatible = new int[pLen][pLen];

        // Precompute compatible patterns
        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (areCompatible(patterns.get(i), patterns.get(j))) {
                    compatible[i][j] = 1;
                }
            }
        }

        // Initialize DP table
        int[] dp = new int[pLen];
        Arrays.fill(dp, 1);  // First column, each pattern is valid once

        // Process n-1 columns
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[pLen];
            for (int i = 0; i < pLen; i++) {
                for (int j = 0; j < pLen; j++) {
                    if (compatible[i][j] == 1) {
                        newDp[j] = (newDp[j] + dp[i]) % MOD;
                    }
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int count : dp) {
            result = (result + count) % MOD;
        }

        return result;
    }

    // Generate all valid column patterns with no adjacent same colors
    private void generatePatterns(int m, int[] curr, int pos, List<int[]> patterns, Map<String, Integer> indexMap) {
        if (pos == m) {
            int[] pattern = Arrays.copyOf(curr, m);
            patterns.add(pattern);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (pos == 0 || curr[pos - 1] != color) {
                curr[pos] = color;
                generatePatterns(m, curr, pos + 1, patterns, indexMap);
            }
        }
    }

    // Check if two column patterns are compatible (no same color in same row)
    private boolean areCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    


        
    }
}