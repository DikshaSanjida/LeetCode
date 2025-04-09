class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1;
        }

        // Step 2: Put elements into TreeSet in descending order to process unique values
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Count the number of valid operations needed to reduce all values to k
        int operations = 0;
        while (!set.isEmpty()) {
            int max = set.first();
            if (max == k) break;
            set.pollFirst(); // Remove the current max value

            // After removing max, the next lower value becomes the new target
            // If the new max is still >= k, it's a valid h
            if (!set.isEmpty() && set.first() >= k) {
                operations++;
            } else if (set.isEmpty()) {
                // If no values left and k is not reached, we need one more step
                operations++;
                break;
            }
        }

        return operations;
    }
}