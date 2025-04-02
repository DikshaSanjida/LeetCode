class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTripletValue = 0;
        
        int maxLeft = nums[0];
        int[] maxRight = new int[n];
        
        // Precompute maxRight[i], which stores the maximum value in nums[i+1...n-1]
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        
        // Iterate through the array to find max (nums[i] - nums[j]) * nums[k]
        for (int j = 1; j < n - 1; j++) {
            maxLeft = Math.max(maxLeft, nums[j - 1]);
            long tripletValue = (long) (maxLeft - nums[j]) * maxRight[j + 1];
            maxTripletValue = Math.max(maxTripletValue, tripletValue);
        }
        
        return maxTripletValue;
    }
}