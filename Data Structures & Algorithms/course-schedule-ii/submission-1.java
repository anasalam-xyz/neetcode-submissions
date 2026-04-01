class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] cycle = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for(int[] pre: prerequisites)
            graph.get(pre[0]).add(pre[1]);

        for(int i = 0; i < numCourses; i++)
            if(!dfs(i, graph, visited, cycle, res))
                return new int[0];

        return res.stream().mapToInt(i->i).toArray();
    }
    private boolean dfs(int i, List<List<Integer>> graph, boolean[] visited, boolean[] cycle, List<Integer> res) {
        if(cycle[i]) return false;
        if(visited[i]) return true;
        
        cycle[i] = true;
        for(int pre: graph.get(i))
            if(!dfs(pre, graph, visited, cycle, res))
                return false;

        cycle[i] = false;
        visited[i] = true;
        res.add(i);

        return true;
    }
}
