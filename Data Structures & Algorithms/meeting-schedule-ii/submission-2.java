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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();
        int res = 0;
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.end)
        );
        for(int i = 0; i < n; i++) {
            Interval curr = intervals.get(i);
            while(!pq.isEmpty() && pq.peek().end <= curr.start) {
                pq.poll();
            }
            pq.offer(curr);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
