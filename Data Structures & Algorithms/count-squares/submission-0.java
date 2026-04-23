class CountSquares {
    private Map<String, Integer> points;
    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = createKey(point);
        points.put(key, points.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x1 = point[0], y1 = point[1];
        for(Map.Entry<String, Integer> p: points.entrySet()) {
            int[] qp = decodeKey(p.getKey());
            int x2 = qp[0], y2 = qp[1];
            if(Math.abs(x2 - x1) == Math.abs(y2 - y1) && (x2 - x1) != 0) {
                int x3 = x1, y3 = y2;
                int x4 = x2, y4 = y1;
                String key3 = createKey(new int[] {x3, y3});
                String key4 = createKey(new int[] {x4, y4});
                if(!points.containsKey(key3) || !points.containsKey(key4))
                    continue;
                res += (
                    p.getValue() * 
                    points.get(key3) * 
                    points.get(key4)
                );
            }
        }

        return res;
    }

    private String createKey(int[] point) {
        return (
            String.valueOf(point[0]) + "," + String.valueOf(point[1])
        );
    }

    private int[] decodeKey(String key) {
        int i = 0;
        while(key.charAt(i) != ',')
            i++;
        return (new int[] {
            Integer.parseInt(key.substring(0, i)),
            Integer.parseInt(key.substring(i + 1, key.length()))
        });
    }
}
