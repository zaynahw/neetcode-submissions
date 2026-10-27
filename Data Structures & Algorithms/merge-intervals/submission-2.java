class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> newIntervals = new ArrayList<>();
        if (intervals == null || intervals.length == 0) { return newIntervals.toArray(new int[0][]); }

        // sort based on starting intervals
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int trackStart = intervals[0][0];
        int trackEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart >= trackStart && currStart <= trackEnd) {
                trackEnd = Math.max(trackEnd, currEnd);
            } else {
                newIntervals.add(new int[]{trackStart, trackEnd});
                trackStart = currStart;
                trackEnd = currEnd;
            }
        }

        newIntervals.add(new int[]{trackStart, trackEnd});


        return newIntervals.toArray(new int[0][]);
        
    }
}
