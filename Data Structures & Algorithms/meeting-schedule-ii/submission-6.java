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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.offer(intervals.get(i).end);

            while(!pq.isEmpty() && pq.peek() <= intervals.get(i).start)
                pq.poll();

            res = Math.max(res, pq.size());
        }

        return res;
    }
}
