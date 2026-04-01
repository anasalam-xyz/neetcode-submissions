class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        rank = new int[n];
        for(int i = 1; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge: edges) {
            if(!union(edge[0], edge[1]))
                return edge;
        }
        return new int[0];
    }
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return false;
        if(rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if(rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
    private int find(int node) {
        int cur = node;
        while(parent[cur] != cur) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }
}
