class Solution {
    public long mostPoints(int[][] questions) {

        int n=questions.length;
        long[] dp=new long[n];

        for(int i=n-1; i>=0; i--){
            int points = questions[i][0];
            int brainpower = questions[i][1];

            int nextIndex= i + brainpower +1;
            long take= points + (nextIndex < n ? dp[nextIndex] : 0);

            long skip=(i+1<n) ? dp[i+1]:0;

            dp[i]=Math.max(take, skip);
        }

        return dp[0];
        
    }
}