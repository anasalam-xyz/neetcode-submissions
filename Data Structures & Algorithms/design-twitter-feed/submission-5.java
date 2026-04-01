class Twitter {
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> follows;
    private int index;
    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        index = 0;
    }
    
    private void initializeUser(int user) {
        follows.computeIfAbsent(user, k -> new HashSet<>()).add(user);
        tweets.computeIfAbsent(user, k ->  new ArrayList<>());
    }

    public void postTweet(int userId, int tweetId) {
        initializeUser(userId);
        tweets.get(userId).add(new int[] {index, tweetId});
        index++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        initializeUser(userId);
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(int user: follows.get(userId))
            for(int[] tweet: tweets.get(user))
                pq.offer(tweet);
        int i = 0;
        while(!pq.isEmpty() && i<10) {
            newsFeed.add(pq.poll()[1]);
            i++;
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        initializeUser(followerId);
        initializeUser(followeeId);
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        follows.get(followerId).remove(followeeId);
    }
}
