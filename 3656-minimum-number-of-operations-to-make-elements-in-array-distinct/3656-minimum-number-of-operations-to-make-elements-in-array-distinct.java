class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        // Try removing 0, 3, 6, ... elements from the beginning
        for (int i = 0; i <= n; i += 3) {
            Set<Integer> seen = new HashSet<>();
            boolean allDistinct = true;

            // Check if subarray nums[i...n-1] is all distinct
            for (int j = i; j < n; j++) {
                if (seen.contains(nums[j])) {
                    allDistinct = false;
                    break;
                }
                seen.add(nums[j]);
            }

            if (allDistinct) {
                return i / 3;
            }
        }

        // Worst case: need to remove entire array
        return (n + 2) / 3;
    
        
    }
}