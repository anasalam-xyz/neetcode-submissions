class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for(int[] pre: prerequisites)
            graph.get(pre[0]).add(pre[1]);
        for(int i = 0; i < numCourses; i++) 
            if(!dfs(i, graph, visited))
                return false;

        return true;
    }
    private boolean dfs(int i, List<List<Integer>> graph, boolean[] visited) {
        if(visited[i]) return false;
        if(graph.get(i).isEmpty()) return true;

        visited[i] = true;
        for(int pre: graph.get(i))
            if(!dfs(pre, graph, visited))
                return false;
        
        visited[i] = false;
        graph.get(i).clear();
        return true;
    }
}
