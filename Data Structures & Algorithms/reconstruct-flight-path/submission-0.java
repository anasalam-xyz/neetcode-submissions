class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> graph = new HashMap<>();
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");
        if(dfs("JFK", graph, res, tickets.size()+1))
            return res;

        return new ArrayList<>();
    }

    private boolean dfs(String src, Map<String, List<String>> graph, List<String> res, int ticketLen) {
        if(ticketLen == res.size())
            return true;
        if(!graph.containsKey(src))
            return false;
        
        List<String> temp = new ArrayList<>(graph.get(src));
        for(int i = 0; i < temp.size(); i++) {
            String to = temp.get(i);
            graph.get(src).remove(i);
            res.add(to);
            if(dfs(to, graph, res, ticketLen))
                return true;
            graph.get(src).add(i, to);
            res.remove(res.size()-1);
        }
        return false;
    }
}
