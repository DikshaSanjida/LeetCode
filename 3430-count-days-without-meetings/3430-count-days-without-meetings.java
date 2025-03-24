class Solution {
    public int countDays(int days, int[][] meetings) {
        //Set<Integer> meetingDays=new HashSet<>();

        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

        int busyDays=0;
        int prevEnd=0;

        for(int [] meeting : meetings){
            int start=meeting[0], end=meeting[1];

            if(start > prevEnd){
                busyDays += (end - start+1);
                prevEnd=end;
            }else if(end > prevEnd){
                busyDays += (end - prevEnd);
                prevEnd=end;
            }
        }

        return days- busyDays;
           
        
    }
}