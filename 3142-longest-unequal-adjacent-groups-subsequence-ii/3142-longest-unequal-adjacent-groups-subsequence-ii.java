class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        // Graph adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Build graph: edges from i to j if i < j and valid transition
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hammingDistance(words[i], words[j]) == 1) {
                    
                    graph.get(i).add(j); // i -> j
                }
            }
        }

        // DP array to store the length of the longest path ending at each node
        int[] dp = new int[n];
        int[] prev = new int[n]; // to reconstruct the path
        Arrays.fill(dp, 1); // Every word is at least a path of length 1
        Arrays.fill(prev, -1);

        int maxLen = 1, endIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int next : graph.get(i)) {
                if (dp[i] + 1 > dp[next]) {
                    dp[next] = dp[i] + 1;
                    prev[next] = i;
                    if (dp[next] > maxLen) {
                        maxLen = dp[next];
                        endIndex = next;
                    }
                }
            }
        }

        // Reconstruct the path
        LinkedList<String> result = new LinkedList<>();
        while (endIndex != -1) {
            result.addFirst(words[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }

    private int hammingDistance(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}