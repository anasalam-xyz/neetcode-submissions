class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char task: tasks)
            counts[task - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count: counts)
            if(count>0)
                maxHeap.add(count);
        int time = 0;
        Queue<int[]> cooldown = new ArrayDeque<>();
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if(maxHeap.isEmpty()) {
                time = cooldown.peek()[1];
            }
            else {
                int count = maxHeap.poll() - 1;
                if(count>0)
                    cooldown.add(new int[] {count, time+n});
            }
            if(!cooldown.isEmpty() && cooldown.peek()[1]==time)
                maxHeap.offer(cooldown.poll()[0]);
        }
        return time;
    }
}
