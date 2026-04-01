class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if(!dfs(0, -1, graph, visited))
            return false;

        for(boolean v: visited)
            if(!v) return false;

        return true;
    }
    private boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        if(visited[node]) return false;
        visited[node] = true;
        for(int nei: graph.get(node)) {
            if(nei == parent) continue;
            if(!dfs(nei, node, graph, visited))
                return false;
        }
        return true;
    }
}
