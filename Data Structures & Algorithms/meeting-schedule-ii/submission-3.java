/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            Interval curr = intervals.get(i);
            start[i] = curr.start;
            end[i] = curr.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int res = 0;
        int s = 0, e = 0;
        while(s < n) {
            if(start[s] < end[e]) {
                s++;
                count++;
            }
            else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }
        
        return res;
    }
}
