class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTripletValue = 0;

        int maxLeft = nums[0];
        int maxDiff = Integer.MIN_VALUE;

        for (int j = 1; j < n - 1; j++){
            maxDiff = Math.max(maxDiff, maxLeft - nums[j]);
            long tripletValue = (long) maxDiff * nums[j + 1];

            maxTripletValue = Math.max(maxTripletValue, tripletValue);
            maxLeft = Math.max(maxLeft, nums[j]);

        } 
        return maxTripletValue;
    }
}