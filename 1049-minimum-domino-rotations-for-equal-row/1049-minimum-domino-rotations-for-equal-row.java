class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1) return result;
        // Only check bottoms[0] if it's different from tops[0]
        if (tops[0] != bottoms[0]) {
            return check(bottoms[0], tops, bottoms);
        }
        return -1;
    }
     private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;
        int n = tops.length;

        for (int i = 0; i < n; i++) {
            // If neither side has the target value, it's impossible
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            // If top is not the target, we would need to rotate it
            if (tops[i] != target) rotateTop++;
            // If bottom is not the target, we would need to rotate it
            if (bottoms[i] != target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
        
    }
}