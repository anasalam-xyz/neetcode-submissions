class TimeMap {
    private Map<String, Map<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) 
            timeMap.put(key, new HashMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) 
            return "";
        Map<Integer, String> map = timeMap.get(key);
        for(int i = timestamp;i>0;i--) {
            if(map.containsKey(i))
                return map.get(i);
        }
        return "";
    }
}
