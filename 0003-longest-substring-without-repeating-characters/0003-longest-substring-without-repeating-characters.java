class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n=s.length();
        int left=0;
        int maxLength=0;

        HashSet<Character> hs=new HashSet<>();

        for(int right=0;right < n;right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxLength=Math.max(maxLength, right-left+1);
        }
        return maxLength;
        
    }
}