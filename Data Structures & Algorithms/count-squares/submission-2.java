class CountSquares {
    private Map<Integer, Map<Integer, Integer>> points;
    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x1 = point[0], y1 = point[1];
        if(!points.containsKey(x1)) return 0;
        Map<Integer, Integer> yMap = points.get(x1);
        for(int y2: yMap.keySet()) {
            if(y2 == y1) continue;
            int side = y2 - y1;
            int x2 = x1 + side;
            int x3 = x1 - side;
            int countVertical = yMap.get(y2);

            if(points.containsKey(x2)) {
                res += (
                    countVertical *
                    points.get(x2).getOrDefault(y1, 0) * 
                    points.get(x2).getOrDefault(y2, 0)
                );
            }
            if(points.containsKey(x3)) {
                res += (
                    countVertical *
                    points.get(x3).getOrDefault(y1, 0) * 
                    points.get(x3).getOrDefault(y2, 0)
                );
            }
        }
        return res;
    }
}
